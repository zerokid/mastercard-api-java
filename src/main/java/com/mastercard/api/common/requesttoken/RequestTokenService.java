package com.mastercard.api.common.requesttoken;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.common.OAuthParameters;
import com.mastercard.api.common.apiexception.MCApiRuntimeException;
import com.mastercard.api.common.requesttoken.domain.RequestTokenResponse;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;

public class RequestTokenService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/oauth/consumer/v1/request_token";
    private static final String PRODUCTION_URL = "";

    private static final String OAUTH_CALLBACK = "oauth_callback";
    private static final String REALM = "realm";
    private static final String REALM_TYPE = "eWallet";
    private static final String REQUEST_AUTH_URL = "xoauth_request_auth_url";
    private static final String OAUTH_TOKEN = "oauth_token";
    private static final String OAUTH_CALLBACK_CONFIRMED = "oauth_callback_confirmed";
    private static final String OAUTH_EXPIRES_IN = "oauth_expires_in";
    private static final String OAUTH_TOKEN_SECRET = "oauth_token_secret";

    public RequestTokenService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    private String getUrl() {
        switch(environment) {
            case PRODUCTION:
                return PRODUCTION_URL;
            case SANDBOX:
                return SANDBOX_URL;
            default:
                return null;
        }
    }
    
    public RequestTokenResponse getRequestTokenResponse() {
    	RequestTokenResponse response = getRequestTokenResponse("http://projectabc.com");
    	return response;
    }
    
    public RequestTokenResponse getRequestTokenResponse(String callbackUrl) {
        OAuthParameters params = OAuthParametersFactory();
        params.addParameter(OAUTH_CALLBACK, callbackUrl);
        params.addParameter(REALM, REALM_TYPE);
        String response = doRequest(getUrl(), POST, params, "").get(MESSAGE);
        return parseRequestTokenResponse(response);
    }

    private RequestTokenResponse parseRequestTokenResponse(String responseParameters) {
        RequestTokenResponse requestTokenResponse = new RequestTokenResponse();

        if (responseParameters == null) {
            throw new MCApiRuntimeException(NULL_RESPONSE_PARAMETERS_ERROR);
        }

        Map<String, String> requestTokenResponseParameters = new HashMap<String, String>();
        String[] parameters = responseParameters.split(AMP);

        for (String parameter : parameters) {
            String[] keyValue = parameter.split(EQUALS);
            if (keyValue.length == 2) {
                requestTokenResponseParameters.put(keyValue[0], keyValue[1]);
            }
            // if the keyValue length is not 2 then they will be ignored
        }

        try {
            requestTokenResponse.setAuthorizationUrl(URLDecoder.decode(requestTokenResponseParameters.get(REQUEST_AUTH_URL), UTF_8));
        } catch (UnsupportedEncodingException e) {
            throw new MCApiRuntimeException(e);
        }
        requestTokenResponse.setOauthToken(requestTokenResponseParameters.get(OAUTH_TOKEN));
        requestTokenResponse.setOauthCallbackConfirmed(requestTokenResponseParameters.get(OAUTH_CALLBACK_CONFIRMED));
        requestTokenResponse.setOauthExpiresIn(requestTokenResponseParameters.get(OAUTH_EXPIRES_IN));
        requestTokenResponse.setOauthTokenSecret(requestTokenResponseParameters.get(OAUTH_TOKEN_SECRET));

        return requestTokenResponse;
    }
}

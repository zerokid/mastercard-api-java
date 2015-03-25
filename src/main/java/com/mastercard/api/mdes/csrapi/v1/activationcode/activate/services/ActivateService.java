package com.mastercard.api.mdes.csrapi.v1.activationcode.activate.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.mdes.csrapi.v1.activationcode.activate.domain.ActivateRequest;
import com.mastercard.api.mdes.csrapi.v1.activationcode.activate.domain.Response;

import java.security.PrivateKey;
import java.util.Map;

public class ActivateService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/mdes/csrapi/v1/activationcode/activate?Format=XML";
    private static final String MTF_URL = "https://api.mastercard.com/mdes/csrapi/mtf/v1/activationcode/activate?Format=XML";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/mdes/csrapi/v1/activationcode/activate?Format=XML";

    public ActivateService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    public Response getResponse(ActivateRequest activateRequest) {
        Map<String, String> responseMap = doRequest(
                getURL(),
                POST,
                xmlToString(activateRequest)
        );
        String response = responseMap.get(MESSAGE);
        return (Response) stringToXml(response, Response.class);
    }

    private String getURL(){
        if (this.environment == Environment.PRODUCTION) {
            return PRODUCTION_URL;
        } else if (this.environment == Environment.MTF) {
            return MTF_URL;
        } else {
            return SANDBOX_URL;
        }
    }

}

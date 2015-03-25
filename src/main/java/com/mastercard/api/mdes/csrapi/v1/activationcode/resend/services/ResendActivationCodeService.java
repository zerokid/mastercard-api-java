package com.mastercard.api.mdes.csrapi.v1.activationcode.resend.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.mdes.csrapi.v1.activationcode.resend.domain.ResendCodeResults;
import com.mastercard.api.mdes.csrapi.v1.activationcode.resend.domain.ResendRequest;

import java.security.PrivateKey;
import java.util.Map;

public class ResendActivationCodeService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/mdes/csrapi/v1/{tokenuniqueid}/activationcode/resend?Format=XML";
    private static final String MTF_URL = "https://api.mastercard.com/mdes/csrapi/mtf/v1/{tokenuniqueid}/activationcode/resend?Format=XML";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/mdes/csrapi/v1/{tokenuniqueid}/activationcode/resend?Format=XML";

    public ResendActivationCodeService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    public ResendCodeResults getResendCodeResults(ResendRequest resendRequest, String tokenUniqueId) {
        Map<String, String> responseMap = doRequest(
                getURL(tokenUniqueId),
                POST,
                xmlToString(resendRequest)
        );
        String response = responseMap.get(MESSAGE);
        return (ResendCodeResults) stringToXml(response, ResendCodeResults.class);
    }

    private String getURL(String tokenUniqueId){
        String url;
        if (this.environment == Environment.PRODUCTION) {
            url =  PRODUCTION_URL;
        } else if (this.environment == Environment.MTF) {
            url =  MTF_URL;
        } else {
            url =  SANDBOX_URL;
        }
        return url.replace("{tokenuniqueid}", tokenUniqueId);
    }

}

package com.mastercard.api.mdes.csrapi.v1.pan.swap.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.mdes.csrapi.v1.pan.swap.domain.Responses;
import com.mastercard.api.mdes.csrapi.v1.pan.swap.domain.SwapPANRequest;

import java.security.PrivateKey;
import java.util.Map;

public class SwapPANService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/mdes/csrapi/v1/pan/swap?Format=XML";
    private static final String MTF_URL = "https://api.mastercard.com/mdes/csrapi/mtf/v1/pan/swap?Format=XML";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/mdes/csrapi/v1/pan/swap?Format=XML";

    public SwapPANService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    public Responses getResponses(SwapPANRequest swapPANRequest) {
        Map<String, String> responseMap = doRequest(
                getURL(),
                POST,
                xmlToString(swapPANRequest)
        );
        String response = responseMap.get(MESSAGE);
        return (Responses) stringToXml(response, Responses.class);
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

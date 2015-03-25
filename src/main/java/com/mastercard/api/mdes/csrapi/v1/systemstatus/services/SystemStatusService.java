package com.mastercard.api.mdes.csrapi.v1.systemstatus.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.mdes.csrapi.v1.systemstatus.domain.SystemStatusResponses;

import java.security.PrivateKey;
import java.util.Map;

public class SystemStatusService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/mdes/csrapi/v1/systemstatus?Format=XML";
    private static final String MTF_URL = "https://api.mastercard.com/mdes/csrapi/mtf/v1/systemstatus?Format=XML";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/mdes/csrapi/v1/systemstatus?Format=XML";

    public SystemStatusService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    public SystemStatusResponses getSystemStatusResponses() {
        Map<String, String> responseMap = doRequest(
                getURL(),
                GET,
                null
        );
        String response = responseMap.get(MESSAGE);
        return (SystemStatusResponses) stringToXml(response, SystemStatusResponses.class);
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

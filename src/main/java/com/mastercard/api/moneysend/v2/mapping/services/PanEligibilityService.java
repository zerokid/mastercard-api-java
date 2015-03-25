package com.mastercard.api.moneysend.v2.mapping.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.moneysend.v2.mapping.domain.PanEligibility;
import com.mastercard.api.moneysend.v2.mapping.domain.PanEligibilityRequest;

import java.security.PrivateKey;
import java.util.Map;

public class PanEligibilityService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/moneysend/v2/eligibility/pan?Format=XML";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/moneysend/v2/eligibility/pan?Format=XML";

    public PanEligibilityService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    public PanEligibility getPanEligibility(PanEligibilityRequest panEligibilityRequest) {
        Map<String,String> responseMap = doRequest(
                getURL(),
                PUT,
                xmlToString(panEligibilityRequest)
        );
        String response = responseMap.get(MESSAGE);
        return (PanEligibility) stringToXml(response, PanEligibility.class);
    }

    private String getURL() {
        String url;
        if (this.environment == Environment.PRODUCTION) {
            url = PRODUCTION_URL;
        } else {
            url =  SANDBOX_URL;
        }
        return url;
    }

}

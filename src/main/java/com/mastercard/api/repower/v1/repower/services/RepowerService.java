package com.mastercard.api.repower.v1.repower.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.repower.v1.repower.domain.Repower;
import com.mastercard.api.repower.v1.repower.domain.RepowerRequest;

import java.security.PrivateKey;
import java.util.Map;

public class RepowerService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/repower/v1/repower";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/repower/v1/repower";

    /**
     * Creates RepowerService object
     * @param environment - Environment.SANDBOX or Environment.PRODUCTION depending on intended data to use
     * @param consumerKey - Consumer Key for services
     * @param privateKey - PK for services
     */

    public RepowerService(Environment environment, String consumerKey, PrivateKey privateKey){
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    /**
     * Returns Repower object containing information pertaining to loading of funds via Repower service
     * @param request - RepowerRequest object containing information required for load.
     * @return - Repower object containing information pertaining to loading of funds via Repower service
     */

    public Repower getRepower(RepowerRequest request){
        Map<String,String> responseMap = doRequest(
                getURL(),
                POST,
                xmlToString(request)
        );
        String response = responseMap.get(MESSAGE);
        return (Repower) stringToXml(response, Repower.class);
    }

    private String getURL(){
        if (this.environment == Environment.PRODUCTION){
            return PRODUCTION_URL;
        } else {
            return SANDBOX_URL;
        }
    }
}

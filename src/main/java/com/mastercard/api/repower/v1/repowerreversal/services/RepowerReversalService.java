package com.mastercard.api.repower.v1.repowerreversal.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.repower.v1.repowerreversal.domain.RepowerReversal;
import com.mastercard.api.repower.v1.repowerreversal.domain.RepowerReversalRequest;

import java.security.PrivateKey;
import java.util.Map;

public class RepowerReversalService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/repower/v1/repowerreversal?Format=XML";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/repower/v1/repowerreversal?Format=XML";

    /**
     * Constructs Repower Reversal service.
     * @param environment - Environment.SANDBOX or Environment.PRODUCTION based on
     * @param consumerKey - consumer key provided for services
     * @param privateKey - private key provided for servicesd
     */

    public RepowerReversalService(Environment environment, String consumerKey, PrivateKey privateKey){
        super(consumerKey,privateKey);
        this.environment = environment;
    }

    /**
     * Returns Reversal transaction information for reversing previously loaded repower funds
     * @param request - request containing previous repower load information as well as reversal reason
     * @return - RepowerReversal object containing reversal information for this transaction.
     */

    public RepowerReversal getRepowerReversal(RepowerReversalRequest request){
        Map<String, String> responseMap = doRequest(
                getURL(),
                POST,
                xmlToString(request)
        );
        String response = responseMap.get(MESSAGE);
        return (RepowerReversal) stringToXml(response, RepowerReversal.class);
    }

    private String getURL(){
        if (this.environment == Environment.PRODUCTION){
            return PRODUCTION_URL;
        } else {
            return SANDBOX_URL;
        }
    }
}

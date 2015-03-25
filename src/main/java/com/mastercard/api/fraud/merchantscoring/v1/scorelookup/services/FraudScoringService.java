package com.mastercard.api.fraud.merchantscoring.v1.scorelookup.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.fraud.merchantscoring.v1.scorelookup.domain.ScoreLookup;
import com.mastercard.api.fraud.merchantscoring.v1.scorelookup.domain.ScoreLookupRequest;

import java.security.PrivateKey;
import java.util.Map;

public class FraudScoringService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/fraud/merchantscoring/v1/score-lookup";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/fraud/merchantscoring/v1/score-lookup";

    /**
     * @param environment - Environment.SANDBOX or Environment.PRODUCTION depending on data set wished for use
     * @param consumerKey -
     * @param privateKey -
     */

    public FraudScoringService(Environment environment, String consumerKey, PrivateKey privateKey){
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    /**
     * Method to return Fraud Scoring results based on a ScoreLookupRequest POJO.
     * @param request - ScoreLookupRequest containing query information
     * @return - ScoreLookup POJO containing scoring information
     */

    public ScoreLookup getScoreLookup(ScoreLookupRequest request){
        Map<String, String> responseMap = doRequest(
                getURL(),
                PUT,
                xmlToString(request)
        );
        String response = responseMap.get(MESSAGE);
        return (ScoreLookup) stringToXml(response, ScoreLookup.class);
    }

    private String getURL(){
        if (this.environment == Environment.PRODUCTION) {
            return PRODUCTION_URL;
        } else {
            return SANDBOX_URL;
        }
    }
}

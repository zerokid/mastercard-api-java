package com.mastercard.api.location.v1.atms.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.location.v1.common.domain.Countries;

import java.security.PrivateKey;
import java.util.Map;

public class CountryAtmLocationService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/atms/v1/country?Format=XML";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/atms/v1/country?Format=XML";

    public CountryAtmLocationService(Environment environment, String consumerKey, PrivateKey privateKey){
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    public Countries getCountries(){
        Map<String,String> responseMap = doRequest(
                getURL(),
                GET,
                null
        );
        String response = responseMap.get(MESSAGE);
        return (Countries) stringToXml(response, Countries.class);
    }

    private String getURL(){
        if (environment.equals(Environment.PRODUCTION)){
            return PRODUCTION_URL;
        } else {
            return SANDBOX_URL;
        }
    }

}

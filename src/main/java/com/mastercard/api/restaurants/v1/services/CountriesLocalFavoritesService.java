package com.mastercard.api.restaurants.v1.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.restaurants.v1.domain.Countries;

import java.security.PrivateKey;
import java.util.Map;

public class CountriesLocalFavoritesService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/restaurants/v1/country?Format=XML";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/restaurants/v1/country?Format=XML";

    /**
     * @param environment - Environment.SANDBOX or Environment.PRODUCTION depending on data set wished for use
     * @param consumerKey -
     * @param privateKey -
     */

    public CountriesLocalFavoritesService(Environment environment, String consumerKey, PrivateKey privateKey){
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    /**
     * Method to return the available restaurant categories
     * @return A list of categories
     */
    public Countries getCountries(){
        Map<String, String> responseMap = doRequest(
                getURL(),
                GET,
                null
        );

        String response = responseMap.get(MESSAGE);
        return (Countries)stringToXml(response, Countries.class);
    }

    private String getURL(){
        if (this.environment == Environment.PRODUCTION) {
            return PRODUCTION_URL;
        } else {
            return SANDBOX_URL;
        }
    }
}

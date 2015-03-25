package com.mastercard.api.restaurants.v1.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.restaurants.v1.domain.Categories;

import java.security.PrivateKey;
import java.util.Map;

public class CategoriesLocalFavoritesService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/restaurants/v1/category?Format=XML";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/restaurants/v1/category?Format=XML";

    /**
     * @param environment - Environment.SANDBOX or Environment.PRODUCTION depending on data set wished for use
     * @param consumerKey -
     * @param privateKey -
     */

    public CategoriesLocalFavoritesService(Environment environment, String consumerKey, PrivateKey privateKey){
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    /**
     * Method to return the available restaurant categories
     * @return A list of categories
     */
    public Categories getCategories(){
        Map<String, String> responseMap = doRequest(
                getURL(),
                GET,
                null
        );

        String response = responseMap.get(MESSAGE);
        return (Categories)stringToXml(response, Categories.class);
    }

    private String getURL(){
        if (this.environment == Environment.PRODUCTION) {
            return PRODUCTION_URL;
        } else {
            return SANDBOX_URL;
        }
    }
}

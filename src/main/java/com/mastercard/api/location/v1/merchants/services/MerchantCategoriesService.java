package com.mastercard.api.location.v1.merchants.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.location.v1.merchants.domain.Categories;

import java.security.PrivateKey;
import java.util.Map;

public class MerchantCategoriesService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/merchants/v1/category?Format=XML";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/merchants/v1/category?Format=XML";

    public MerchantCategoriesService(Environment environment, String consumerKey, PrivateKey privateKey){
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    public Categories getCategories(){
        Map<String,String> responseMap = doRequest(
                getURL(),
                GET,
                null
        );
        String response = responseMap.get(MESSAGE);
        return (Categories) stringToXml(response, Categories.class);
    }

    private String getURL(){
        if (this.environment.equals(Environment.PRODUCTION)){
            return PRODUCTION_URL;
        } else {
            return SANDBOX_URL;
        }
    }

}

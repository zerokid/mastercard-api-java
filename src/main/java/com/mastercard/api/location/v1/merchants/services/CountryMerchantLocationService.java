package com.mastercard.api.location.v1.merchants.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.common.util.URLUtil;
import com.mastercard.api.location.v1.common.domain.Countries;
import com.mastercard.api.location.v1.merchants.domain.options.CountryMerchantLocationRequestOptions;

import java.security.PrivateKey;
import java.util.Map;

public class CountryMerchantLocationService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/merchants/v1/country?Format=XML";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/merchants/v1/country?Format=XML";

    public CountryMerchantLocationService(Environment environment, String consumerKey, PrivateKey privateKey){
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    public Countries getCountries(CountryMerchantLocationRequestOptions options){
        Map<String,String> responseMap = doRequest(
                getURL(options),
                GET,
                null
        );
        String response = responseMap.get(MESSAGE);
        return (Countries) stringToXml(response, Countries.class);
    }

    private String getURL(CountryMerchantLocationRequestOptions options){
        String url;
        if (this.environment.equals(Environment.PRODUCTION)){
            url = PRODUCTION_URL;
        } else {
            url = SANDBOX_URL;
        }
        return URLUtil.addQueryParameter(url, "Details", options.getDetails());
    }

}

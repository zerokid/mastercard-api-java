package com.mastercard.api.location.v1.merchants.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.common.util.URLUtil;
import com.mastercard.api.location.v1.common.domain.CountrySubdivisions;
import com.mastercard.api.location.v1.merchants.domain.options.CountrySubdivisionMerchantLocationRequestOptions;

import java.security.PrivateKey;
import java.util.Map;

public class CountrySubdivisionMerchantLocationService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/merchants/v1/countrysubdivision?Format=XML";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/merchants/v1/countrysubdivision?Format=XML";

    public CountrySubdivisionMerchantLocationService(Environment environment, String consumerKey, PrivateKey privateKey){
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    public CountrySubdivisions getCountrySubdivisions(CountrySubdivisionMerchantLocationRequestOptions options){
        Map<String,String> responseMap = doRequest(
                getURL(options),
                GET,
                null
        );
        String response = responseMap.get(MESSAGE);
        return (CountrySubdivisions) stringToXml(response, CountrySubdivisions.class);
    }

    private String getURL(CountrySubdivisionMerchantLocationRequestOptions options){
        String url;
        if (this.environment.equals(Environment.PRODUCTION)){
            url = PRODUCTION_URL;
        } else {
            url = SANDBOX_URL;
        }
        url = URLUtil.addQueryParameter(url, "Details", options.getDetails());
        return URLUtil.addQueryParameter(url, "Country", options.getCountry());
    }

}

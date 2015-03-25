package com.mastercard.api.location.v1.atms.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.common.util.URLUtil;
import com.mastercard.api.location.v1.atms.domain.options.CountrySubdivisionAtmLocationRequestOptions;
import com.mastercard.api.location.v1.common.domain.CountrySubdivisions;

import java.security.PrivateKey;
import java.util.Map;

public class CountrySubdivisionAtmLocationService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/atms/v1/countrysubdivision?Format=XML";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/atms/v1/countrysubdivision?Format=XML";

    public CountrySubdivisionAtmLocationService(Environment environment, String consumerKey, PrivateKey privateKey){
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    public CountrySubdivisions getCountrySubdivisions(CountrySubdivisionAtmLocationRequestOptions options){
        Map<String,String> responseMap = doRequest(
                getURL(options),
                GET,
                null
        );
        String response = responseMap.get(MESSAGE);
        return (CountrySubdivisions) stringToXml(response, CountrySubdivisions.class);
    }

    private String getURL(CountrySubdivisionAtmLocationRequestOptions options){
        String url;
        if (this.environment.equals(Environment.PRODUCTION)){
            url = PRODUCTION_URL;
        } else {
            url = SANDBOX_URL;
        }
        return URLUtil.addQueryParameter(url, "Country", options.getCountry());
    }
}

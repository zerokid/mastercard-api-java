package com.mastercard.api.restaurants.v1.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.common.util.URLUtil;
import com.mastercard.api.restaurants.v1.domain.CountrySubdivisions;
import com.mastercard.api.restaurants.v1.domain.options.CountrySubdivisionsLocalFavoritesOptions;

import java.security.PrivateKey;
import java.util.Map;

public class CountrySubdivisionsLocalFavoritesService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/restaurants/v1/countrysubdivision?Format=XML";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/restaurants/v1/countrysubdivision?Format=XML";

    /**
     * @param environment - Environment.SANDBOX or Environment.PRODUCTION depending on data set wished for use
     * @param consumerKey -
     * @param privateKey -
     */

    public CountrySubdivisionsLocalFavoritesService(Environment environment, String consumerKey, PrivateKey privateKey){
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    /**
     * Method to return the available restaurant categories
     * @return A list of categories
     */
    public CountrySubdivisions getCountrySubdivisions(CountrySubdivisionsLocalFavoritesOptions options){
        Map<String, String> responseMap = doRequest(
                getURL(options),
                GET,
                null
        );

        String response = responseMap.get(MESSAGE);
        return (CountrySubdivisions)stringToXml(response, CountrySubdivisions.class);
    }

    private String getURL(CountrySubdivisionsLocalFavoritesOptions options){
        String url;
        if (this.environment == Environment.PRODUCTION) {
            url = PRODUCTION_URL;
        } else {
            url = SANDBOX_URL;
        }

        url = URLUtil.addQueryParameter(url, "Country", options.getCountry());
        return url;
    }
}
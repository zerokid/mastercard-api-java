package com.mastercard.api.restaurants.v1.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.common.util.URLUtil;
import com.mastercard.api.restaurants.v1.domain.Restaurants;
import com.mastercard.api.restaurants.v1.domain.options.RestaurantsLocalFavoritesOptions;

import java.security.PrivateKey;
import java.util.Map;

public class RestaurantsLocalFavoritesService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/restaurants/v1/restaurant?Format=XML";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/restaurants/v1/restaurant?Format=XML";

    /**
     * @param environment - Environment.SANDBOX or Environment.PRODUCTION depending on data set wished for use
     * @param consumerKey -
     * @param privateKey -
     */

    public RestaurantsLocalFavoritesService(Environment environment, String consumerKey, PrivateKey privateKey){
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    public Restaurants getRestaurants(RestaurantsLocalFavoritesOptions options){
        Map<String,String> responseMap = doRequest(
                getURL(options),
                GET,
                null
        );
        String response = responseMap.get(MESSAGE);
        return (Restaurants) stringToXml(response, Restaurants.class);

    }

    private String getURL(RestaurantsLocalFavoritesOptions options){
        String url;
        if (this.environment == Environment.PRODUCTION) {
            url = PRODUCTION_URL;
        } else {
            url = SANDBOX_URL;
        }

        url = URLUtil.addQueryParameter(url, "PageOffset", options.getPageOffset().toString());
        url = URLUtil.addQueryParameter(url, "PageLength", options.getPageLength().toString());
        if(options.getCategory() != null) {
            url = URLUtil.addQueryParameter(url, "Category", options.getCategory());
        }
        url = URLUtil.addQueryParameter(url, "AddressLine1", options.getAddressLine1());
        url = URLUtil.addQueryParameter(url, "AddressLine2", options.getAddressLine2());
        url = URLUtil.addQueryParameter(url, "City", options.getCity());
        url = URLUtil.addQueryParameter(url, "CountrySubdivision", options.getCountrySubdivision());
        url = URLUtil.addQueryParameter(url, "PostalCode", options.getPostalCode());
        url = URLUtil.addQueryParameter(url, "Country", options.getCountry());
        url = URLUtil.addQueryParameter(url, "DistanceUnit", options.getDistanceUnit());
        url = URLUtil.addQueryParameter(url, "Latitude", String.valueOf(options.getLatitude()));
        url = URLUtil.addQueryParameter(url, "Longitude", String.valueOf(options.getLongitude()));
        url = URLUtil.addQueryParameter(url, "Radius", String.valueOf(options.getRadius()));

        return url;
    }
}

package com.mastercard.api.restaurants.v1.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.restaurants.v1.domain.Restaurants;
import com.mastercard.api.restaurants.v1.domain.options.RestaurantsLocalFavoritesOptions;
import junit.framework.TestCase;
import utils.TestUtils;

public class RestaurantsLocalFavoritesServiceTest extends TestCase {

    TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    RestaurantsLocalFavoritesService service;
    RestaurantsLocalFavoritesOptions options;

    public void setUp(){
        options = new RestaurantsLocalFavoritesOptions(0, 10);
        this.service = new RestaurantsLocalFavoritesService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
    }

    public void testRestaurantServiceByPostalCode(){
        options.setPostalCode("63119");
        options.setCountry("USA");
        Restaurants restaurants = service.getRestaurants(options);
        assertTrue(restaurants.getRestaurantList() != null && restaurants.getRestaurantList().size() > 0);
        assertTrue(testUtils.validateXML(restaurants, "restaurants.xsd"));
    }

    public void testRestaurantServiceByAddress(){
        options.setAddressLine1("201 Highlands Blvd Dr");
        options.setCity("Manchester");
        options.setCountrySubdivision("MO");
        options.setCountry("USA");
        Restaurants restaurants = service.getRestaurants(options);
        assertTrue(restaurants.getRestaurantList() != null && restaurants.getRestaurantList().size() > 0);
        assertTrue(testUtils.validateXML(restaurants, "restaurants.xsd"));
    }

    public void testRestaurantServiceByLatLon(){
        options.setLatitude(41.378612);
        options.setLongitude(-88.251114);

        Restaurants restaurants = service.getRestaurants(options);
        assertTrue(restaurants.getRestaurantList() != null && restaurants.getRestaurantList().size() > 0);
        assertTrue(testUtils.validateXML(restaurants, "restaurants.xsd"));
    }
}

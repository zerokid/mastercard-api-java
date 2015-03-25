package com.mastercard.api.restaurants.v1.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.restaurants.v1.domain.Countries;
import junit.framework.TestCase;
import utils.TestUtils;

public class CountriesLocalFavoritesServiceTest extends TestCase {

    TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    CountriesLocalFavoritesService service;

    public void setUp(){
        this.service = new CountriesLocalFavoritesService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
    }

    public void testCountryMerchantLocationService(){
        Countries countries = service.getCountries();
        assertTrue(countries.getCountryList() != null && countries.getCountryList().size() > 0);
        assertTrue(testUtils.validateXML(countries, "countries.xsd"));
    }
}

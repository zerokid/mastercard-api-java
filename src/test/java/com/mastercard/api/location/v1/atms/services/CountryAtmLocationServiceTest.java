package com.mastercard.api.location.v1.atms.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.location.v1.common.domain.Countries;
import junit.framework.TestCase;
import utils.TestUtils;

public class CountryAtmLocationServiceTest extends TestCase {
    TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    CountryAtmLocationService service;

    public void setUp(){
        service = new CountryAtmLocationService(Environment.SANDBOX,
                testUtils.getConsumerKey(), testUtils.getPrivateKey());
    }

    public void testCountryAtmLocationService(){
        Countries countries = service.getCountries();
        assertTrue(countries != null && countries.getCountry().size() > 0);
        assertTrue(testUtils.validateXML(countries,"countries.xsd"));
    }
}

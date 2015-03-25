package com.mastercard.api.restaurants.v1.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.restaurants.v1.domain.CountrySubdivisions;
import com.mastercard.api.restaurants.v1.domain.options.CountrySubdivisionsLocalFavoritesOptions;
import junit.framework.TestCase;
import utils.TestUtils;

public class CountrySubdivisionsLocalFavoritesServiceTest extends TestCase {
    TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    CountrySubdivisionsLocalFavoritesService service;

    public void setUp(){
        this.service = new CountrySubdivisionsLocalFavoritesService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
    }

    public void testCountrySubdivisionAtmLocationService(){
        CountrySubdivisionsLocalFavoritesOptions options = new CountrySubdivisionsLocalFavoritesOptions(
                "USA"
        );

        CountrySubdivisions countrySubdivisions = service.getCountrySubdivisions(
                options
        );
        assertTrue(countrySubdivisions.getCountrySubdivisionList() != null &&
                countrySubdivisions.getCountrySubdivisionList().size() > 0);
        assertTrue(testUtils.validateXML(countrySubdivisions, "countrySubdivisions.xsd"));
    }
}

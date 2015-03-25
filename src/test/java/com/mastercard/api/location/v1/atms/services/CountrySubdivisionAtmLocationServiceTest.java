package com.mastercard.api.location.v1.atms.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.location.v1.atms.domain.options.CountrySubdivisionAtmLocationRequestOptions;
import com.mastercard.api.location.v1.common.domain.CountrySubdivisions;
import junit.framework.TestCase;
import utils.TestUtils;

public class CountrySubdivisionAtmLocationServiceTest extends TestCase {
    TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    CountrySubdivisionAtmLocationService service;

    public void setUp(){
        this.service = new CountrySubdivisionAtmLocationService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
    }

    public void testCountrySubdivisionAtmLocationService(){
        CountrySubdivisionAtmLocationRequestOptions options = new CountrySubdivisionAtmLocationRequestOptions(
                "USA"
        );
        CountrySubdivisions countrySubdivisions = service.getCountrySubdivisions(
                options
        );
        assertTrue(countrySubdivisions.getCountrySubdivision() != null &&
                countrySubdivisions.getCountrySubdivision().size() > 0);
        assertTrue(testUtils.validateXML(countrySubdivisions, "countrySubdivisions.xsd"));
    }
}

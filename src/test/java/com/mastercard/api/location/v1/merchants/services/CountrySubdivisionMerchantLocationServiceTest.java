package com.mastercard.api.location.v1.merchants.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.location.v1.common.domain.CountrySubdivisions;
import com.mastercard.api.location.v1.merchants.domain.options.CountrySubdivisionMerchantLocationRequestOptions;
import com.mastercard.api.location.v1.merchants.domain.options.Details;
import junit.framework.TestCase;
import utils.TestUtils;

public class CountrySubdivisionMerchantLocationServiceTest extends TestCase {

    TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    CountrySubdivisionMerchantLocationService service;
    CountrySubdivisionMerchantLocationRequestOptions options;

    public void setUp(){
        service = new CountrySubdivisionMerchantLocationService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
    }

    public void testCountrySubdivisionMerchantLocationServiceWithPaypass(){
        options = new CountrySubdivisionMerchantLocationRequestOptions(
                Details.ACCEPTANCE_PAYPASS,
                "USA"
        );
        CountrySubdivisions countrySubdivisions = service.getCountrySubdivisions(
                options
        );
        assertTrue(countrySubdivisions.getCountrySubdivision() != null &&
                countrySubdivisions.getCountrySubdivision().size() > 0);
        assertTrue(testUtils.validateXML(countrySubdivisions,"countrySubdivisions.xsd"));
    }

    public void testCountrySubdivisionMerchantLocationServiceWithOffers(){
        options = new CountrySubdivisionMerchantLocationRequestOptions(
                Details.OFFERS_EASYSAVINGS,
                "USA"
        );
        CountrySubdivisions countrySubdivisions = service.getCountrySubdivisions(
                options
        );
        assertTrue(countrySubdivisions.getCountrySubdivision() != null &&
                countrySubdivisions.getCountrySubdivision().size() > 0);
        assertTrue(testUtils.validateXML(countrySubdivisions,"countrySubdivisions.xsd"));
    }

    public void testCountrySubdivisionMerchantLocationServiceWithPrepaidTravelCard(){
        options = new CountrySubdivisionMerchantLocationRequestOptions(
                Details.PRODUCTS_PREPAID_TRAVEL_CARD,
                "USA"
        );
        CountrySubdivisions countrySubdivisions = service.getCountrySubdivisions(
                options
        );
        assertTrue(countrySubdivisions.getCountrySubdivision() != null &&
                countrySubdivisions.getCountrySubdivision().size() > 0);
        assertTrue(testUtils.validateXML(countrySubdivisions,"countrySubdivisions.xsd"));
    }

    public void testCountrySubdivisionMerchantLocationServiceWithRepower(){
        options = new CountrySubdivisionMerchantLocationRequestOptions(
                Details.TOPUP_REPOWER,
                "USA"
        );
        CountrySubdivisions countrySubdivisions = service.getCountrySubdivisions(
                options
        );
        assertTrue(countrySubdivisions.getCountrySubdivision() != null &&
                countrySubdivisions.getCountrySubdivision().size() > 0);
        assertTrue(testUtils.validateXML(countrySubdivisions,"countrySubdivisions.xsd"));
    }
}

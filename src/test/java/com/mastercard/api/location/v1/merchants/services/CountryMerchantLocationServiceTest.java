package com.mastercard.api.location.v1.merchants.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.location.v1.common.domain.Countries;
import com.mastercard.api.location.v1.merchants.domain.options.CountryMerchantLocationRequestOptions;
import com.mastercard.api.location.v1.merchants.domain.options.Details;
import junit.framework.TestCase;
import utils.TestUtils;

public class CountryMerchantLocationServiceTest extends TestCase {

    TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    CountryMerchantLocationService service;
    CountryMerchantLocationRequestOptions options;

    public void setUp(){
        this.service = new CountryMerchantLocationService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
        this.options = new CountryMerchantLocationRequestOptions(
                Details.ACCEPTANCE_PAYPASS
        );
    }

    public void testCountryMerchantLocationService(){
        Countries countries = service.getCountries(options);
        assertTrue(countries.getCountry() != null && countries.getCountry().size() > 0);
        assertTrue(testUtils.validateXML(countries, "countries.xsd"));
    }

}

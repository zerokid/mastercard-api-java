package com.mastercard.api.location.v1.merchants.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.location.v1.merchants.domain.Merchants;
import com.mastercard.api.location.v1.merchants.domain.options.Details;
import com.mastercard.api.location.v1.merchants.domain.options.MerchantLocationRequestOptions;
import junit.framework.TestCase;
import utils.TestUtils;

public class MerchantLocationServiceTest extends TestCase {

    MerchantLocationRequestOptions options;
    TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    MerchantLocationService service;

    public void setUp(){
        service = new MerchantLocationService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
    }

    public void testMerchantLocationServiceRepower(){
        options = new MerchantLocationRequestOptions(
                Details.TOPUP_REPOWER,
                0,
                25
        );
        options.setCountry("USA");
        options.setPostalCode("22122");
        Merchants merchants = service.getMerchants(
                options
        );
        assertTrue(merchants != null && merchants.getMerchant().size() > 0);
        assertTrue(testUtils.validateXML(merchants, "merchants.xsd"));
    }

    /*// At the time of the creation of this SDK, PPTC was not returning
    // valid results. Passing of this test implies that PPTC has begun to return
    // valid results and that no SDK changes are needed.
    public void testMerchantLocationServicePrepaidTravelCardFail(){
        options = new MerchantLocationRequestOptions(
                Details.PRODUCTS_PREPAID_TRAVEL_CARD,
                0,
                25
        );
        options.setCountry("USA");
        options.setPostalCode("20006");
        Merchants merchants = service.getMerchants(
                options
        );
        assertTrue(merchants != null && merchants.getMerchant().size() > 0);
        assertTrue(testUtils.validateXML(merchants, "merchants.xsd"));
    }*/

    // At the time of the creation of this SDK, PPTC was not returning valid results
    // Comment out this unit test once it does.
    public void testMerchantLocationServicePrepaidTravelCardPass(){
        options = new MerchantLocationRequestOptions(
                Details.PRODUCTS_PREPAID_TRAVEL_CARD,
                0,
                25
        );
        options.setCountry("USA");
        options.setPostalCode("20006");
        Merchants merchants = service.getMerchants(
                options
        );
        assertTrue(merchants != null && merchants.getMerchant() == null);
        assertTrue(testUtils.validateXML(merchants, "merchants.xsd"));
    }

    public void testMerchantLocationServiceOffers(){
        options = new MerchantLocationRequestOptions(
                Details.OFFERS_EASYSAVINGS,
                0,
                25
        );
        options.setCountry("USA");
        options.setPostalCode("22122");
        Merchants merchants = service.getMerchants(
                options
        );
        assertTrue(merchants != null && merchants.getMerchant().size() > 0);
        assertTrue(testUtils.validateXML(merchants, "merchants.xsd"));
    }

    public void testMerchantLocationServicePaypass(){
        options = new MerchantLocationRequestOptions(
                Details.ACCEPTANCE_PAYPASS,
                0,
                25
        );
        options.setPostalCode("07032");
        options.setCountry("USA");
        Merchants merchants = service.getMerchants(
                options
        );
        assertTrue(merchants != null && merchants.getMerchant().size() > 0);
        assertTrue(testUtils.validateXML(merchants, "merchants.xsd"));
    }

    public void testMerchantLocationServiceCashback(){
        options = new MerchantLocationRequestOptions(
                Details.FEATURES_CASHBACK,
                0,
                25
        );
        options.setPostalCode("46323");
        options.setCountry("USA");
        Merchants merchants = service.getMerchants(
                options
        );
        assertTrue(merchants != null && merchants.getMerchant().size() > 0);
        assertTrue(testUtils.validateXML(merchants, "merchants.xsd"));
    }

    public void testInternationalMaestroAccepted(){
        options = new MerchantLocationRequestOptions(
                Details.FEATURES_CASHBACK,
                0,
                25
        );
        options.setPostalCode("46323");
        options.setCountry("USA");
        options.setInternationalMaestroAccepted(true);
        Merchants merchants = service.getMerchants(options);
        assertTrue(merchants != null && merchants.getMerchant().size() > 0);
        assertTrue(testUtils.validateXML(merchants, "merchants.xsd"));
    }
}

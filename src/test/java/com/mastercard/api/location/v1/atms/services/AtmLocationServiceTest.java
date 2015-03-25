package com.mastercard.api.location.v1.atms.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.location.v1.atms.domain.Atms;
import com.mastercard.api.location.v1.atms.domain.options.AtmLocationRequestOptions;
import junit.framework.TestCase;
import utils.TestUtils;

public class AtmLocationServiceTest extends TestCase {

    AtmLocationRequestOptions options;
    TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    AtmLocationService service;

    public void setUp(){
        service = new AtmLocationService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
    }

    public void testGetByNumericPostalCode(){
        options = new AtmLocationRequestOptions(0,25);
        options.setPostalCode("46320");
        options.setCountry("USA");
        Atms atms = service.getAtms(options);
        assertTrue(atms.getAtm() != null && atms.getAtm().size() > 0);
        assertTrue(testUtils.validateXML(atms, "atms.xsd"));
    }

    public void testGetByForeignPostalCode(){
        options = new AtmLocationRequestOptions(0,25);
        options.setPostalCode("068897");
        options.setCountry("SGP");
        Atms atms = service.getAtms(options);
        assertTrue(atms.getAtm() != null && atms.getAtm().size() > 0);
        assertTrue(testUtils.validateXML(atms, "atms.xsd"));
    }

    public void testGetByAlphaNumericPostalCode(){
        options = new AtmLocationRequestOptions(0,25);
        options.setPostalCode("60606-6301");
        options.setCountry("USA");
        Atms atms = service.getAtms(options);
        assertTrue(atms.getAtm() != null && atms.getAtm().size() > 0);
        assertTrue(testUtils.validateXML(atms, "atms.xsd"));
    }

    public void testByLatLong(){
        options = new AtmLocationRequestOptions(0, 25);
        options.setLatitude(1.2833d);
        options.setLongitude(103.8499d);
        options.setRadius(5);
        options.setDistanceUnit(AtmLocationRequestOptions.KILOMETER);
        Atms atms = service.getAtms(options);
        assertTrue(atms.getAtm() != null && atms.getAtm().size() > 0);
        assertTrue(testUtils.validateXML(atms, "atms.xsd"));
    }

    public void testByAddress(){
        options = new AtmLocationRequestOptions(0,25);
        options.setAddressLine1("BLK 1 ROCHOR ROAD UNIT 01-640 ROCHOR ROAD");
        options.setCountry("SGP");
        Atms atms = service.getAtms(options);
        assertTrue(atms.getAtm() != null && atms.getAtm().size() > 0);
        assertTrue(testUtils.validateXML(atms, "atms.xsd"));
    }

    public void testByCity(){
        options = new AtmLocationRequestOptions(0,25);
        options.setCity("CHICAGO");
        options.setCountry("USA");
        Atms atms = service.getAtms(options);
        assertTrue(atms.getAtm() != null && atms.getAtm().size() > 0);
        assertTrue(testUtils.validateXML(atms, "atms.xsd"));
    }

    public void testByCountrySubdivision(){
        options = new AtmLocationRequestOptions(0,25);
        options.setCountrySubdivision("IL");
        options.setCountry("USA");
        Atms atms = service.getAtms(options);
        assertTrue(atms.getAtm() != null && atms.getAtm().size() > 0);
        assertTrue(testUtils.validateXML(atms, "atms.xsd"));
    }

    public void testBySupportEMV(){
        options = new AtmLocationRequestOptions(0,25);
        options.setSupportEmv(AtmLocationRequestOptions.SUPPORT_EMV_YES);
        options.setLatitude(1.2833d);
        options.setLongitude(103.8499d);
        Atms atms = service.getAtms(options);
        assertTrue(atms.getAtm() != null && atms.getAtm().size() > 0);
        assertTrue(testUtils.validateXML(atms, "atms.xsd"));
    }

}

package com.mastercard.api.fraud.loststolen.v1.service;

import com.mastercard.api.common.Environment;
import com.mastercard.api.fraud.loststolen.v1.domain.Account;
import junit.framework.TestCase;
import utils.TestUtils;

import java.security.PrivateKey;

public class LostStolenServiceTest extends TestCase {

    LostStolenService service;
    TestUtils testUtils = new TestUtils(Environment.SANDBOX);

    public void setUp(){
        PrivateKey pk = testUtils.getPrivateKey();
        service = new LostStolenService(Environment.SANDBOX,
                testUtils.getConsumerKey(),
                pk);
    }

    public void testStolen(){
        Account account = service.getLostStolen("5343434343434343");
        assertTrue(account.getStatus().equals(Boolean.TRUE.toString()));
        assertTrue(account.getListed().equals(Boolean.TRUE.toString()));
        assertTrue(account.getReasonCode().equals("S"));
        assertTrue(account.getReason().equals("STOLEN"));
        assertTrue(testUtils.validateXML(account, "account.xsd"));
    }

    public void testFraud(){
        Account account = service.getLostStolen("5105105105105100");
        assertTrue(account.getStatus().equals(Boolean.TRUE.toString()));
        assertTrue(account.getListed().equals(Boolean.TRUE.toString()));
        assertTrue(account.getReasonCode().equals("F"));
        assertTrue(account.getReason().equals("FRAUD"));
        assertTrue(testUtils.validateXML(account, "account.xsd"));
    }

    public void testLost(){
        Account account = service.getLostStolen("5222222222222200");
        assertTrue(account.getStatus().equals(Boolean.TRUE.toString()));
        assertTrue(account.getListed().equals(Boolean.TRUE.toString()));
        assertTrue(account.getReasonCode().equals("L"));
        assertTrue(account.getReason().equals("LOST"));
        assertTrue(testUtils.validateXML(account, "account.xsd"));
    }

    public void testCaptureCard(){
        Account account = service.getLostStolen("5305305305305300");
        assertTrue(account.getStatus().equals(Boolean.TRUE.toString()));
        assertTrue(account.getListed().equals(Boolean.TRUE.toString()));
        assertTrue(account.getReasonCode().equals("P"));
        assertTrue(account.getReason().equals("CAPTURE CARD"));
        assertTrue(testUtils.validateXML(account, "account.xsd"));
    }

    public void testUnauthorizedUse(){
        Account account = service.getLostStolen("6011111111111117");
        assertTrue(account.getStatus().equals(Boolean.TRUE.toString()));
        assertTrue(account.getListed().equals(Boolean.TRUE.toString()));
        assertTrue(account.getReasonCode().equals("U"));
        assertTrue(account.getReason().equals("UNAUTHORIZED USE"));
        assertTrue(testUtils.validateXML(account, "account.xsd"));
    }

    public void testCounterfeit(){
        Account account = service.getLostStolen("4444333322221111");
        assertTrue(account.getStatus().equals(Boolean.TRUE.toString()));
        assertTrue(account.getListed().equals(Boolean.TRUE.toString()));
        assertTrue(account.getReasonCode().equals("X"));
        assertTrue(account.getReason().equals("COUNTERFEIT"));
        assertTrue(testUtils.validateXML(account, "account.xsd"));
    }

    public void testNotListed(){
        Account account = service.getLostStolen("343434343434343");
        assertTrue(account.getStatus().equals(Boolean.TRUE.toString()));
        assertTrue(account.getListed().equals(Boolean.FALSE.toString()));
        assertTrue(account.getReasonCode().equals(""));
        assertTrue(account.getReason().equals(""));
        assertTrue(testUtils.validateXML(account, "account.xsd"));
    }
}

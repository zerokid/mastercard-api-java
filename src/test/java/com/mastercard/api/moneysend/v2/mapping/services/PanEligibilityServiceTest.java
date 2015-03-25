package com.mastercard.api.moneysend.v2.mapping.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.moneysend.v2.mapping.domain.PanEligibility;
import com.mastercard.api.moneysend.v2.mapping.domain.PanEligibilityRequest;
import com.mastercard.api.moneysend.v2.mapping.domain.factory.ObjectFactory;
import junit.framework.TestCase;
import utils.TestUtils;

public class PanEligibilityServiceTest extends TestCase {
    PanEligibilityService service;
    TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    ObjectFactory factory = new ObjectFactory();

    public void setUp() {
        service = new PanEligibilityService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
    }

    public void testPanEligibilityServiceSendingAccountNumber_Eligible() {
        PanEligibilityRequest requestSending = factory.createPanEligibilityRequest();
        requestSending.setSendingAccountNumber(5184680430000006L);
        PanEligibility panEligibility = service.getPanEligibility(requestSending);
        assertTrue(panEligibility != null);
        assertTrue(panEligibility.getRequestId() > 0);
        assertTrue(panEligibility.getSendingEligibility().getEligible() == true);
        assertTrue(panEligibility.getSendingEligibility().getAccountNumber() > 0);
        assertTrue(testUtils.validateXML(panEligibility, "PanEligibility.xsd"));
    }

    public void testPanEligibilityServiceReceivingAccountNumber_Eligible() {
        PanEligibilityRequest requestReceiving = factory.createPanEligibilityRequest();
        requestReceiving.setReceivingAccountNumber(5184680430000006L);
        PanEligibility panEligibility = service.getPanEligibility(requestReceiving);
        assertTrue(panEligibility != null);
        assertTrue(panEligibility.getRequestId() > 0);
        assertTrue(panEligibility.getReceivingEligibility().getEligible() == true);
        assertTrue(panEligibility.getReceivingEligibility().getAccountNumber() > 0);
        assertTrue(testUtils.validateXML(panEligibility, "PanEligibility.xsd"));
    }

    public void testPanEligibilityServiceSendingAndReceivingAccountNumber_NotEligible() {
        PanEligibilityRequest request = factory.createPanEligibilityRequest();
        request.setSendingAccountNumber(5184680990000024L);
        request.setReceivingAccountNumber(5184680060000201L);
        PanEligibility panEligibility = service.getPanEligibility(request);
        assertTrue(panEligibility != null);
        assertTrue(panEligibility.getRequestId() > 0);
        assertTrue(panEligibility.getSendingEligibility().getEligible() == false);
        assertTrue(panEligibility.getSendingEligibility().getAccountNumber() > 0);
        assertTrue(panEligibility.getRequestId() > 0);
        assertTrue(panEligibility.getReceivingEligibility().getEligible() == false);
        assertTrue(panEligibility.getReceivingEligibility().getAccountNumber() > 0);
        assertTrue(testUtils.validateXML(panEligibility, "PanEligibility.xsd"));
    }

}

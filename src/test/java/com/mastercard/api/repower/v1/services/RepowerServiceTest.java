package com.mastercard.api.repower.v1.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.repower.v1.repower.domain.Repower;
import com.mastercard.api.repower.v1.repower.domain.RepowerRequest;
import com.mastercard.api.repower.v1.repower.services.RepowerService;
import com.mastercard.api.repower.v1.repowerreversal.domain.RepowerReversal;
import com.mastercard.api.repower.v1.repowerreversal.domain.RepowerReversalRequest;
import com.mastercard.api.repower.v1.repowerreversal.services.RepowerReversalService;
import junit.framework.TestCase;
import utils.TestUtils;

import java.util.Random;

public class RepowerServiceTest extends TestCase {
    private TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    private com.mastercard.api.repower.v1.repower.domain.factory.ObjectFactory repowerFactory
            = new com.mastercard.api.repower.v1.repower.domain.factory.ObjectFactory();
    private com.mastercard.api.repower.v1.repowerreversal.domain.factory.ObjectFactory
            repowerReversalFactory = new com.mastercard.api.repower.v1.repowerreversal.domain.factory.ObjectFactory();
    private RepowerService service;
    private RepowerReversalService reversalService;
    private RepowerRequest request;
    private RepowerReversalRequest reversalRequest;

    public void setUp(){
        service = new RepowerService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
        reversalService = new RepowerReversalService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
        request = repowerFactory.createRepowerRequest();
        reversalRequest = repowerReversalFactory.createRepowerReversalRequest();
    }

    public void testRepowerService(){
        // presumably negligible chance that this will result in a duplicate reference number
        Long referenceNbr = 1000000000000000000L;
        referenceNbr += Math.abs((new Random().nextLong()) % 8999999999999999999L);

        //load
        request.setTransactionReference(String.valueOf(referenceNbr));
        request.setCardNumber(5184680430000006L);
        request.getTransactionAmount().setValue(30000);
        request.getTransactionAmount().setCurrency("840");
        request.setLocalDate("1230");
        request.setLocalTime("092435");
        request.setChannel("W");
        request.setICA("009674");
        request.setProcessorId(9000000442L);
        request.setRoutingAndTransitNumber(990442082);
        request.setMerchantType(Short.valueOf("6532"));
        request.getCardAcceptor().setName("Prepaid Load Store");
        request.getCardAcceptor().setCity("St Charles");
        request.getCardAcceptor().setState("MO");
        request.getCardAcceptor().setPostalCode("63301");
        request.getCardAcceptor().setCountry("USA");
        Repower repower = service.getRepower(request);
        assertTrue(testUtils.validateXML(repower, "repower.xsd"));

        // reverse load
        reversalRequest.setReversalReason("UNIT TEST");
        reversalRequest.setTransactionReference(String.valueOf(referenceNbr));
        reversalRequest.setICA("009674");
        RepowerReversal reversal = reversalService.getRepowerReversal(reversalRequest);
        assertTrue(testUtils.validateXML(reversal, "repowerReversal.xsd"));

        //submitting reversal again
        RepowerReversal reversal2 = reversalService.getRepowerReversal(reversalRequest);
        assertTrue(testUtils.validateXML(reversal2, "repowerReversal.xsd"));

        // reversing an already reversed transaction should return original reversal transaction data
        assertTrue(reversal.getTransactionHistory().getTransaction().getSettlementDate().equals(
                reversal2.getTransactionHistory().getTransaction().getSettlementDate()));
        assertTrue(reversal.getTransactionHistory().getTransaction().getType().equals(
                reversal2.getTransactionHistory().getTransaction().getType()));
        assertTrue(reversal.getTransactionHistory().getTransaction().getNetworkReferenceNumber() == (
                reversal2.getTransactionHistory().getTransaction().getNetworkReferenceNumber()));
        assertTrue(reversal.getTransactionHistory().getTransaction().getResponse().getCode().equals(
                reversal2.getTransactionHistory().getTransaction().getResponse().getCode()));
        assertTrue(reversal.getTransactionHistory().getTransaction().getSubmitDateTime().equals(
                reversal2.getTransactionHistory().getTransaction().getSubmitDateTime()));
        assertTrue(reversal.getTransactionHistory().getTransaction().getSystemTraceAuditNumber() == (
                reversal2.getTransactionHistory().getTransaction().getSystemTraceAuditNumber()));

    }
}

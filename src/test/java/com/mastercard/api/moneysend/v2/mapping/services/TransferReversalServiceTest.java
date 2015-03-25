package com.mastercard.api.moneysend.v2.mapping.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.moneysend.v2.mapping.domain.TransferReversal;
import com.mastercard.api.moneysend.v2.mapping.domain.TransferReversalRequest;
import com.mastercard.api.moneysend.v2.mapping.domain.factory.ObjectFactory;
import junit.framework.TestCase;
import utils.TestUtils;

public class TransferReversalServiceTest extends TestCase {
    TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    ObjectFactory factory = new ObjectFactory();
    TransferReversalService service;
    TransferReversalRequest request;

    public void setUp() {
        service = new TransferReversalService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
    }

    public void testTransferReversalRequest() {
        request = factory.createTransferReversalRequest();
        request.setICA("009674");
        request.setTransactionReference(4000000002010101031L);
        request.setReversalReason("FAILURE IN PROCESSING");
        TransferReversal transferReversal = service.getTransferReversal(request);
        assertTrue(transferReversal != null);
        assertTrue(transferReversal.getRequestId() > 0);
        assertTrue(transferReversal.getTransactionReference() > 0);
        assertTrue(transferReversal.getTransactionHistory().getTransaction() != null);
        assertTrue(testUtils.validateXML(transferReversal, "TransferReversal.xsd"));
    }

}

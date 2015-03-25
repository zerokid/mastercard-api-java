package com.mastercard.api.moneysend.v2.mapping.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.moneysend.v2.mapping.domain.DeleteSubscriberId;
import com.mastercard.api.moneysend.v2.mapping.domain.DeleteSubscriberIdRequest;
import com.mastercard.api.moneysend.v2.mapping.domain.factory.ObjectFactory;
import junit.framework.TestCase;
import utils.TestUtils;

public class DeleteSubscriberIdServiceTest extends TestCase {
    DeleteSubscriberIdService service;
    DeleteSubscriberIdRequest deleteSubscriberIdRequest = new DeleteSubscriberIdRequest();
    TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    ObjectFactory factory = new ObjectFactory();

    public void setUp() {
        service = new DeleteSubscriberIdService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
    }

    public void testDeleteSubscriberIdRequest() {
        deleteSubscriberIdRequest = factory.createDeleteSubscriberIdRequest();
        deleteSubscriberIdRequest.setSubscriberId("13147449999");
        deleteSubscriberIdRequest.setSubscriberType("PHONE_NUMBER");
        DeleteSubscriberId deleteSubscriberId = service.getDeleteSubscriberId(deleteSubscriberIdRequest);
        assertTrue(deleteSubscriberId != null);
        assertTrue(deleteSubscriberId.getRequestId() > 0);
        assertTrue(testUtils.validateXML(deleteSubscriberId, "DeleteSubscriberId.xsd"));
    }

}

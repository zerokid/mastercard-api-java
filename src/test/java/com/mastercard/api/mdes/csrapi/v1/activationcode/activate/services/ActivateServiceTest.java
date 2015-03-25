package com.mastercard.api.mdes.csrapi.v1.activationcode.activate.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.mdes.csrapi.v1.activationcode.activate.domain.ActivateRequest;
import com.mastercard.api.mdes.csrapi.v1.activationcode.activate.domain.Response;
import com.mastercard.api.mdes.csrapi.v1.activationcode.activate.domain.factory.ObjectFactory;
import junit.framework.TestCase;
import utils.TestUtils;

public class ActivateServiceTest extends TestCase {

    private TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    private ActivateService service;
    private ActivateRequest activateRequest;
    private Response response;

    public void setUp() {
        service = new ActivateService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
    }

    public void testMappingSearchService() {
        activateRequest = new ObjectFactory().createActivateRequest();
        activateRequest.setPan(5112345678901255L);
        activateRequest.setSecureElementId("10000000000000061001000333c0000237a5a89708b18e45");
        activateRequest.getAuditInfo().setUserId("testUser");
        activateRequest.getAuditInfo().setUserName("Test User");
        activateRequest.getAuditInfo().setOrganization("Test Org");
        response = service.getResponse(activateRequest);
        assert(testUtils.validateXML(response, "activateResponse.xsd"));
    }

}

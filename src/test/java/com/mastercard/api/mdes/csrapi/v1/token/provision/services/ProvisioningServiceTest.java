package com.mastercard.api.mdes.csrapi.v1.token.provision.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.mdes.csrapi.v1.token.provision.domain.GeneralizedProvisioningRequest;
import com.mastercard.api.mdes.csrapi.v1.token.provision.domain.Response;
import com.mastercard.api.mdes.csrapi.v1.token.provision.domain.factory.GeneralizedProvisioningRequestObjectFactory;
import junit.framework.TestCase;
import utils.TestUtils;

public class ProvisioningServiceTest extends TestCase {

    GeneralizedProvisioningRequest generalizedProvisioningRequest;
    Response response;
    ProvisioningService service;
    TestUtils testUtils = new TestUtils(Environment.SANDBOX);

    public void setUp(){
        service = new ProvisioningService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
    }

    public void testProvisioningService(){
        generalizedProvisioningRequest = new GeneralizedProvisioningRequestObjectFactory().createProvisioningRequest();
        generalizedProvisioningRequest.setCurrentPan(5112345678901255L);
        generalizedProvisioningRequest.setSecureElementId("10000000000000061001000333c0000237a5a89708b18e45");
        generalizedProvisioningRequest.setAction("suspend");
        generalizedProvisioningRequest.setComments("Wallet Service Provider suspended the account on 11/10/2013");
        generalizedProvisioningRequest.setReasonCode("RC2");
        generalizedProvisioningRequest.getAuditInfo().setUserId("testUser");
        generalizedProvisioningRequest.getAuditInfo().setUserName("Test User");
        generalizedProvisioningRequest.getAuditInfo().setOrganization("Test Org");
        response = service.getResponse(generalizedProvisioningRequest);
        assert(testUtils.validateXML(response, "response.xsd"));
    }

}

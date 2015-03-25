package com.mastercard.api.mdes.csrapi.v1.pan.swap.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.mdes.csrapi.v1.pan.swap.domain.Responses;
import com.mastercard.api.mdes.csrapi.v1.pan.swap.domain.SwapPANRequest;
import com.mastercard.api.mdes.csrapi.v1.pan.swap.domain.factory.ObjectFactory;
import junit.framework.TestCase;
import utils.TestUtils;

public class SwapPANServiceTest extends TestCase {

    private TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    private SwapPANService service;
    private SwapPANRequest request;
    private Responses response;

    public void setUp() {
        service = new SwapPANService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
    }

    public void testMappingSearchService() {
        request = new ObjectFactory().createSwapPANRequest();
        request.setCurrentPan(5112345678901255L);
        request.getNewPan().setId(5112345678901235L);
        request.getNewPan().setExpiryDate("0917");
        request.getNewPan().setCardSequenceNumber("001");
        request.getNewPan().setUpdateWalletServiceProvider(0);
        request.setComments("Issuer swaped the account on 01/03/2014");
        request.getAuditInfo().setUserId("testUser");
        request.getAuditInfo().setUserName("Test User");
        request.getAuditInfo().setOrganization("Test Org");
        response = service.getResponses(request);
        assert(testUtils.validateXML(response, "responses.xsd"));
    }

}

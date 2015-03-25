package com.mastercard.api.mdes.csrapi.v1.retrieveTxs.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.mdes.csrapi.v1.retrieveTxs.domain.DeviceTransaction;
import com.mastercard.api.mdes.csrapi.v1.retrieveTxs.domain.TransactionRequest;
import com.mastercard.api.mdes.csrapi.v1.retrieveTxs.domain.factory.ObjectFactory;
import junit.framework.TestCase;
import utils.TestUtils;

public class RetrieveTransactionServiceTest extends TestCase {

    private TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    private RetrieveTransactionsService service;
    private TransactionRequest request;
    private DeviceTransaction response;

    public void setUp() {
        service = new RetrieveTransactionsService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
    }

    public void testMappingSearchService() {
        request = new ObjectFactory().createTransactionRequest();
        request.setTokenUniqueId("DWSPMC00000000010906a349d9ca4eb1a4d53e3c90a11d9c");
        request.getAuditInfo().setUserId("testUser");
        request.getAuditInfo().setUserName("Test User");
        request.getAuditInfo().setOrganization("Test Org");
        response = service.getDeviceTransaction(request);
        assert(testUtils.validateXML(response, "deviceTransactions.xsd"));
    }

}

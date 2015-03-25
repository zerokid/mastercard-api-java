package com.mastercard.api.mdes.csrapi.v1.systemstatus.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.mdes.csrapi.v1.systemstatus.domain.SystemStatusResponses;
import junit.framework.TestCase;
import utils.TestUtils;

public class SystemStatusServiceTest extends TestCase {

    SystemStatusService service;
    TestUtils testUtils = new TestUtils(Environment.SANDBOX);

    public void setUp(){
        service = new SystemStatusService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
    }

    public void testReasonCodesService(){
        SystemStatusResponses systemStatusResponses = service.getSystemStatusResponses();
        assert(testUtils.validateXML(systemStatusResponses, "systemStatusResponses.xsd"));
    }

}

package com.mastercard.api.mdes.csrapi.v1.reasoncodes.services;

import com.mastercard.api.common.Environment;
import junit.framework.TestCase;
import utils.TestUtils;

public class ReasonCodesServiceTest extends TestCase {

    ReasonCodesService service;
    TestUtils testUtils = new TestUtils(Environment.SANDBOX);

    public void setUp(){
        service = new ReasonCodesService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
    }

    public void testReasonCodesService(){
        assert(testUtils.validateXML(service.getResponse(), "reasonCodes.xsd"));
    }

}

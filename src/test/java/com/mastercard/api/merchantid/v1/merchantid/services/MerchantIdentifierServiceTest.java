package com.mastercard.api.merchantid.v1.merchantid.services;


import com.mastercard.api.common.Environment;
import com.mastercard.api.merchantid.v1.merchantid.domain.MerchantIds;
import com.mastercard.api.merchantid.v1.merchantid.domain.options.MerchantIdentifierRequestOptions;
import junit.framework.TestCase;
import utils.TestUtils;

public class MerchantIdentifierServiceTest extends TestCase {

    MerchantIdentifierService service;
    MerchantIdentifierRequestOptions option = new MerchantIdentifierRequestOptions("DIRECTSATELLITETV");
    TestUtils testUtils = new TestUtils(Environment.SANDBOX);

    public void testMerchantIdentifierNoTypeSpecified() {
        service = new MerchantIdentifierService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
        MerchantIds merchantIds = service.getMerchantIds(option);
        assertTrue(merchantIds != null && merchantIds.getReturnedMerchants() != null);
        assertTrue(testUtils.validateXML(merchantIds, "MerchantIds.xsd"));
    }

    public void testMerchantIdentifierExactMatch() {
        service = new MerchantIdentifierService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
        option.setType("ExactMatch");
        MerchantIds merchantIds = service.getMerchantIds(option);
        assertTrue(merchantIds != null && merchantIds.getReturnedMerchants() != null);
        assertTrue(testUtils.validateXML(merchantIds, "MerchantIds.xsd"));
    }

    public void testMerchantIdentifierFuzzyMatch() {
        service = new MerchantIdentifierService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
        option.setType("FuzzyMatch");
        MerchantIds merchantIds = service.getMerchantIds(option);
        assertTrue(merchantIds != null && merchantIds.getReturnedMerchants() != null);
        assertTrue(testUtils.validateXML(merchantIds, "MerchantIds.xsd"));
    }
}

package com.mastercard.api.partnerwallet.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.partnerwallet.domain.switchapi.Merchant;
import junit.framework.TestCase;
import utils.TestUtils;

public class MerchantInfoServiceTest extends TestCase {
    MerchantInfoService service;
    TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    protected void setUp() throws Exception {
        super.setUp();
        service = new MerchantInfoService(Environment.SANDBOX, testUtils.getConsumerKey(), testUtils.getPrivateKey());
    }

    public void testMerchantInfoService() {
        assertNotNull(service);
    }

    public void testGetMerchant() {
        Merchant response = service.getMerchant("a4a6x1ywxlkxzhensyvad1hepuouaesuv");
        assertNotNull(response);
    }
}

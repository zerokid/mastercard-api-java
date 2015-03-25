package com.mastercard.api.partnerwallet.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.partnerwallet.domain.all.RewardProgramOfferingsResponse;

import junit.framework.TestCase;
import utils.TestUtils;

public class RewardProgramOfferingServiceTest extends TestCase {
    RewardProgramOfferingService service;
    TestUtils testUtils = new TestUtils(Environment.SANDBOX);

    protected void setUp() throws Exception {
        super.setUp();
        service = new RewardProgramOfferingService(Environment.SANDBOX, testUtils.getConsumerKey(), testUtils.getPrivateKey());
    }

    public void testRewardProgramOfferingService() {
        assertNotNull(service);
    }

    public void testGetRewardProgramOfferingsResponse() {
        RewardProgramOfferingsResponse response = service.getRewardProgramOfferingsResponse();
        assertNotNull(response);
    }
}

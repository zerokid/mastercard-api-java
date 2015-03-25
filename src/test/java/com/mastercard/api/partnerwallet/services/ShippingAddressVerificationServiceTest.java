package com.mastercard.api.partnerwallet.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.common.requesttoken.RequestTokenService;
import com.mastercard.api.common.requesttoken.domain.RequestTokenResponse;
import com.mastercard.api.partnerwallet.domain.all.ShippingAddressVerificationRequest;
import com.mastercard.api.partnerwallet.domain.all.ShippingAddressVerificationResponse;
import com.mastercard.api.partnerwallet.services.ShippingAddressVerificationService;

import junit.framework.TestCase;
import utils.TestUtils;

public class ShippingAddressVerificationServiceTest extends TestCase {
    ShippingAddressVerificationService service;
    TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    MockObjectFactory objectFactory = new MockObjectFactory();
    RequestTokenResponse requestTokenResponse;

    @Override
    protected void setUp() throws Exception {
        service = new ShippingAddressVerificationService(Environment.SANDBOX, testUtils.getConsumerKey(), testUtils.getPrivateKey());
        RequestTokenService requestTokenService = new RequestTokenService(Environment.SANDBOX, testUtils.getConsumerKey(),
                testUtils.getPrivateKey());
        requestTokenResponse = requestTokenService.getRequestTokenResponse();
    }

    public void testGetShippingAddressVerificationResponse() {
        ShippingAddressVerificationRequest request = objectFactory.mockShippingAddressVerificationRequest(requestTokenResponse.getOauthToken());
        ShippingAddressVerificationResponse response = service.getShippingAddressVerificationResponse(request);
        assertNotNull(response);
    }
}

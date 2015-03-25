package com.mastercard.api.partnerwallet.services;

import utils.TestUtils;

import com.mastercard.api.common.Environment;
import com.mastercard.api.common.requesttoken.RequestTokenService;
import com.mastercard.api.common.requesttoken.domain.RequestTokenResponse;
import com.mastercard.api.partnerwallet.domain.all.AuthorizeCheckoutRequest;
import com.mastercard.api.partnerwallet.domain.all.AuthorizeCheckoutResponse;

import junit.framework.TestCase;

public class CheckoutAuthorizationServiceTest extends TestCase {
	
	CheckoutAuthorizationService service;
    TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    MockObjectFactory objectFactory = new MockObjectFactory();
    RequestTokenResponse requestTokenResponse;
	
	protected void setUp() throws Exception {
		super.setUp();
		RequestTokenService requestTokenService = new RequestTokenService(Environment.SANDBOX, testUtils.getConsumerKey(),
                testUtils.getPrivateKey());
        requestTokenResponse = requestTokenService.getRequestTokenResponse();
        service = new CheckoutAuthorizationService(Environment.SANDBOX, testUtils.getConsumerKey(), testUtils.getPrivateKey());
	}
	
	public void testGetAuthorizeCheckoutResponse() {
		AuthorizeCheckoutRequest request = objectFactory.mockAuthorizeCheckoutRequest(requestTokenResponse.getOauthToken());
		AuthorizeCheckoutResponse response = service.getAuthorizeCheckoutResponse(request);
		assertNotNull(response);
	}
	
}

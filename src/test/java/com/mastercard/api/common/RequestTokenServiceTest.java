package com.mastercard.api.common;

import com.mastercard.api.common.requesttoken.RequestTokenService;
import com.mastercard.api.common.requesttoken.domain.RequestTokenResponse;
import junit.framework.TestCase;
import utils.TestUtils;

public class RequestTokenServiceTest extends TestCase {
    RequestTokenService service;
    TestUtils testUtils = new TestUtils(Environment.SANDBOX);

    @Override
    protected void setUp() throws Exception {
        service = new RequestTokenService(Environment.SANDBOX, testUtils.getConsumerKey(), testUtils.getPrivateKey());
    }

    public void testGetRequestTokenResponse() {
        RequestTokenResponse requestTokenResponse = service.getRequestTokenResponse("http://projectabc.com");
        assertNotNull(requestTokenResponse);
        assertNotNull(requestTokenResponse.getAuthorizationUrl());
        assertNotNull(requestTokenResponse.getOauthCallbackConfirmed());
        assertNotNull(requestTokenResponse.getOauthExpiresIn());
        assertNotNull(requestTokenResponse.getOauthToken());
        assertNotNull(requestTokenResponse.getOauthTokenSecret());
    }

    // tested function is private, change to public in order to run test
//    public void testParseRequestTokenResponse() {
//        String response = "oauth_token=test_oauthtoken&oauth_callback_confirmed=test_oauthcallbackconfirmed&oauth_expires_in=test_oauthexpiresin&oauth_token_secret=test_oauthtokensecret&xoauth_request_auth_url=test_xoauthrequestauthurl";
//        RequestTokenResponse requestTokenResponse = service.parseRequestTokenResponse(response);
//        assertEquals(requestTokenResponse.getOauthToken(), "test_oauthtoken");
//        assertEquals(requestTokenResponse.getOauthCallbackConfirmed(), "test_oauthcallbackconfirmed");
//        assertEquals(requestTokenResponse.getOauthExpiresIn(), "test_oauthexpiresin");
//        assertEquals(requestTokenResponse.getOauthTokenSecret(), "test_oauthtokensecret");
//        assertEquals(requestTokenResponse.getAuthorizationUrl(), "test_xoauthrequestauthurl");
//    }
}

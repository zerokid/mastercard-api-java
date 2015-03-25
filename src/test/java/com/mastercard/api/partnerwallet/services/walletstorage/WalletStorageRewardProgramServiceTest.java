package com.mastercard.api.partnerwallet.services.walletstorage;

import utils.TestUtils;

import com.mastercard.api.common.Environment;
import com.mastercard.api.common.requesttoken.domain.RequestTokenResponse;
import com.mastercard.api.partnerwallet.domain.all.RewardProgram;
import com.mastercard.api.partnerwallet.services.MockObjectFactory;

import junit.framework.TestCase;

public class WalletStorageRewardProgramServiceTest extends TestCase {
	
	WalletStorageRewardProgramService service;
    TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    MockObjectFactory objectFactory = new MockObjectFactory();
	
	
	protected void setUp() throws Exception {
		super.setUp();
		service = new WalletStorageRewardProgramService(Environment.SANDBOX, testUtils.getConsumerKey(), testUtils.getPrivateKey());
	}
	
	public void testConstructor(){
		assertNotNull(service);
	}
	
	public void testPostData(){
		RewardProgram reward = objectFactory.mockRewardProgram();
		String response = service.createWalletStorageRewardProgam(
										reward, 
										"16qmlkd3vtvmhjdtcpcdvuidhiqhrb1r2suu24k3oln2c0i95hf8", 
										"1dqajif7octqpq43grt3m910lrkqnhle1d5g7h3svb3fl85ejf88");
		assertNotNull(response);
	}

}

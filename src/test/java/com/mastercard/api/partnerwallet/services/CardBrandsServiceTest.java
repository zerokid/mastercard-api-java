package com.mastercard.api.partnerwallet.services;

import javax.xml.bind.JAXBElement;

import utils.TestUtils;

import com.mastercard.api.common.Environment;
import com.mastercard.api.partnerwallet.domain.card.CardBrandsResponse;
import com.mastercard.api.partnerwallet.domain.options.CardBrandsOptions;

import junit.framework.TestCase;

public class CardBrandsServiceTest extends TestCase {
	CardBrandsService service;
	TestUtils testUtils = new TestUtils(Environment.SANDBOX);
	protected void setUp() throws Exception {
		super.setUp();
		service = new CardBrandsService(Environment.SANDBOX, testUtils.getConsumerKey(), testUtils.getPrivateKey());
	}

	public void testCardBrandsService() {
		assertNotNull(service);
	}

	public void testGetCardBrandsResponse() {
		CardBrandsOptions options = new CardBrandsOptions("en", "US");
		CardBrandsResponse response = service.getCardBrandsResponse(options);
		assertNotNull(response);
		assertNotNull(response.getCardBrands().getCardBrands().get(0).getDisplayName());
	}

}

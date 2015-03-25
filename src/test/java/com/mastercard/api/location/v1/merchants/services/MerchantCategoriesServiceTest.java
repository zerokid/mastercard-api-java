package com.mastercard.api.location.v1.merchants.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.location.v1.merchants.domain.Categories;
import junit.framework.TestCase;
import utils.TestUtils;

public class MerchantCategoriesServiceTest extends TestCase {
    TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    MerchantCategoriesService service;

    public void setUp(){
        service = new MerchantCategoriesService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
    }

    public void testMerchantCategoriesService(){
        Categories categories = service.getCategories();
        assertTrue(categories.getCategory() != null && categories.getCategory().size() > 0);
        assertTrue(testUtils.validateXML(categories, "categories.xsd"));
    }
}

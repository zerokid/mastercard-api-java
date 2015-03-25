package com.mastercard.api.restaurants.v1.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.restaurants.v1.domain.Categories;
import junit.framework.TestCase;
import utils.TestUtils;

public class CategoriesLocalFavoritesServiceTest extends TestCase {

    TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    CategoriesLocalFavoritesService service;

    public void setUp(){
        this.service = new CategoriesLocalFavoritesService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
    }

    public void testCountryMerchantLocationService(){
        Categories categories = service.getCategories();
        assertTrue(categories.getCategoryList() != null && categories.getCategoryList().size() > 0);
        assertTrue(testUtils.validateXML(categories, "categories.xsd"));
    }
}

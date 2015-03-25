package com.mastercard.api.mdes.csrapi.v1.mapping.search.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.mdes.csrapi.v1.mapping.search.domain.SearchRequest;
import com.mastercard.api.mdes.csrapi.v1.mapping.search.domain.SearchResponse;
import com.mastercard.api.mdes.csrapi.v1.mapping.search.domain.factory.ObjectFactory;
import junit.framework.TestCase;
import utils.TestUtils;

public class MappingSearchServiceTest extends TestCase {
    private TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    private MappingSearchService service;
    private SearchRequest searchRequest;
    private SearchResponse searchResponse;

    public void setUp() {
        service = new MappingSearchService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
    }

    public void testMappingSearchService() {
        searchRequest = new ObjectFactory().createSearchRequest();
        searchRequest.setPan(5112345678901234L);
        searchRequest.getAuditInfo().setUserId("testUser");
        searchRequest.getAuditInfo().setUserName("Test User");
        searchRequest.getAuditInfo().setOrganization("Test Org");
        searchResponse = service.getSearchResponse(searchRequest);
        assert(searchResponse != null);
        assert(searchResponse.getDevices().getDevice().size() > 0);
        assert(testUtils.validateXML(searchResponse, "searchResponse.xsd"));
    }
}

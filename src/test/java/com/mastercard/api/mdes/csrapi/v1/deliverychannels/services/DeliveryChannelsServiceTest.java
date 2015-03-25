package com.mastercard.api.mdes.csrapi.v1.deliverychannels.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.mdes.csrapi.v1.deliverychannels.domain.DeliveryChannels;
import com.mastercard.api.mdes.csrapi.v1.mapping.search.domain.SearchRequest;
import com.mastercard.api.mdes.csrapi.v1.mapping.search.domain.SearchResponse;
import com.mastercard.api.mdes.csrapi.v1.mapping.search.domain.factory.ObjectFactory;
import com.mastercard.api.mdes.csrapi.v1.mapping.search.services.MappingSearchService;
import junit.framework.TestCase;
import utils.TestUtils;

public class DeliveryChannelsServiceTest extends TestCase {

    private TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    private MappingSearchService mappingSearchService;
    private DeliveryChannelsService deliveryChannelsService;
    private SearchRequest searchRequest;
    private SearchResponse searchResponse;
    private DeliveryChannels deliveryChannels;

    public void setUp() {
        mappingSearchService = new MappingSearchService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );

        deliveryChannelsService = new DeliveryChannelsService(
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
        searchResponse = mappingSearchService.getSearchResponse(searchRequest);
        String uniqueTokenId = searchResponse.getDevices().getDevice().get(0).getTokenUniqueId();
        deliveryChannels = deliveryChannelsService.getDeliveryChannels(uniqueTokenId);
        assertTrue(testUtils.validateXML(deliveryChannels, "deliveryChannels.xsd"));
    }

}

package com.mastercard.api.mdes.csrapi.v1.mapping.search.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.mdes.csrapi.v1.mapping.search.domain.SearchRequest;
import com.mastercard.api.mdes.csrapi.v1.mapping.search.domain.SearchResponse;

import java.security.PrivateKey;
import java.util.Map;

public class MappingSearchService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/mdes/csrapi/v1/mapping/search?Format=XML";
    private static final String MTF_URL = "https://api.mastercard.com/mdes/csrapi/mtf/v1/mapping/search?Format=XML";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/mdes/csrapi/v1/mapping/search?Format=XML";

    public MappingSearchService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    public SearchResponse getSearchResponse(SearchRequest searchRequest) {
        Map<String, String> responseMap = doRequest(
                getURL(),
                POST,
                xmlToString(searchRequest)
        );
        String response = responseMap.get(MESSAGE);
        return (SearchResponse) stringToXml(response, SearchResponse.class);
    }

    private String getURL(){
        if (this.environment == Environment.PRODUCTION) {
            return PRODUCTION_URL;
        } else if (this.environment == Environment.MTF) {
            return MTF_URL;
        } else {
            return SANDBOX_URL;
        }
    }

}

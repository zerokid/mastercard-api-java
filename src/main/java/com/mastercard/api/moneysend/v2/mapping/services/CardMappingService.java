package com.mastercard.api.moneysend.v2.mapping.services;

import java.security.PrivateKey;
import java.util.Map;
import com.mastercard.api.moneysend.v2.mapping.domain.*;
import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.common.util.URLUtil;
import com.mastercard.api.moneysend.v2.mapping.domain.options.*;

public class CardMappingService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/moneysend/v2/mapping/card?Format=XML";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/moneysend/v2/mapping/card?Format=XML";

    public CardMappingService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    public CreateMapping getCreateMapping(CreateMappingRequest request) {
        Map<String,String> responseMap = doRequest(
                getURL(),
                POST,
                xmlToString(request)
        );
        String response = responseMap.get(MESSAGE);
        return (CreateMapping) stringToXml(response, CreateMapping.class);
    }

    public InquireMapping getInquireMapping(InquireMappingRequest request) {
        Map<String,String> responseMap = doRequest(
                getURL(),
                PUT,
                xmlToString(request)
        );
        String response = responseMap.get(MESSAGE);
        return (InquireMapping) stringToXml(response, InquireMapping.class);
    }

    public UpdateMapping getUpdateMapping(UpdateMappingRequest request, UpdateMappingRequestOptions options) {
        Map<String,String> responseMap = doRequest(
                getURL(options.getMappingId()),
                PUT,
                xmlToString(request)
        );
        String response = responseMap.get(MESSAGE);
        return (UpdateMapping) stringToXml(response, UpdateMapping.class);
    }

    public DeleteMapping getDeleteMapping(DeleteMappingRequestOptions options) {
        Map<String,String> responseMap = doRequest(
                getURL(options.getMappingId()),
                DELETE,
                null
        );
        String response = responseMap.get(MESSAGE);
        return (DeleteMapping) stringToXml(response, DeleteMapping.class);
    }

    private String getURL() {
        String url;
        if (this.environment == Environment.PRODUCTION) {
            url = PRODUCTION_URL;
        } else {
            url = SANDBOX_URL;
        }
        return url;
    }

    private String getURL(Integer mappingId) {
        String url;
        if (this.environment == Environment.PRODUCTION) {
            url = "https://api.mastercard.com/moneysend/v2/mapping/card/%d";
        } else {
            url =  "https://sandbox.api.mastercard.com/moneysend/v2/mapping/card/%d";
        }
        url = String.format(url, mappingId);

        return url;
    }

}

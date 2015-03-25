package com.mastercard.api.moneysend.v2.mapping.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.moneysend.v2.mapping.domain.DeleteSubscriberId;
import com.mastercard.api.moneysend.v2.mapping.domain.DeleteSubscriberIdRequest;
import com.mastercard.api.common.util.URLUtil;

import java.security.PrivateKey;
import java.util.Map;

public class DeleteSubscriberIdService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/moneysend/v2/mapping/subscriber?Format=XML";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/moneysend/v2/mapping/subscriber?Format=XML";

    public DeleteSubscriberIdService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    public DeleteSubscriberId getDeleteSubscriberId(DeleteSubscriberIdRequest deleteSubscriberIdRequest) {
        Map<String,String> responseMap = doRequest(
                getURL(),
                PUT,
                xmlToString(deleteSubscriberIdRequest)
        );
        String response = responseMap.get(MESSAGE);
        return (DeleteSubscriberId) stringToXml(response, DeleteSubscriberId.class);
    }

    private String getURL() {
        String url;
        if (this.environment == Environment.PRODUCTION) {
            url = PRODUCTION_URL;
        } else {
            url =  SANDBOX_URL;
        }
        return url;
    }

}

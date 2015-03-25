package com.mastercard.api.mdes.csrapi.v1.deliverychannels.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.mdes.csrapi.v1.deliverychannels.domain.DeliveryChannels;

import java.security.PrivateKey;
import java.util.Map;

public class DeliveryChannelsService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/mdes/csrapi/v1/{tokenuniqueid}/deliverychannels?Format=XML";
    private static final String MTF_URL = "https://api.mastercard.com/mdes/csrapi/mtf/v1/{tokenuniqueid}/deliverychannels?Format=XML";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/mdes/csrapi/v1/{tokenuniqueid}/deliverychannels?Format=XML";

    public DeliveryChannelsService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    public DeliveryChannels getDeliveryChannels(String tokenUniqueId) {
        Map<String, String> responseMap = doRequest(
                getURL(tokenUniqueId),
                GET,
                null
        );
        String response = responseMap.get(MESSAGE);
        return (DeliveryChannels) stringToXml(response, DeliveryChannels.class);
    }

    private String getURL(String tokenUniqueId){
        String url;
        if (this.environment == Environment.PRODUCTION) {
            url =  PRODUCTION_URL;
        } else if (this.environment == Environment.MTF) {
            url =  MTF_URL;
        } else {
            url =  SANDBOX_URL;
        }
        return url.replace("{tokenuniqueid}", tokenUniqueId);
    }

}

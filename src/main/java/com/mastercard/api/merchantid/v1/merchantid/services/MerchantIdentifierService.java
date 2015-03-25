package com.mastercard.api.merchantid.v1.merchantid.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.merchantid.v1.merchantid.domain.MerchantIds;
import com.mastercard.api.common.util.URLUtil;
import com.mastercard.api.merchantid.v1.merchantid.domain.options.MerchantIdentifierRequestOptions;
import java.security.PrivateKey;
import java.util.Map;

public class MerchantIdentifierService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/merchantid/v1/merchantid?Format=XML";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/merchantid/v1/merchantid?Format=XML";

    public MerchantIdentifierService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    public MerchantIds getMerchantIds(MerchantIdentifierRequestOptions options) {
        Map<String,String> responseMap = doRequest(
                getURL(options),
                GET,
                null
        );
        String response = responseMap.get(MESSAGE);
        return (MerchantIds) stringToXml(response, MerchantIds.class);
    }

    private String getURL(MerchantIdentifierRequestOptions options){
        String url;
        if (this.environment == Environment.PRODUCTION) {
            url = PRODUCTION_URL;
        } else {
            url =  SANDBOX_URL;
        }
        url = URLUtil.addQueryParameter(url, "MerchantId", options.getMerchantId());
        url = URLUtil.addQueryParameter(url, "Type", options.getType());
        return url;
    }
}

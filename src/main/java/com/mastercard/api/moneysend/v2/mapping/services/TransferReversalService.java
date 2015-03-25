package com.mastercard.api.moneysend.v2.mapping.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.moneysend.v2.mapping.domain.TransferReversal;
import com.mastercard.api.moneysend.v2.mapping.domain.TransferReversalRequest;

import java.security.PrivateKey;
import java.util.Map;

public class TransferReversalService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/moneysend/v2/transferreversal?Format=XML";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/moneysend/v2/transferreversal?Format=XML";

    public TransferReversalService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    public TransferReversal getTransferReversal(TransferReversalRequest transferReversalRequest) {
        Map<String,String> responseMap = doRequest(
                getURL(),
                POST,
                xmlToString(transferReversalRequest)
        );
        String response = responseMap.get(MESSAGE);
        return (TransferReversal) stringToXml(response, TransferReversal.class);
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

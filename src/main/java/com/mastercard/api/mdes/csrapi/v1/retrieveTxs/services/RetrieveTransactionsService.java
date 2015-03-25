package com.mastercard.api.mdes.csrapi.v1.retrieveTxs.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.mdes.csrapi.v1.retrieveTxs.domain.DeviceTransaction;
import com.mastercard.api.mdes.csrapi.v1.retrieveTxs.domain.TransactionRequest;

import java.security.PrivateKey;
import java.util.Map;

public class RetrieveTransactionsService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/mdes/csrapi/v1/retrieveTxs?Format=XML";
    private static final String MTF_URL = "https://api.mastercard.com/mdes/csrapi/mtf/v1/retrieveTxs?Format=XML";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/mdes/csrapi/v1/retrieveTxs?Format=XML";

    public RetrieveTransactionsService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    public DeviceTransaction getDeviceTransaction(TransactionRequest transactionRequest) {
        Map<String, String> responseMap = doRequest(
                getURL(),
                POST,
                xmlToString(transactionRequest)
        );
        String response = responseMap.get(MESSAGE);
        return (DeviceTransaction) stringToXml(response, DeviceTransaction.class);
    }

    private String getURL() {
        if (this.environment == Environment.PRODUCTION) {
            return PRODUCTION_URL;
        } else if (this.environment == Environment.MTF) {
            return MTF_URL;
        } else {
            return SANDBOX_URL;
        }
    }

}

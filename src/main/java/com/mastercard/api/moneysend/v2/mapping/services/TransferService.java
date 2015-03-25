package com.mastercard.api.moneysend.v2.mapping.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.moneysend.v2.mapping.domain.*;

import java.security.PrivateKey;
import java.util.Map;

public class TransferService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/moneysend/v2/transfer?Format=XML";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/moneysend/v2/transfer?Format=XML";

    public TransferService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    public Transfer getTransfer(TransferRequest transferRequest) {
        //Determine if TransferRequest is specifying card account number or mapped account
        if (transferRequest.getFundingMapped().getSubscriberId() == null) {
            transferRequest.setFundingMapped(null);
        } else {
            transferRequest.setSenderAddress(null);
            transferRequest.setFundingCard(null);
        }
        Map<String,String> responseMap = doRequest(
                getURL(),
                POST,
                xmlToString(transferRequest)
        );
        String response = responseMap.get(MESSAGE);
        return (Transfer) stringToXml(response, Transfer.class);
    }

    public Transfer getTransfer(PaymentRequest paymentRequest) {
        //Determine if PaymentRequest is specifying card account number or mapped account
        if (paymentRequest.getReceivingMapped().getSubscriberId() == null) {
            paymentRequest.setReceivingMapped(null);
        } else {
            paymentRequest.setReceivingCard(null);
        }
        Map<String,String> responseMap = doRequest(
                getURL(),
                POST,
                xmlToString(paymentRequest)
        );
        String response = responseMap.get(MESSAGE);
        return (Transfer) stringToXml(response, Transfer.class);
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

package com.mastercard.api.partnerwallet.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.partnerwallet.domain.switchapi.ConnectionHistoryRequest;
import com.mastercard.api.partnerwallet.domain.switchapi.ConnectionHistory;
import com.mastercard.api.partnerwallet.services.common.AbstractPartnerService;

import java.security.PrivateKey;
import java.util.Map;

import javax.xml.bind.JAXBElement;

public class ConnectedMerchantHistoryService extends AbstractPartnerService {

    public ConnectedMerchantHistoryService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(environment, consumerKey, privateKey);
        this.sandboxUrl = "https://sandbox.api.mastercard.com/masterpass/partner/v6/connectedmerchanthistory?Format=XML";
        this.productionUrl = "https://api.mastercard.com/masterpass/partner/v6/connectedmerchanthistory?Format=XML";
        this.mtfUrl = "https://api.mastercard.com/mtf/masterpass/partner/v6/connectedmerchanthistory?Format=XML";
    }

    public ConnectionHistory getConnectionHistory(ConnectionHistoryRequest request) {
        Map<String,String> responseMap = doRequest(
                getUrl(),
                POST,
                xmlToString(request)
        );
        String response = responseMap.get(MESSAGE);
        JAXBElement<ConnectionHistory> connectedResponse = (JAXBElement<ConnectionHistory>) stringToXml(response,  ConnectionHistory.class);
        return connectedResponse.getValue();
    }
}

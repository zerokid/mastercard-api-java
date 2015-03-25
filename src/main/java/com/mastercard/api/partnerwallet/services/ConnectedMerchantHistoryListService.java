package com.mastercard.api.partnerwallet.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.partnerwallet.domain.switchapi.ConnectedMerchantsRequest;
import com.mastercard.api.partnerwallet.domain.switchapi.ConnectedMerchantsResponse;
import com.mastercard.api.partnerwallet.services.common.AbstractPartnerService;

import java.security.PrivateKey;
import java.util.Map;

import javax.xml.bind.JAXBElement;

public class ConnectedMerchantHistoryListService extends AbstractPartnerService {

    public ConnectedMerchantHistoryListService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(environment, consumerKey, privateKey);
        this.sandboxUrl = "https://sandbox.api.mastercard.com/masterpass/partner/v6/connectedmerchanthistorylist?Format=XML";
        this.productionUrl = "https://api.mastercard.com/masterpass/partner/v6/connectedmerchanthistorylist?Format=XML";
        this.mtfUrl = "https://api.mastercard.com/mtf/masterpass/partner/v6/connectedmerchanthistorylist?Format=XML";
    }

    public ConnectedMerchantsResponse getConnectedMerchantsResponse(ConnectedMerchantsRequest request) {
        Map<String,String> responseMap = doRequest(
                getUrl(),
                POST,
                xmlToString(request)
        );
        String response = responseMap.get(MESSAGE);
        JAXBElement<ConnectedMerchantsResponse> connectedResponse = (JAXBElement<ConnectedMerchantsResponse>) stringToXml(response,  ConnectedMerchantsResponse.class);
        return connectedResponse.getValue();
    }
}

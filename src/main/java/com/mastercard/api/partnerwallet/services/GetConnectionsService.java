package com.mastercard.api.partnerwallet.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.partnerwallet.domain.switchapi.ConnectedMerchantsRequest;
import com.mastercard.api.partnerwallet.domain.switchapi.ConnectionList;
import com.mastercard.api.partnerwallet.services.common.AbstractPartnerService;

import javax.xml.bind.JAXBElement;
import java.security.PrivateKey;
import java.util.Map;

public class GetConnectionsService extends AbstractPartnerService {

    public GetConnectionsService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(environment, consumerKey, privateKey);
        this.sandboxUrl = "https://sandbox.api.mastercard.com/masterpass/partner/v6/connectedmerchants?Format=XML";
        this.productionUrl = "https://api.mastercard.com/masterpass/partner/v6/connectedmerchants?Format=XML";
        this.mtfUrl = "https://api.mastercard.com/mtf/masterpass/partner/v6/connectedmerchants?Format=XML";
    }

    public ConnectionList getConnectionList(ConnectedMerchantsRequest request) {
        Map<String,String> responseMap = doRequest(
                getUrl(),
                POST,
                xmlToString(request)
        );
        String response = responseMap.get(MESSAGE);
        JAXBElement<ConnectionList> connectedResponse = (JAXBElement<ConnectionList>) stringToXml(response,  ConnectionList.class);
        return connectedResponse.getValue();
    }

}

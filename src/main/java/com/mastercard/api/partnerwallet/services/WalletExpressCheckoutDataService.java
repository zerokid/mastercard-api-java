package com.mastercard.api.partnerwallet.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.partnerwallet.domain.switchapi.Response;
import com.mastercard.api.partnerwallet.domain.switchapi.WalletExpressCheckoutRequest;
import com.mastercard.api.partnerwallet.services.common.AbstractPartnerService;

import javax.xml.bind.JAXBElement;
import java.security.PrivateKey;
import java.util.Map;

public class WalletExpressCheckoutDataService extends AbstractPartnerService {

    public WalletExpressCheckoutDataService(Environment environment, String consumerKey, PrivateKey privateKey, String walletUrl) {
        super(environment, consumerKey, privateKey);
        this.sandboxUrl = null;
        this.productionUrl = "https://" + walletUrl + "/walletapi/wallet/v6/expresscheckout?Format=XML";
        this.mtfUrl = null;
    }

    public Response postRequest(WalletExpressCheckoutRequest request) {
        Map<String,String> responseMap = doRequest(
                getUrl(),
                POST,
                xmlToString(request)
        );
        String response = responseMap.get(MESSAGE);
        JAXBElement<Response> connectedResponse = (JAXBElement<Response>) stringToXml(response,  Response.class);
        return connectedResponse.getValue();
    }

}

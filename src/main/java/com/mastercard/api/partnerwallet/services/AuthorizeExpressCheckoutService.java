package com.mastercard.api.partnerwallet.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.partnerwallet.domain.all.AuthorizeExpressCheckoutRequest;
import com.mastercard.api.partnerwallet.domain.all.AuthorizeExpressCheckoutResponse;
import com.mastercard.api.partnerwallet.services.common.AbstractPartnerService;

import java.security.PrivateKey;
import java.util.Map;

import javax.xml.bind.JAXBElement;

public class AuthorizeExpressCheckoutService extends AbstractPartnerService {

    public AuthorizeExpressCheckoutService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(environment, consumerKey, privateKey);
        this.sandboxUrl = "https://sandbox.api.mastercard.com/masterpass/partner/v6/expresscheckout?Format=XML";
        this.productionUrl = "https://api.mastercard.com/masterpass/partner/v6/expresscheckout?Format=XML";
        this.mtfUrl = "https://api.mastercard.com/mtf/masterpass/partner/v6/expresscheckout?Format=XML";
    }

    public AuthorizeExpressCheckoutResponse getAuthorizeExpressCheckoutResponse(AuthorizeExpressCheckoutRequest request) {
        Map<String,String> responseMap = doRequest(
                getUrl(),
                POST,
                xmlToString(request)
        );
        String response = responseMap.get(MESSAGE);
        JAXBElement<AuthorizeExpressCheckoutResponse> connectedResponse = (JAXBElement<AuthorizeExpressCheckoutResponse>) stringToXml(response,  AuthorizeExpressCheckoutResponse.class);
        return connectedResponse.getValue();
    }

}

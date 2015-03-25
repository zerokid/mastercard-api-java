package com.mastercard.api.partnerwallet.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.partnerwallet.domain.all.AuthorizePrecheckoutRequest;
import com.mastercard.api.partnerwallet.domain.all.AuthorizePrecheckoutResponse;
import com.mastercard.api.partnerwallet.services.common.AbstractPartnerService;

import javax.xml.bind.JAXBElement;
import java.security.PrivateKey;
import java.util.Map;

public class AuthorizePreCheckoutService extends AbstractPartnerService {

    public AuthorizePreCheckoutService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(environment, consumerKey, privateKey);
        this.sandboxUrl = "https://sandbox.api.mastercard.com/masterpass/partner/v6/precheckout?Format=XML";
        this.productionUrl = "https://api.mastercard.com/masterpass/partner/v6/precheckout?Format=XML";
        this.mtfUrl = "https://api.mastercard.com/mtf/masterpass/partner/v6/precheckout?Format=XML";
    }

    public AuthorizePrecheckoutResponse getAuthorizePrecheckoutResponse(AuthorizePrecheckoutRequest request) {
        Map<String,String> responseMap = doRequest(
                getUrl(),
                POST,
                xmlToString(request)
        );
        String response = responseMap.get(MESSAGE);
        JAXBElement<AuthorizePrecheckoutResponse> connectedResponse = (JAXBElement<AuthorizePrecheckoutResponse>) stringToXml(response,  AuthorizePrecheckoutResponse.class);
        return connectedResponse.getValue();
    }

}

package com.mastercard.api.partnerwallet.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.partnerwallet.domain.switchapi.AuthorizePairingRequest;
import com.mastercard.api.partnerwallet.domain.switchapi.AuthorizePairingResponse;
import com.mastercard.api.partnerwallet.services.common.AbstractPartnerService;

import javax.xml.bind.JAXBElement;
import java.security.PrivateKey;
import java.util.Map;

public class AuthorizePairingService extends AbstractPartnerService {

    public AuthorizePairingService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(environment, consumerKey, privateKey);
        this.sandboxUrl = "https://sandbox.api.mastercard.com/masterpass/partner/v6/pairing?Format=XML";
        this.productionUrl = "https://api.mastercard.com/masterpass/partner/v6/pairing?Format=XML";
        this.mtfUrl = "https://api.mastercard.com/mtf/masterpass/partner/v6/pairing?Format=XML";
    }

    public AuthorizePairingResponse getAuthorizePairingResponse(AuthorizePairingRequest request) {
        Map<String,String> responseMap = doRequest(
                getUrl(),
                POST,
                xmlToString(request)
        );
        String response = responseMap.get(MESSAGE);
        JAXBElement<AuthorizePairingResponse> connectedResponse = (JAXBElement<AuthorizePairingResponse>) stringToXml(response,  AuthorizePairingResponse.class);
        return connectedResponse.getValue();
    }

}

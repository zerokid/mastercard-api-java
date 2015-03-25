package com.mastercard.api.partnerwallet.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.partnerwallet.domain.switchapi.DeletePairingRequest;
import com.mastercard.api.partnerwallet.domain.switchapi.DeletePairingResponse;
import com.mastercard.api.partnerwallet.services.common.AbstractPartnerService;

import javax.xml.bind.JAXBElement;
import java.security.PrivateKey;
import java.util.Map;

public class DeletePairingService extends AbstractPartnerService {

    public DeletePairingService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(environment, consumerKey, privateKey);
        this.sandboxUrl = "https://sandbox.api.mastercard.com/masterpass/partner/v6/deletepairing?Format=XML";
        this.productionUrl = "https://api.mastercard.com/masterpass/partner/v6/deletepairing?Format=XML";
        this.mtfUrl = "https://api.mastercard.com/mtf/masterpass/partner/v6/deletepairing?Format=XML";
    }

    public DeletePairingResponse deletePairing(DeletePairingRequest request) {
        Map<String,String> responseMap = doRequest(
                getUrl(),
                POST,
                xmlToString(request)
        );
        String response = responseMap.get(MESSAGE);
        JAXBElement<DeletePairingResponse> connectedResponse = (JAXBElement<DeletePairingResponse>) stringToXml(response,  DeletePairingResponse.class);
        return connectedResponse.getValue();
    }

}

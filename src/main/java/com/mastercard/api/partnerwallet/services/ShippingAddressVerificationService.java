package com.mastercard.api.partnerwallet.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.partnerwallet.domain.all.ShippingAddressVerificationRequest;
import com.mastercard.api.partnerwallet.domain.all.ShippingAddressVerificationResponse;
import com.mastercard.api.partnerwallet.services.common.AbstractPartnerService;

import java.security.PrivateKey;
import java.util.Map;

import javax.xml.bind.JAXBElement;

public class ShippingAddressVerificationService extends AbstractPartnerService {

    public ShippingAddressVerificationService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(environment, consumerKey, privateKey);
        this.sandboxUrl = "https://sandbox.api.mastercard.com/masterpass/partner/v6/verify-shipping-address?Format=XML";
        this.productionUrl = "https://api.mastercard.com/masterpass/partner/v6/verify-shipping-address?Format=XML";
        this.mtfUrl = "https://api.mastercard.com/mtf/masterpass/v6/verify-shipping-address?Format=XML";
    }

    public ShippingAddressVerificationResponse getShippingAddressVerificationResponse(ShippingAddressVerificationRequest request) {
        Map<String,String> responseMap = doRequest(
                getUrl(),
                POST,
                xmlToString(request)
        );
        String response = responseMap.get(MESSAGE);
        JAXBElement<ShippingAddressVerificationResponse> shippingResponse = (JAXBElement<ShippingAddressVerificationResponse>) stringToXml(response,  ShippingAddressVerificationResponse.class);
        return shippingResponse.getValue();
    }
}
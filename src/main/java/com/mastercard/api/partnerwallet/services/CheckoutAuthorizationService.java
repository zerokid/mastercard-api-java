package com.mastercard.api.partnerwallet.services;

import java.security.PrivateKey;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.common.OAuthParameters;
import com.mastercard.api.partnerwallet.domain.all.AuthorizeCheckoutRequest;
import com.mastercard.api.partnerwallet.domain.all.AuthorizeCheckoutResponse;
import com.mastercard.api.partnerwallet.domain.all.ShippingAddressVerificationResponse;
import com.mastercard.api.partnerwallet.services.common.AbstractPartnerService;

public class CheckoutAuthorizationService extends AbstractPartnerService {

	
	public CheckoutAuthorizationService(Environment environment, String consumerKey, PrivateKey privateKey) {
		super(environment, consumerKey, privateKey);
		this.sandboxUrl = "https://sandbox.api.mastercard.com/masterpass/partner/v6/checkout";
		this.productionUrl = "https://api.mastercard.com/masterpass/partner/v6/checkout";
		this.mtfUrl = "https://api.mastercard.com/mtf/masterpass/partner/v6/card-brands?Format=XML";
	}
	
	
	
	public AuthorizeCheckoutResponse getAuthorizeCheckoutResponse(AuthorizeCheckoutRequest request) {
		OAuthParameters params = OAuthParametersFactory();
		params.addParameter(OAUTH_SIGNATURE, request.getOAuthToken());
		Map<String,String> responseMap = doRequest(getUrl(),POST,params,xmlToString(request));
        String response = responseMap.get(MESSAGE);
        JAXBElement<AuthorizeCheckoutResponse> shippingResponse = (JAXBElement<AuthorizeCheckoutResponse>) stringToXml(response,  ShippingAddressVerificationResponse.class);
		return shippingResponse.getValue();
	}
}

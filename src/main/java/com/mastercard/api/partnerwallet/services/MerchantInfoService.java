package com.mastercard.api.partnerwallet.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.partnerwallet.domain.all.AuthorizeCheckoutRequest;
import com.mastercard.api.partnerwallet.domain.all.AuthorizeCheckoutResponse;

import com.mastercard.api.partnerwallet.domain.switchapi.Merchant;
import com.mastercard.api.partnerwallet.services.common.AbstractPartnerService;

import javax.xml.bind.JAXBElement;
import java.security.PrivateKey;
import java.util.Map;

public class MerchantInfoService extends AbstractPartnerService {
    public MerchantInfoService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(environment, consumerKey, privateKey);
        this.sandboxUrl = "https://sandbox.api.mastercard.com/masterpass/partner/v6/merchant/";
        this.productionUrl = "https://api.mastercard.com/masterpass/partner/v6/merchant/";
        this.mtfUrl = "https://api.mastercard.com/mtf/masterpass/v6/merchant/";
    }

    protected String getUrl(String merchantCheckoutId) {
        String url = super.getUrl();
        if(url != null) {
            url += merchantCheckoutId;
        }
        return url;
    }

    public Merchant getMerchant(String merchantCheckoutId) {
        Map<String,String> responseMap = doRequest(
                getUrl(merchantCheckoutId),
                GET,
                null
        );
        String response = responseMap.get(MESSAGE);
        JAXBElement<Merchant> merchant = (JAXBElement<Merchant>) stringToXml(response,  Merchant.class);
        return merchant.getValue();
    }
}

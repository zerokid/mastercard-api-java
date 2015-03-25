package com.mastercard.api.partnerwallet.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.common.util.URLUtil;
import com.mastercard.api.partnerwallet.domain.card.CardBrandsResponse;
import com.mastercard.api.partnerwallet.domain.options.CardBrandsOptions;
import com.mastercard.api.partnerwallet.services.common.AbstractPartnerService;

import java.security.PrivateKey;

import javax.xml.bind.JAXBElement;

public class CardBrandsService extends AbstractPartnerService {

    private static final String LANGUAGE_QUERY = "language";
    private static final String COUNTRY_QUERY = "country";

    public CardBrandsService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(environment, consumerKey, privateKey);
        this.mtfUrl = "https://api.mastercard.com/mtf/masterpass/v6/card-brands?Format=XML";
        this.sandboxUrl = "https://sandbox.api.mastercard.com/masterpass/partner/v6/card-brands?Format=XML";
        this.productionUrl = "https://api.mastercard.com/masterpass/partner/v6/card-brands?Format=XML";
    }
    
    protected String getUrl(CardBrandsOptions options) {
        String url = super.getUrl();
        if(url != null) {
        	url = URLUtil.addQueryParameter(url, LANGUAGE_QUERY, options.getLanguage());
            url = URLUtil.addQueryParameter(url, COUNTRY_QUERY, options.getCountry());
        }
        return url;
    }

    public CardBrandsResponse getCardBrandsResponse(CardBrandsOptions options) {
        String response = doRequest(getUrl(options), GET, null).get(MESSAGE);
        CardBrandsResponse cardResponse = (CardBrandsResponse) stringToXml(response, CardBrandsResponse.class);
        return cardResponse;
    }
}

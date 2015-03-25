package com.mastercard.api.partnerwallet.services.walletstorage;

import com.mastercard.api.common.Environment;
import com.mastercard.api.partnerwallet.domain.all.Card;
import com.mastercard.api.partnerwallet.domain.all.Wallet;
import com.mastercard.api.partnerwallet.services.common.AbstractPartnerService;

import java.security.PrivateKey;
import java.util.Map;

import javax.xml.bind.JAXBElement;

public class CardService extends AbstractPartnerService{

    String sandboxUpdateUrl;
    String productionUpdateUrl;
    String mtfUpdateUrl;

    public CardService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(environment, consumerKey, privateKey);
        this.environment = environment;
        this.sandboxUrl = "https://sandbox.api.mastercard.com/masterpass/partner/v6/wallet-provider/<wallet_provider_id>/wallet/<wallet_id>/card?Format=XML";
        this.sandboxUpdateUrl = "https://sandbox.api.mastercard.com/masterpass/partner/v6/wallet-provider/<wallet_provider_id>/wallet/<wallet_id>/card/<card_id>?Format=XML";
        this.productionUrl = "https://api.mastercard.com/masterpass/partner/v6/wallet-provider/<wallet_provider_id>/wallet/<wallet_id>/card?Format=XML";
        this.productionUpdateUrl = "https://api.mastercard.com/masterpass/partner/v6/wallet-provider/<wallet_provider_id>/wallet/<wallet_id>/card/<card_id>?Format=XML";
        this.mtfUrl = "https://api.mastercard.com/mtf/masterpass/partner/v6/wallet-provider/<wallet_provider_id>/wallet/<wallet_id>/card?Format=XML";
        this.mtfUpdateUrl = "https://api.mastercard.com/mtf/masterpass/partner/v6/wallet-provider/<wallet_provider_id>/wallet/<wallet_id>/card/<card_id>?Format=XML";
    }

    protected String getUrl(String method, String walletProviderId, String walletId, String cardId){
        String url;
        switch(environment) {
            case PRODUCTION:
                if (method.equals(POST)){
                    url = this.productionUrl;
                } else {
                    url = this.productionUpdateUrl;
                }
                break;
            case SANDBOX:
                if (method.equals(POST)){
                    url = this.sandboxUrl;
                } else {
                    url = this.sandboxUpdateUrl;
                }
                break;
            case MTF:
                if (method.equals(POST)){
                    url = this.mtfUrl;
                } else {
                    url = this.mtfUpdateUrl;
                }
                break;
            default:
                url = null;
        }
        url = url.replace("<wallet_provider_id>", walletProviderId);
        url = url.replace("<wallet_id>", walletId);
        if ((!method.equals(POST)) && cardId != null){
            url = url.replace("<card_id>", cardId);
        }
        return url;
    }

    public Wallet getCard(String walletProviderId, String walletId, String cardId) {
        Map<String,String> responseMap = doRequest(
                getUrl(GET, walletProviderId, walletId, cardId),
                GET,
                null
        );
        String response = responseMap.get(MESSAGE);
        JAXBElement<Wallet> connectedResponse = (JAXBElement<Wallet>) stringToXml(response,  Wallet.class);
        return connectedResponse.getValue();
    }

    public String createCard(String walletProviderId, String walletId, Card card) {
        Map<String,String> responseMap = doRequest(
                getUrl(POST, walletProviderId, walletId, null),
                POST,
                xmlToString(card)
        );
        return responseMap.get(MESSAGE);
    }

    public String updateCard(String walletProviderId, String walletId, String cardId, Card card) {
        Map<String,String> responseMap = doRequest(
                getUrl(PUT, walletProviderId, walletId, cardId),
                PUT,
                xmlToString(card)
        );
        return responseMap.get(MESSAGE);
    }

    public String deleteCard(String walletProviderId, String walletId, String cardId) {
        Map<String,String> responseMap = doRequest(
                getUrl(DELETE, walletProviderId, walletId, cardId),
                DELETE,
                null
        );
        return responseMap.get(MESSAGE);
    }

}

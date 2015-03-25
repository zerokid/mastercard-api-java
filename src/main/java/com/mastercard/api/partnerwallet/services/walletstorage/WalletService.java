package com.mastercard.api.partnerwallet.services.walletstorage;

import com.mastercard.api.common.Environment;
import com.mastercard.api.partnerwallet.domain.all.Card;
import com.mastercard.api.partnerwallet.domain.all.Wallet;
import com.mastercard.api.partnerwallet.services.common.AbstractPartnerService;

import java.security.PrivateKey;
import java.util.Map;

import javax.xml.bind.JAXBElement;

public class WalletService extends AbstractPartnerService {

    public WalletService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(environment, consumerKey, privateKey);
        this.environment = environment;
        this.sandboxUrl = "https://sandbox.api.mastercard.com/masterpass/partner/v6/wallet-provider/<wallet_provider_id>/wallet/<wallet_id>?Format=XML";
        this.productionUrl = "https://api.mastercard.com/masterpass/partner/v6/wallet-provider/<wallet_provider_id>/wallet/<wallet_id>?Format=XML";
        this.mtfUrl = "https://api.mastercard.com/mtf/masterpass/partner/v6/wallet-provider/<wallet_provider_id>/wallet/<wallet_id>?Format=XML";
    }

    protected String getUrl(String method, Long walletProviderId, Long walletId) {
        String url = "";
        switch(environment) {
            case PRODUCTION:
                url = this.productionUrl;
                break;
            case SANDBOX:
                url = this.sandboxUrl;
                break;
            case MTF:
                url = this.mtfUrl;
                break;
            default:
                url = null;
        }
        url = url.replace("<wallet_provider_id>", String.valueOf(walletProviderId));
        if ((!method.equals(POST)) && walletId != null) {
            url = url.replace("<wallet_id>", String.valueOf(walletId));
        }
        return url;
    }

    public Wallet readWallet(Long walletProviderId, Long walletId) {
        Map<String,String> responseMap = doRequest(
                getUrl(GET, walletProviderId, walletId),
                GET,
                null
        );
        String response = responseMap.get(MESSAGE);
        JAXBElement<Wallet> connectedResponse = (JAXBElement<Wallet>) stringToXml(response,  Wallet.class);
        return connectedResponse.getValue();
    }

    public String createWallet(Long walletProviderId, Card card) {
        Map<String,String> responseMap = doRequest(
                getUrl(POST, walletProviderId, null),
                POST,
                xmlToString(card)
        );
        return responseMap.get(MESSAGE);
    }

    public void deleteWallet(Long walletProviderId, Long walletId) {
        Map<String,String> responseMap = doRequest(
                getUrl(DELETE, walletProviderId, walletId),
                DELETE,
                null
        );
    }

}

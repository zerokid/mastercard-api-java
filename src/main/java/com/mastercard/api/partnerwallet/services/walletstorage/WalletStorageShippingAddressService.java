package com.mastercard.api.partnerwallet.services.walletstorage;

import com.mastercard.api.common.Environment;
import com.mastercard.api.partnerwallet.domain.all.ShippingAddress;
import com.mastercard.api.partnerwallet.services.common.AbstractPartnerService;

import java.security.PrivateKey;
import java.util.Map;

import javax.xml.bind.JAXBElement;

public class WalletStorageShippingAddressService extends AbstractPartnerService {

    String sandboxUpdateUrl;
    String productionUpdateUrl;
    String mtfUpdateUrl;

    public WalletStorageShippingAddressService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(environment, consumerKey, privateKey);
        this.environment = environment;
        this.sandboxUrl = "https://sandbox.api.mastercard.com/masterpass/partner/v6/wallet-provider/<wallet_provider_id>/wallet/<wallet_id>/shipping-address?Format=XML";
        this.sandboxUpdateUrl = "https://sandbox.api.mastercard.com/masterpass/partner/v6/wallet-provider/<wallet_provider_id>/wallet/<wallet_id>/shipping-address/<shipping_address_id>?Format=XML";
        this.productionUrl = "https://api.mastercard.com/masterpass/partner/v6/wallet-provider/<wallet_provider_id>/wallet/<wallet_id>/shipping-address/<shipping_address_id>?Format=XML";
        this.productionUpdateUrl = "https://api.mastercard.com/masterpass/partner/v6/wallet-provider/<wallet_provider_id>/wallet/<wallet_id>/shipping-address/<shipping_address_id>?Format=XML";
        this.mtfUrl = "https://api.mastercard.com/mtf/masterpass/partner/v6/wallet-provider/<wallet_provider_id>/wallet/<wallet_id>/shipping-address?Format=XML";
        this.mtfUpdateUrl = "https://api.mastercard.com/mtf/masterpass/partner/v6/wallet-provider/<wallet_provider_id>/wallet/<wallet_id>/shipping-address/<shipping_address_id>?Format=XML";
    }

    protected String getUrl(String method, String walletProviderId, String walletId, String shippingAddressId) {
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
        if ((!method.equals(POST)) && shippingAddressId != null){
            url = url.replace("<shipping_address_id>", shippingAddressId);
        }
        return url;
    }

    public ShippingAddress getShippingAddress(String walletProviderId, String walletId, String shippingAddressId) {
        Map<String,String> responseMap = doRequest(
                getUrl(GET, walletProviderId, walletId, shippingAddressId),
                GET,
                null
        );
        String response = responseMap.get(MESSAGE);
        JAXBElement<ShippingAddress> connectedResponse = (JAXBElement<ShippingAddress>) stringToXml(response,  ShippingAddress.class);
        return connectedResponse.getValue();
    }

    public String createShippingAddress(String walletProviderId, String walletId, ShippingAddress shippingAddress) {
        Map<String,String> responseMap = doRequest(
                getUrl(POST, walletProviderId, walletId, null),
                POST,
                xmlToString(shippingAddress)
        );
        return responseMap.get(MESSAGE);
    }

    public String updateShippingAddress(String walletProviderId, String walletId, String shippingAddressId, ShippingAddress shippingAddress) {
        Map<String,String> responseMap = doRequest(
                getUrl(PUT, walletProviderId, walletId, shippingAddressId),
                PUT,
                xmlToString(shippingAddress)
        );
        return responseMap.get(MESSAGE);
    }

    public String deleteShippingAddress(String walletProviderId, String walletId, String shippingAddressId) {
        Map<String,String> responseMap = doRequest(
                getUrl(DELETE, walletProviderId, walletId, shippingAddressId),
                DELETE,
                null
        );
        return responseMap.get(MESSAGE);
    }

}

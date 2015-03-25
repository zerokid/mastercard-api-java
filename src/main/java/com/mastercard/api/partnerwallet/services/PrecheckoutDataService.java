package com.mastercard.api.partnerwallet.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.partnerwallet.domain.switchapi.WalletPrecheckoutDataRequest;
import com.mastercard.api.partnerwallet.services.common.AbstractPartnerService;

import java.security.PrivateKey;
import java.util.Map;

public class PrecheckoutDataService extends AbstractPartnerService {

    public PrecheckoutDataService(Environment environment, String consumerKey, PrivateKey privateKey, String walletUrl) {
        super(environment, consumerKey, privateKey);
        this.sandboxUrl = null;
        this.productionUrl = "https://" + walletUrl + "/walletapi/wallet/v6/precheckout?Format=XML";
        this.mtfUrl = null;
    }

    public int postRequest(WalletPrecheckoutDataRequest request) {
        Map<String,String> responseMap = doRequest(
                getUrl(),
                POST,
                xmlToString(request)
        );
        String response = responseMap.get(HTTP_CODE);
        return Integer.valueOf(response);
    }

}

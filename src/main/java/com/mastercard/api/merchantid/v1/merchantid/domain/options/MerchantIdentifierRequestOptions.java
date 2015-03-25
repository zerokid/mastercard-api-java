package com.mastercard.api.merchantid.v1.merchantid.domain.options;

public class MerchantIdentifierRequestOptions {

    private String merchantId;
    private String type;

    public MerchantIdentifierRequestOptions(String merchantId)  {
        this.merchantId = merchantId;
    }

    public String getMerchantId() { return merchantId; }

    public String getType() { return type; }

    public MerchantIdentifierRequestOptions setType(String type) {
        this.type = type;
        return this;
    }
}

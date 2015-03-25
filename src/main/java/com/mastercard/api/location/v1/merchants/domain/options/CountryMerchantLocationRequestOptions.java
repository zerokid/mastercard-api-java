package com.mastercard.api.location.v1.merchants.domain.options;

public class CountryMerchantLocationRequestOptions {

    private String details;

    public CountryMerchantLocationRequestOptions(String details){
        this.details = details;
    }

    public String getDetails(){
        return this.details;
    }
}

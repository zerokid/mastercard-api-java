package com.mastercard.api.location.v1.merchants.domain.options;

public class CountrySubdivisionMerchantLocationRequestOptions {

    private String details;
    private String country;

    public CountrySubdivisionMerchantLocationRequestOptions(String details, String country){
        this.details = details;
        this.country = country;
    }

    public String getDetails() {
        return details;
    }

    public String getCountry() {
        return country;
    }
}

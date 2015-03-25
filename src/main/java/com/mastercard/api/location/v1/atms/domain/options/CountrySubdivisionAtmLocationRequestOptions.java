package com.mastercard.api.location.v1.atms.domain.options;

public class CountrySubdivisionAtmLocationRequestOptions {

    private String country;

    public CountrySubdivisionAtmLocationRequestOptions(String country){
        this.country = country;
    }

    public String getCountry(){
        return this.country;
    }
}

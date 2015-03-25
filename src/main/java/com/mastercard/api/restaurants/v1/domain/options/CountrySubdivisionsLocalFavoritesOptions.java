package com.mastercard.api.restaurants.v1.domain.options;

public class CountrySubdivisionsLocalFavoritesOptions {
    private String country;

    public CountrySubdivisionsLocalFavoritesOptions(String country) {
        setCountry(country);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

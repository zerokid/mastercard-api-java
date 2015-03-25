package com.mastercard.api.partnerwallet.domain.options;

public class CardBrandsOptions {
    private String language;
    private String country;

    public CardBrandsOptions(String language, String country) {
        this.language = language;
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }
    public String getCountry() {
        return country;
    }
}

package com.mastercard.api.location.v1.merchants.domain.options;

public class MerchantLocationRequestOptions {

    public static final String MILE = "mile";
    public static final String KILOMETER = "kilometer";

    private String details;
    private Integer pageOffset;
    private Integer pageLength;
    private String category;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String countrySubdivision;
    private String postalCode;
    private String country;
    private Double latitude;
    private Double longitude;
    private String distanceUnit;
    private Integer radius;
    private Long merchantId;
    private Integer internationalMaestroAccepted;

    public MerchantLocationRequestOptions(String details, Integer pageOffset, Integer pageLength){
        this.details = details;
        this.pageOffset = pageOffset;
        this.pageLength = pageLength;
        if (this.pageLength > 25){
            this.pageLength = 25;
        }
    }

    public String getDetails() {
        return details;
    }

    public Integer getPageOffset() {
        return pageOffset;
    }

    public Integer getPageLength() {
        return pageLength;
    }

    public String getCategory() {
        return category;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getCountrySubdivision() {
        return countrySubdivision;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getDistanceUnit() {
        return distanceUnit;
    }

    public Integer getRadius() {
        return radius;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public MerchantLocationRequestOptions setCategory(String category) {
        this.category = category;
        return this;
    }

    public MerchantLocationRequestOptions setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    public MerchantLocationRequestOptions setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    public MerchantLocationRequestOptions setCity(String city) {
        this.city = city;
        return this;
    }

    public MerchantLocationRequestOptions setCountrySubdivision(String countrySubdivision) {
        this.countrySubdivision = countrySubdivision;
        return this;
    }

    public MerchantLocationRequestOptions setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public MerchantLocationRequestOptions setCountry(String country) {
        this.country = country;
        return this;
    }

    public MerchantLocationRequestOptions setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public MerchantLocationRequestOptions setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public MerchantLocationRequestOptions setDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
        return this;
    }

    public MerchantLocationRequestOptions setRadius(Integer radius) {
        this.radius = radius;
        if (radius > 100) {
            this.radius = 100;
        }
        return this;
    }

    public MerchantLocationRequestOptions setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    public void setInternationalMaestroAccepted(boolean isAccepted){
        // only option to pass is 1.  Otherwise we do not use the query parameter.
        if (isAccepted) {
            this.internationalMaestroAccepted = 1;
        } else {
            this.internationalMaestroAccepted = null;
        }
    }

    public Integer getInternationalMaestroAccepted(){
        return this.internationalMaestroAccepted;
    }
}

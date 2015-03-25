package com.mastercard.api.location.v1.atms.domain.options;

public class AtmLocationRequestOptions {
    private Integer pageOffset;
    private Integer pageLength;
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
    private Integer supportEmv;

    public static String MILE = "MILE";
    public static String KILOMETER = "KILOMETER";

    public static final Integer SUPPORT_EMV_YES = 1;
    public static final Integer SUPPORT_EMV_NO = 2;
    public static final Integer SUPPORT_EMV_UNKNOWN = 0;


    public AtmLocationRequestOptions(Integer pageOffset, Integer pageLength){
        this.pageOffset = pageOffset;
        this.pageLength = pageLength;
        if (this.pageLength > 25){
            this.pageLength = 25;
        }
    }

    public Integer getPageOffset() {
        return pageOffset;
    }

    public Integer getPageLength() {
        return pageLength;
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

    public Integer getSupportEmv() {
        return supportEmv;
    }

    public AtmLocationRequestOptions setPageOffset(Integer pageOffset) {
        this.pageOffset = pageOffset;
        return this;
    }

    public AtmLocationRequestOptions setPageLength(Integer pageLength) {
        this.pageLength = pageLength;
        return this;
    }

    public AtmLocationRequestOptions setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    public AtmLocationRequestOptions setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    public AtmLocationRequestOptions setCity(String city) {
        this.city = city;
        return this;
    }

    public AtmLocationRequestOptions setCountrySubdivision(String countrySubdivision) {
        this.countrySubdivision = countrySubdivision;
        return this;
    }

    public AtmLocationRequestOptions setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public AtmLocationRequestOptions setCountry(String country) {
        this.country = country;
        return this;
    }

    public AtmLocationRequestOptions setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public AtmLocationRequestOptions setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public AtmLocationRequestOptions setDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
        return this;
    }

    public AtmLocationRequestOptions setRadius(Integer radius) {
        this.radius = radius;
        if (this.radius > 100){
            this.radius = 100;
        }
        return this;
    }

    public AtmLocationRequestOptions setSupportEmv(Integer supportEmv) {
        this.supportEmv = supportEmv;
        return this;
    }
}

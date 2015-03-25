package com.mastercard.api.restaurants.v1.domain.options;

public class RestaurantsLocalFavoritesOptions {
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

    public RestaurantsLocalFavoritesOptions(Integer pageOffset, Integer pageLength){
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

    public String getCategory() { return category; }

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

    public RestaurantsLocalFavoritesOptions setCategory(String category){
        this.category = category;
        return this;
    }

    public RestaurantsLocalFavoritesOptions setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    public RestaurantsLocalFavoritesOptions setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    public RestaurantsLocalFavoritesOptions setCity(String city) {
        this.city = city;
        return this;
    }

    public RestaurantsLocalFavoritesOptions setCountrySubdivision(String countrySubdivision) {
        this.countrySubdivision = countrySubdivision;
        return this;
    }

    public RestaurantsLocalFavoritesOptions setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public RestaurantsLocalFavoritesOptions setCountry(String country) {
        this.country = country;
        return this;
    }

    public RestaurantsLocalFavoritesOptions setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public RestaurantsLocalFavoritesOptions setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public RestaurantsLocalFavoritesOptions setDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
        return this;
    }

    public RestaurantsLocalFavoritesOptions setRadius(Integer radius) {
        this.radius = radius;
        if (this.radius > 100){
            this.radius = 100;
        }
        return this;
    }
}

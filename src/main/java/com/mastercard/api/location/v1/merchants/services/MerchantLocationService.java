package com.mastercard.api.location.v1.merchants.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.common.util.URLUtil;
import com.mastercard.api.location.v1.merchants.domain.Merchants;
import com.mastercard.api.location.v1.merchants.domain.options.MerchantLocationRequestOptions;

import java.security.PrivateKey;
import java.util.Map;

public class MerchantLocationService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/merchants/v1/merchant?Format=XML";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/merchants/v1/merchant?Format=XML";

    public MerchantLocationService(Environment environment, String consumerKey, PrivateKey privateKey){
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    public Merchants getMerchants(MerchantLocationRequestOptions options){
        Map<String,String> responseMap = doRequest(
                getURL(options),
                GET,
                null
        );
        String response = responseMap.get(MESSAGE);
        return (Merchants) stringToXml(response, Merchants.class);
    }

    private String getURL(MerchantLocationRequestOptions options){
        String url;
        if (this.environment.equals(Environment.PRODUCTION)){
            url = PRODUCTION_URL;
        } else {
            url = SANDBOX_URL;
        }
        url = URLUtil.addQueryParameter(url, "Details", options.getDetails());
        url = URLUtil.addQueryParameter(url, "PageOffset", String.valueOf(options.getPageOffset()));
        url = URLUtil.addQueryParameter(url, "PageLength", String.valueOf(options.getPageLength()));
        url = URLUtil.addQueryParameter(url, "Category", options.getCategory());
        url = URLUtil.addQueryParameter(url, "AddressLine1", options.getAddressLine1());
        url = URLUtil.addQueryParameter(url, "AddressLine2", options.getAddressLine2());
        url = URLUtil.addQueryParameter(url, "City", options.getCity());
        url = URLUtil.addQueryParameter(url, "CountrySubdivision", options.getCountrySubdivision());
        url = URLUtil.addQueryParameter(url, "PostalCode", options.getPostalCode());
        url = URLUtil.addQueryParameter(url, "Country", options.getCountry());
        url = URLUtil.addQueryParameter(url, "Latitude", String.valueOf(options.getLatitude()));
        url = URLUtil.addQueryParameter(url, "Longitude", String.valueOf(options.getLongitude()));
        url = URLUtil.addQueryParameter(url, "DistanceUnit", options.getDistanceUnit());
        url = URLUtil.addQueryParameter(url, "Radius", String.valueOf(options.getRadius()));
        url = URLUtil.addQueryParameter(url, "OfferMerchantId", String.valueOf(options.getMerchantId()));
        url = URLUtil.addQueryParameter(url, "InternationalMaestroAccepted", String.valueOf(options.getInternationalMaestroAccepted()));
        return url;
    }
}

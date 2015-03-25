package com.mastercard.api.billpay.v1;

import java.security.PrivateKey;
import java.util.Map;
import com.mastercard.api.billpay.v1.domain.*;
import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;

public class RoutingValidationService extends Connector {

    private final Environment environment;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/billpayAPI/v1/isRoutingValid?Format=XML";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/billpayAPI/v1/isRoutingValid?Format=XML";

    public RoutingValidationService(Environment environment, String consumerKey, PrivateKey privateKey){
        super(consumerKey, privateKey);
        this.environment = environment;
    }

    public BillPayAccountValidation getBillPayAccountValidation(BillPayAccountValidation request){
        Map<String,String> responseMap = doRequest(
                getURL(),
                POST,
                xmlToString(request)
        );
        String response = responseMap.get(MESSAGE);
        return (BillPayAccountValidation) stringToXml(response, BillPayAccountValidation.class);
    }

    private String getURL(){
        if (environment.equals(Environment.PRODUCTION)){
            return PRODUCTION_URL;
        } else {
            return SANDBOX_URL;
        }
    }

}
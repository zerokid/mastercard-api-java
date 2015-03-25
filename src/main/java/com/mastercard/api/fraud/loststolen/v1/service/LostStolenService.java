package com.mastercard.api.fraud.loststolen.v1.service;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.common.OAuthParameters;
import com.mastercard.api.fraud.loststolen.v1.domain.Account;
import com.mastercard.api.fraud.loststolen.v1.domain.AccountInquiry;
import com.mastercard.api.fraud.loststolen.v1.domain.factory.ObjectFactory;

import java.security.PrivateKey;
import java.util.Map;

public class LostStolenService extends Connector {

    private final Environment env;

    private static final String SANDBOX_URL = "https://sandbox.api.mastercard.com/fraud/loststolen/v1/account-inquiry?Format=XML";
    private static final String PRODUCTION_URL = "https://api.mastercard.com/fraud/loststolen/v1/account-inquiry?Format=XML";

    /**
     * Constructor to obtain api for calling into the Lost/Stolen Account List service
     * @param environment - Environment.sandbox or Environment.product for sandbox access or production access
     *                      respectively
     * @param consumerKey - Developer Zone consumer key
     * @param privateKey  - PrivateKey
     */

    public LostStolenService(Environment environment, String consumerKey, PrivateKey privateKey){
        super(consumerKey, privateKey);
        this.env = environment;
    }

    /**
     * @param accountNumber - credit card number being checked against the Lost/Stolen Account List
     * @return Account - Account object containing status information
     */

    public Account getLostStolen(String accountNumber){
        AccountInquiry accountInquiry = (new ObjectFactory()).createAccountInquiry(accountNumber);
        Map<String, String> responseMap = doRequest(getURL(), PUT, xmlToString(accountInquiry));
        String response = responseMap.get(MESSAGE);
        return (Account) stringToXml(response, Account.class);
    }

    private String getURL(){
        if (this.env == Environment.PRODUCTION){
            return PRODUCTION_URL;
        } else {
            return SANDBOX_URL;
        }
    }
}

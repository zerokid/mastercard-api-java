package com.mastercard.api.fraud.merchant.v1.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.common.util.URLUtil;
import com.mastercard.api.fraud.merchant.v1.domain.TerminationInquiry;
import com.mastercard.api.fraud.merchant.v1.domain.options.TerminationInquiryHistoryOptions;

import java.security.PrivateKey;
import java.util.Map;

public class TerminationInquiryHistoryService extends Connector {

    private final Environment env;

    private final String SANDBOX_URL =
            "https://sandbox.api.mastercard.com/fraud/merchant/v1/termination-inquiry/%d?Format=XML";
    private final String PRODUCTION_URL =
            "https://api.mastercard.com/fraud/merchant/v1/termination-inquiry/%d?Format=XML";

    /**     *
     * @param environment - Environment.SANDBOX or Environment.PRODUCTION depending on target data
     * @param consumerKey -
     * @param privateKey -
     */

    public TerminationInquiryHistoryService(Environment environment, String consumerKey, PrivateKey privateKey){
        super(consumerKey, privateKey);
        this.env = environment;
    }

    /**
     * Method to return TerminationInquiry object containing POJO representation of data returned by API call.
     * @param options - object containing offest, page length, and acquirer ID.
     * @return - TerminationInquiry
     */

    public TerminationInquiry getTerminationInquiry(TerminationInquiryHistoryOptions options){
        Map<String, String> responseMap = doRequest(
                getURL(options.getPageOffset(), options.getPageLength(), options.getAcquirerId(), options.getInquiryReferenceNumber()),
                GET,
                null
        );
        String response = responseMap.get(MESSAGE);
        return (TerminationInquiry) stringToXml(response, TerminationInquiry.class);
    }

    private String getURL(int offset, int pageLength, int acquirerId, long inquiryReferenceNumber){
        String url;
        if (this.env == Environment.PRODUCTION){
            url = PRODUCTION_URL;
        } else {
            url = SANDBOX_URL;
        }

        url = String.format(url, inquiryReferenceNumber);

        url = URLUtil.addQueryParameter(url, "PageOffset", String.valueOf(offset));
        url = URLUtil.addQueryParameter(url, "PageLength", String.valueOf(pageLength));
        url = URLUtil.addQueryParameter(url, "AcquirerId", String.valueOf(acquirerId));

        return url;
    }
}

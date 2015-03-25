package com.mastercard.api.fraud.merchant.v1.services;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;
import com.mastercard.api.common.util.URLUtil;
import com.mastercard.api.fraud.merchant.v1.domain.TerminationInquiry;
import com.mastercard.api.fraud.merchant.v1.domain.TerminationInquiryRequest;
import com.mastercard.api.fraud.merchant.v1.domain.options.TerminationInquiryRequestOptions;

import java.security.PrivateKey;
import java.util.Map;

public class TerminationInquiryService extends Connector {
    private final Environment env;

    private final String SANDBOX_URL =
            "https://sandbox.api.mastercard.com/fraud/merchant/v1/termination-inquiry?Format=XML";
    private final String PRODUCTION_URL =
            "https://api.mastercard.com/fraud/merchant/v1/termination-inquiry?Format=XML";

    /**     *
     * @param environment - Environment.SANDBOX or Environment.PRODUCTION depending on target data
     * @param consumerKey -
     * @param privateKey -
     */

    public TerminationInquiryService(Environment environment, String consumerKey, PrivateKey privateKey){
        super(consumerKey, privateKey);
        this.env = environment;
    }

    /**
     * Method to return TerminationInquiry POJO containing API call data
     * @param request - request object containing data specific to inquiry
     * @param options - options object containing offset and pagelength options
     * @return - POJO for use to obtain History information
     */

    public TerminationInquiry getTerminationInquiry(TerminationInquiryRequest request,
                                                    TerminationInquiryRequestOptions options){
        Map<String, String> responseMap = doRequest(
                getURL(options.getPageOffset(), options.getPageLength()),
                POST,
                xmlToString(request)
        );
        String response = responseMap.get(MESSAGE);
        return (TerminationInquiry) stringToXml(response, TerminationInquiry.class);
    }

    private String getURL(int offset, int pageLength){
        String url;
        if (this.env == Environment.PRODUCTION){
            url = PRODUCTION_URL;
        } else {
            url = SANDBOX_URL;
        }

        url = URLUtil.addQueryParameter(url, "PageOffset", String.valueOf(offset));
        url = URLUtil.addQueryParameter(url, "PageLength", String.valueOf(pageLength));

        return url;
    }


}

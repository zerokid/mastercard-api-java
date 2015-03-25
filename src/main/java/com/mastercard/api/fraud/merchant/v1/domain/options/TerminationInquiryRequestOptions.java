package com.mastercard.api.fraud.merchant.v1.domain.options;

public class TerminationInquiryRequestOptions {
    private int pageOffset;
    private int pageLength;

    /**
     * Values must be set via constructor for this service.
     * @param pageOffset - offset to begin returned results at
     * @param pageLength - number of results to return, maximum 25
     */

    public TerminationInquiryRequestOptions(int pageOffset, int pageLength){
        this.pageOffset = pageOffset;
        this.pageLength = pageLength;
        if (this.pageLength > 25) {
            this.pageLength = 25;
        }
    }

    public int getPageOffset() {
        return this.pageOffset;
    }

    public int getPageLength() {
        return this.pageLength;
    }
}

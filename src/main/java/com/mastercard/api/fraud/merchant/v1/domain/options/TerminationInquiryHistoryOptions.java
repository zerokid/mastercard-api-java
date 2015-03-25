package com.mastercard.api.fraud.merchant.v1.domain.options;


public class TerminationInquiryHistoryOptions {

    private int pageOffset;
    private int pageLength;
    private int acquirerId;
    private long inquiryReferenceNumber;

    /**
     * Values must be set via constructor for this service.
     * @param pageOffset - offset to begin returned results at
     * @param pageLength - number of results to return, maximum 25
     * @param acquirerId - acquirer id associated with GET
     * @param inquiryReferenceNumber - user defined reference number
     */

    public TerminationInquiryHistoryOptions(int pageOffset, int pageLength, int acquirerId, long inquiryReferenceNumber){
        this.pageOffset = pageOffset;
        this.pageLength = pageLength;
        this.acquirerId = acquirerId;
        this.inquiryReferenceNumber = inquiryReferenceNumber;

        if (pageLength > 25){
            this.pageLength = 25;
        }
    }

    public int getPageOffset() {
        return pageOffset;
    }

    public int getPageLength() {
        return pageLength;
    }

    public int getAcquirerId() {
        return acquirerId;
    }

    public long getInquiryReferenceNumber() {
        return inquiryReferenceNumber;
    }

}

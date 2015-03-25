package com.mastercard.api.fraud.merchant.v1.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.fraud.merchant.v1.domain.PrincipalType;
import com.mastercard.api.fraud.merchant.v1.domain.TerminationInquiry;
import com.mastercard.api.fraud.merchant.v1.domain.TerminationInquiryRequest;
import com.mastercard.api.fraud.merchant.v1.domain.factory.ObjectFactory;
import com.mastercard.api.fraud.merchant.v1.domain.options.TerminationInquiryHistoryOptions;
import com.mastercard.api.fraud.merchant.v1.domain.options.TerminationInquiryRequestOptions;
import junit.framework.TestCase;
import utils.TestUtils;

public class TerminationInquiryHistoryServiceTest extends TestCase {

    TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    TerminationInquiryService service  = new TerminationInquiryService(
            Environment.SANDBOX,
            testUtils.getConsumerKey(),
            testUtils.getPrivateKey()
    );
    TerminationInquiryHistoryService historyService = new TerminationInquiryHistoryService(
            Environment.SANDBOX,
            testUtils.getConsumerKey(),
            testUtils.getPrivateKey()
    );
    TerminationInquiryRequest request;
    ObjectFactory factory = new ObjectFactory();

    public void setUp(){
        this.request = factory.createTerminationInquiryRequest();
        request.setAcquirerId("1996");
        request.setTransactionReferenceNumber("12345");
        request.getMerchant().setName("TERMINATED MERCHANT 2");
        request.getMerchant().setDoingBusinessAsName("DOING BUSINESS AS TERMINATED MERCHANT 2");
        request.getMerchant().setPhoneNumber("5555555555");
        request.getMerchant().getAddress().setLine1("20 EAST MAIN ST");
        request.getMerchant().getAddress().setLine2("EAST ISLIP           NY");
        request.getMerchant().getAddress().setCity("EAST ISLIP");
        request.getMerchant().getAddress().setCountrySubdivision("NY");
        request.getMerchant().getAddress().setPostalCode("55555");
        request.getMerchant().getAddress().setCountry("USA");
        request.getMerchant().setCountrySubdivisionTaxId("205545287");
        request.getMerchant().setNationalTaxId("2891327625");
        PrincipalType principal = factory.createPrincipalType();
        principal.setFirstName("PATRICIA");
        principal.setLastName("CLARKE");
        principal.setNationalId("4236559970");
        principal.setPhoneNumber("5555555555");
        principal.getAddress().setLine1("93-52 243 STREET");
        principal.getAddress().setCity("BELLEROSE");
        principal.getAddress().setCountrySubdivision("NY");
        principal.getAddress().setPostalCode("55555-5555");
        principal.getAddress().setCountry("USA");
        request.getMerchant().getPrincipal().add(principal);
    }

    public void testService(){
        TerminationInquiry inquiry = service.getTerminationInquiry(
                request,
                new TerminationInquiryRequestOptions(0,10)
        );
        assertTrue(inquiry.getTerminatedMerchant().size() > 0);
        assertTrue(inquiry.getRef() != null && inquiry.getRef().length() > 0);
        assertTrue(inquiry.getTransactionReferenceNumber() != null && inquiry.getTransactionReferenceNumber().length() > 0);

        assertTrue(inquiry.getReferenceId().length() > 0);

        TerminationInquiryHistoryOptions historyOptions = new TerminationInquiryHistoryOptions(
                0,
                10,
                1996,
                Long.valueOf(inquiry.getReferenceId())
        );

        TerminationInquiry terminationInquiry = historyService.getTerminationInquiry(historyOptions);
        //need xsd to validate return object
        //assertTrue(testUtils.validateXML(terminationInquiry, "terminationInquiry.xsd"));
    }
}

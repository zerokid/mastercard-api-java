package com.mastercard.api.billpay.v1.services;

import com.mastercard.api.billpay.v1.RoutingValidationService;
import com.mastercard.api.billpay.v1.domain.BillPayAccountValidation;
import com.mastercard.api.billpay.v1.domain.factory.ObjectFactory;
import com.mastercard.api.common.Environment;
import junit.framework.TestCase;
import utils.TestUtils;

public class RoutingValidationServiceTest extends TestCase {

    RoutingValidationService service;
    TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    ObjectFactory factory = new ObjectFactory();
    BillPayAccountValidation validationRequest;
    BillPayAccountValidation validationResponse;

    public void setUp() {
        service = new RoutingValidationService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
    }

    public void testRoutingValidationServiceSuccess() {
        validationRequest = factory.createBillPayAccountValidation();
        validationRequest.setRppsId("99887761");
        validationRequest.setBillerId("9998887771");
        validationRequest.setAccountNumber("1234567890");
        validationRequest.setTransactionAmount("250.00");
        validationResponse = service.getBillPayAccountValidation(validationRequest);
        assert(validationResponse.getResponseString().equals("Successful"));
        assert(testUtils.validateXML(validationResponse, "BillPayAccountValidation.xsd"));
    }

    public void testRoutingValidationServiceInvalidRppsid() {
        validationRequest = factory.createBillPayAccountValidation();
        validationRequest.setRppsId("00000000");
        validationRequest.setBillerId("9998887771");
        validationRequest.setAccountNumber("1234567890");
        validationRequest.setTransactionAmount("250.00");
        validationResponse = service.getBillPayAccountValidation(validationRequest);
        assert(validationResponse.getResponseString().equals("Invalid RPPSID"));
        assert(testUtils.validateXML(validationResponse, "BillPayAccountValidation.xsd"));
    }

    public void testRoutingValidationServiceInactiveRppsid() {
        validationRequest = factory.createBillPayAccountValidation();
        validationRequest.setRppsId("99887760");
        validationRequest.setBillerId("9998887771");
        validationRequest.setAccountNumber("1234567890");
        validationRequest.setTransactionAmount("250.00");
        validationResponse = service.getBillPayAccountValidation(validationRequest);
        assert(validationResponse.getResponseString().equals("RPPSID is not active"));
        assert(testUtils.validateXML(validationResponse, "BillPayAccountValidation.xsd"));
    }

    public void testRoutingValidationServiceInvalidBillerId() {
        validationRequest = factory.createBillPayAccountValidation();
        validationRequest.setRppsId("99887761");
        validationRequest.setBillerId("0000000000");
        validationRequest.setAccountNumber("1234567890");
        validationRequest.setTransactionAmount("250.00");
        validationResponse = service.getBillPayAccountValidation(validationRequest);
        assert(validationResponse.getResponseString().equals("Invalid BillerID"));
        assert(testUtils.validateXML(validationResponse, "BillPayAccountValidation.xsd"));
    }

    public void testRoutingValidationServiceInactiveBillerId() {
        validationRequest = factory.createBillPayAccountValidation();
        validationRequest.setRppsId("99887761");
        validationRequest.setBillerId("9998887772");
        validationRequest.setAccountNumber("1234567890");
        validationRequest.setTransactionAmount("250.00");
        validationResponse = service.getBillPayAccountValidation(validationRequest);
        assert(validationResponse.getResponseString().equals("BillerID is not active"));
        assert(testUtils.validateXML(validationResponse, "BillPayAccountValidation.xsd"));
    }

    public void testRoutingValidationServiceExceedsTransAmount() {
        validationRequest = factory.createBillPayAccountValidation();
        validationRequest.setRppsId("99887761");
        validationRequest.setBillerId("9998887771");
        validationRequest.setAccountNumber("1234567890");
        validationRequest.setTransactionAmount("5000.00");
        validationResponse = service.getBillPayAccountValidation(validationRequest);
        assert(validationResponse.getResponseString().equals("Transaction Amount exceeds BillerID maximum"));
        assert(testUtils.validateXML(validationResponse, "BillPayAccountValidation.xsd"));
    }

}

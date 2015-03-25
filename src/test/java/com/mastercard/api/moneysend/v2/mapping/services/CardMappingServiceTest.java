package com.mastercard.api.moneysend.v2.mapping.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.moneysend.v2.mapping.domain.*;
import com.mastercard.api.moneysend.v2.mapping.domain.factory.ObjectFactory;
import com.mastercard.api.moneysend.v2.mapping.domain.options.DeleteMappingRequestOptions;
import com.mastercard.api.moneysend.v2.mapping.domain.options.UpdateMappingRequestOptions;
import junit.framework.TestCase;
import utils.TestUtils;

public class CardMappingServiceTest extends TestCase {
    CardMappingService service;
    TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    ObjectFactory factory = new ObjectFactory();
    CreateMappingRequest createRequest;
    InquireMappingRequest inquireRequest;
    InquireMapping inquireMapping;
    UpdateMappingRequest updateRequest;

    public void setUp() {
        service = new CardMappingService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
    }

    public void testCreateMappingRequest() {
        createRequest = factory.createCreateMappingRequest();
        createRequest.setICA("009674");
        createRequest.setSubscriberId("example2@email.com");
        createRequest.setSubscriberType("EMAIL_ADDRESS");
        createRequest.setAccountUsage("RECEIVING");
        createRequest.setAccountNumber(5184680430000006L);
        createRequest.setDefaultIndicator("T");
        createRequest.setExpiryDate(201409);
        createRequest.setAlias("My Debit Card");
        createRequest.getAddress().setLine1("123 Main Street");
        createRequest.getAddress().setCity("OFallon");
        createRequest.getAddress().setCountrySubdivision("MO");
        createRequest.getAddress().setCountry("USA");
        createRequest.getAddress().setPostalCode(63368);
        createRequest.getCardholderFullName().setCardholderFirstName("John");
        createRequest.getCardholderFullName().setCardholderMiddleName("Q");
        createRequest.getCardholderFullName().setCardholderLastName("Public");
        createRequest.setDateOfBirth(19460102);
        CreateMapping createdMapping = service.getCreateMapping(createRequest);
        assertTrue(createdMapping != null);
        assertTrue(createdMapping.getMapping().getMappingId() > 0);
        assertTrue(createdMapping.getRequestId() > 0);
        assertTrue(testUtils.validateXML(createdMapping, "CreateMapping.xsd"));
    }

   public void testInquireMappingRequestFindOneAccountMapping() {
       inquireRequest = factory.createInquireMappingRequest();
       inquireRequest.setSubscriberId("16367227000");
       inquireRequest.setSubscriberType("PHONE_NUMBER");
       inquireRequest.setAccountUsage("SENDING");
       inquireRequest.setAlias("My Debit Card");
       inquireRequest.setDataResponseFlag(3);
       InquireMapping inquireMapping = service.getInquireMapping(inquireRequest);
       assertTrue(inquireMapping != null);
       assertTrue(inquireMapping.getRequestId() > 0);
       assertTrue(inquireMapping.getMappings().getMapping().get(0).getMappingId() != null && inquireMapping.getMappings().getMapping().get(0).getMappingId() > 0);
       assertTrue(testUtils.validateXML(inquireMapping, "InquireMapping.xsd"));
   }

    public void testInquireMappingRequestFindAccountMappings() {
        inquireRequest = factory.createInquireMappingRequest();
        inquireRequest.setSubscriberId("example2@email.com");
        inquireRequest.setSubscriberType("EMAIL_ADDRESS");
        inquireMapping = service.getInquireMapping(inquireRequest);
        assertTrue(inquireMapping != null);
        assertTrue(inquireMapping.getRequestId() > 0);
        assertTrue(inquireMapping.getMappings().getMapping().get(0).getMappingId() != null && inquireMapping.getMappings().getMapping().get(0).getMappingId() > 0);
        assertTrue(testUtils.validateXML(inquireMapping, "InquireMapping.xsd"));
    }


    public void testUpdateMappingRequest() {
        //InquireMappingRequest must be executed to obtain MappingID required for running UpdateMappingRequest.
        inquireRequest = factory.createInquireMappingRequest();
        inquireRequest.setSubscriberId("example2@email.com");
        inquireRequest.setSubscriberType("EMAIL_ADDRESS");
        InquireMapping inquireMapping = service.getInquireMapping(inquireRequest);
        assertTrue(inquireMapping.getMappings().getMapping().get(0).getMappingId() != null && inquireMapping.getMappings().getMapping().get(0).getMappingId() > 0);
        UpdateMappingRequestOptions updateOptions = new UpdateMappingRequestOptions();
        updateOptions.setMappingId(inquireMapping.getMappings().getMapping().get(0).getMappingId());
        updateRequest = factory.createUpdateMappingRequest();
        updateRequest.setAccountUsage("RECEIVING");
        updateRequest.setAccountNumber("5184680430000006");
        updateRequest.setDefaultIndicator("T");
        updateRequest.setExpiryDate(201407);
        updateRequest.setAlias("My Debit Card");
        updateRequest.getAddress().setLine1("123 Main Street");
        updateRequest.getAddress().setCity("OFallon");
        updateRequest.getAddress().setCountrySubdivision("MO");
        updateRequest.getAddress().setCountry("USA");
        updateRequest.getAddress().setPostalCode(63368);
        updateRequest.getCardholderFullName().setCardholderFirstName("John");
        updateRequest.getCardholderFullName().setCardholderMiddleName("X");
        updateRequest.getCardholderFullName().setCardholderLastName("Public");
        updateRequest.setDateOfBirth(19460102);
        UpdateMapping updatedMapping = service.getUpdateMapping(updateRequest, updateOptions);
        assertTrue(updatedMapping != null);
        assertTrue(updatedMapping.getRequestId() > 0);
        assertTrue(updatedMapping.getMapping().getMappingId() > 0);
        assertTrue(testUtils.validateXML(updatedMapping, "UpdateMapping.xsd"));
    }


   public void testDeleteMappingRequest() {
       //InquireMappingRequest must be executed to obtain MappingID required for running DeleteMappingRequest.
       inquireRequest = factory.createInquireMappingRequest();
       inquireRequest.setSubscriberId("16367227000");
       inquireRequest.setSubscriberType("PHONE_NUMBER");
       InquireMapping inquireMapping = service.getInquireMapping(inquireRequest);
       assertTrue(inquireMapping.getMappings().getMapping().get(0).getMappingId() != null && inquireMapping.getMappings().getMapping().get(0).getMappingId() > 0);
       DeleteMappingRequestOptions deleteOptions = new DeleteMappingRequestOptions();
       deleteOptions.setMappingId(inquireMapping.getMappings().getMapping().get(0).getMappingId());
       DeleteMapping deleteMapping = service.getDeleteMapping(deleteOptions);
       assertTrue(deleteMapping != null);
       assertTrue(deleteMapping.getRequestId() > 0);
       assertTrue(deleteMapping.getMapping().getMappingId() > 0);
       assertTrue(testUtils.validateXML(deleteMapping, "DeleteMapping.xsd"));
   }

}

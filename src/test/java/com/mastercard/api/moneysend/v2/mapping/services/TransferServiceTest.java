package com.mastercard.api.moneysend.v2.mapping.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.moneysend.v2.mapping.domain.*;
import com.mastercard.api.moneysend.v2.mapping.domain.factory.ObjectFactory;
import junit.framework.TestCase;
import utils.TestUtils;

public class TransferServiceTest extends TestCase {
    TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    TransferService service;
    ObjectFactory factory = new ObjectFactory();
    TransferRequest  transferRequestCard = new TransferRequest();
    TransferRequest transferRequestMapped = new TransferRequest();
    PaymentRequest paymentRequestCard = new PaymentRequest();
    PaymentRequest paymentRequestMapped = new PaymentRequest();

    public void setUp() {
        service = new TransferService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );
    }

    public void testTransferRequestCardTest() {
        transferRequestCard = factory.createTransferRequest();
        transferRequestCard.setLocalDate("1212");
        transferRequestCard.setLocalTime("161222");
        transferRequestCard.setTransactionReference(4000000001010102040L);
        transferRequestCard.setSenderName("John Doe");
        transferRequestCard.getSenderAddress().setLine1("123 Main Street");
        transferRequestCard.getSenderAddress().setLine2("#5A");
        transferRequestCard.getSenderAddress().setCity("Arlington");
        transferRequestCard.getSenderAddress().setCountrySubdivision("VA");
        transferRequestCard.getSenderAddress().setPostalCode(22207);
        transferRequestCard.getSenderAddress().setCountry("USA");
        transferRequestCard.getFundingCard().setAccountNumber(5184680430000006L);
        transferRequestCard.getFundingCard().setExpiryMonth(11);
        transferRequestCard.getFundingCard().setExpiryYear(2014);
        transferRequestCard.setFundingUCAF("MjBjaGFyYWN0ZXJqdW5rVUNBRjU=1111");
        transferRequestCard.setFundingMasterCardAssignedId(123456);
        transferRequestCard.getFundingAmount().setValue(15000);
        transferRequestCard.getFundingAmount().setCurrency(840);
        transferRequestCard.setReceiverName("Jose Lopez");
        transferRequestCard.getReceiverAddress().setLine1("Pueblo Street");
        transferRequestCard.getReceiverAddress().setLine2("PO BOX 12");
        transferRequestCard.getReceiverAddress().setCity("El PASO");
        transferRequestCard.getReceiverAddress().setCountrySubdivision("TX");
        transferRequestCard.getReceiverAddress().setPostalCode(79906);
        transferRequestCard.getReceiverAddress().setCountry("USA");
        transferRequestCard.setReceiverPhone(1800639426);
        transferRequestCard.getReceivingCard().setAccountNumber(5184680430000006L);
        transferRequestCard.getReceivingAmount().setValue(182206);
        transferRequestCard.getReceivingAmount().setCurrency(484);
        transferRequestCard.setChannel("W");
        transferRequestCard.setUCAFSupport(false);
        transferRequestCard.setICA("009674");
        transferRequestCard.setProcessorId(9000000442L);
        transferRequestCard.setRoutingAndTransitNumber(990442082);
        transferRequestCard.getCardAcceptor().setName("My Local Bank");
        transferRequestCard.getCardAcceptor().setCity("Saint Louis");
        transferRequestCard.getCardAcceptor().setState("MO");
        transferRequestCard.getCardAcceptor().setPostalCode(63101);
        transferRequestCard.getCardAcceptor().setCountry("USA");
        transferRequestCard.setTransactionDesc("P2P");
        transferRequestCard.setMerchantId(123456);
        Transfer transfer = service.getTransfer(transferRequestCard);
        assertTrue(transfer != null);
        assertTrue(transfer.getTransactionReference() > 0);
        assertTrue(transfer.getTransactionHistory().getTransaction() != null);
        assertTrue(transfer.getTransactionHistory().getTransaction().get(0).getResponse().getCode() == 00);
        assertTrue(transfer.getTransactionHistory().getTransaction().get(1).getResponse().getCode() == 00);
        assertTrue(testUtils.validateXML(transfer, "Transfer.xsd"));
    }

    public void testTransferRequestMappedTest() {
        transferRequestMapped = factory.createTransferRequest();
        transferRequestMapped.setLocalDate("1212");
        transferRequestMapped.setLocalTime("161222");
        transferRequestMapped.setTransactionReference(4000000012010101024L);
        transferRequestMapped.getFundingMapped().setSubscriberId("example@email.com");
        transferRequestMapped.getFundingMapped().setSubscriberType("EMAIL_ADDRESS");
        transferRequestMapped.getFundingMapped().setSubscriberAlias("My Debit Card");
        transferRequestMapped.setFundingUCAF("MjBjaGFyYWN0ZXJqdW5rVUNBRjU=1111");
        transferRequestMapped.setFundingMasterCardAssignedId(123456);
        transferRequestMapped.getFundingAmount().setValue(15000);
        transferRequestMapped.getFundingAmount().setCurrency(840);
        transferRequestMapped.setReceiverName("Jose Lopez");
        transferRequestMapped.getReceiverAddress().setLine1("Pueblo Street");
        transferRequestMapped.getReceiverAddress().setLine2("PO BOX 12");
        transferRequestMapped.getReceiverAddress().setCity("El PASO");
        transferRequestMapped.getReceiverAddress().setCountrySubdivision("TX");
        transferRequestMapped.getReceiverAddress().setPostalCode(79906);
        transferRequestMapped.getReceiverAddress().setCountry("USA");
        transferRequestMapped.setReceiverPhone(1800639426);
        transferRequestMapped.getReceivingCard().setAccountNumber(5184680430000014L);
        transferRequestMapped.getReceivingAmount().setValue(182206);
        transferRequestMapped.getReceivingAmount().setCurrency(484);
        transferRequestMapped.setChannel("W");
        transferRequestMapped.setUCAFSupport(false);
        transferRequestMapped.setICA("009674");
        transferRequestMapped.setProcessorId(9000000442L);
        transferRequestMapped.setRoutingAndTransitNumber(990442082);
        transferRequestMapped.getCardAcceptor().setName("My Local Bank");
        transferRequestMapped.getCardAcceptor().setCity("Saint Louis");
        transferRequestMapped.getCardAcceptor().setState("MO");
        transferRequestMapped.getCardAcceptor().setPostalCode(63101);
        transferRequestMapped.getCardAcceptor().setCountry("USA");
        transferRequestMapped.setTransactionDesc("P2P");
        transferRequestMapped.setMerchantId(123456);
        Transfer transfer = service.getTransfer(transferRequestMapped);
        assertTrue(transfer != null);
        assertTrue(transfer.getTransactionReference() > 0);
        assertTrue(transfer.getTransactionHistory().getTransaction() != null);
        assertTrue(transfer.getTransactionHistory().getTransaction().get(0).getResponse().getCode() == 00);
        assertTrue(transfer.getTransactionHistory().getTransaction().get(1).getResponse().getCode() == 00);
        assertTrue(testUtils.validateXML(transfer, "Transfer.xsd"));
    }

    public void testPaymentRequestCardTest() {
        paymentRequestCard = factory.createPaymentRequest();
        paymentRequestCard.setLocalDate("1226");
        paymentRequestCard.setLocalTime("125334");
        paymentRequestCard.setTransactionReference(4000000002010101020L);
        paymentRequestCard.setSenderName("John Doe");
        paymentRequestCard.getSenderAddress().setLine1("123 Main Street");
        paymentRequestCard.getSenderAddress().setLine2("#5A");
        paymentRequestCard.getSenderAddress().setCity("Arlington");
        paymentRequestCard.getSenderAddress().setCountrySubdivision("VA");
        paymentRequestCard.getSenderAddress().setPostalCode(22207);
        paymentRequestCard.getSenderAddress().setCountry("USA");
        paymentRequestCard.getReceivingCard().setAccountNumber(5184680430000014L);
        paymentRequestCard.getReceivingAmount().setValue(182206);
        paymentRequestCard.getReceivingAmount().setCurrency(484);
        paymentRequestCard.setICA("009674");
        paymentRequestCard.setProcessorId(9000000442L);
        paymentRequestCard.setRoutingAndTransitNumber(990442082);
        paymentRequestCard.getCardAcceptor().setName("My Local Bank");
        paymentRequestCard.getCardAcceptor().setCity("Saint Louis");
        paymentRequestCard.getCardAcceptor().setState("MO");
        paymentRequestCard.getCardAcceptor().setPostalCode(63101);
        paymentRequestCard.getCardAcceptor().setCountry("USA");
        paymentRequestCard.setTransactionDesc("P2P");
        paymentRequestCard.setMerchantId(123456);
        Transfer transfer = service.getTransfer(paymentRequestCard);
        assertTrue(transfer != null);
        assertTrue(transfer.getTransactionReference() > 0);
        assertTrue(transfer.getTransactionHistory().getTransaction() != null);
        assertTrue(transfer.getTransactionHistory().getTransaction().get(0).getResponse().getCode() == 00);
        assertTrue(testUtils.validateXML(transfer, "Transfer.xsd"));
    }

    public void testPaymentRequestMappedTest() {
        paymentRequestMapped = factory.createPaymentRequest();
        paymentRequestMapped.setLocalDate("0226");
        paymentRequestMapped.setLocalTime("125334");
        paymentRequestMapped.setTransactionReference(4000000002010105701L);
        paymentRequestMapped.setSenderName("John Doe");
        paymentRequestMapped.getSenderAddress().setLine1("123 Main Street");
        paymentRequestMapped.getSenderAddress().setLine2("#5A");
        paymentRequestMapped.getSenderAddress().setCity("Arlington");
        paymentRequestMapped.getSenderAddress().setCountrySubdivision("VA");
        paymentRequestMapped.getSenderAddress().setPostalCode(22207);
        paymentRequestMapped.getSenderAddress().setCountry("USA");
        paymentRequestMapped.getReceivingMapped().setSubscriberId("example2@email.com");
        paymentRequestMapped.getReceivingMapped().setSubscriberType("EMAIL_ADDRESS");
        paymentRequestMapped.getReceivingMapped().setSubscriberAlias("My Debit Card");
        paymentRequestMapped.getReceivingAmount().setValue(10000);
        paymentRequestMapped.getReceivingAmount().setCurrency(484);
        paymentRequestMapped.setICA("009674");
        paymentRequestMapped.setProcessorId(9000000442L);
        paymentRequestMapped.setRoutingAndTransitNumber(990442082);
        paymentRequestMapped.getCardAcceptor().setName("My Local Bank");
        paymentRequestMapped.getCardAcceptor().setCity("Saint Louis");
        paymentRequestMapped.getCardAcceptor().setState("MO");
        paymentRequestMapped.getCardAcceptor().setPostalCode(63101);
        paymentRequestMapped.getCardAcceptor().setCountry("USA");
        paymentRequestMapped.setTransactionDesc("P2P");
        paymentRequestMapped.setMerchantId(123456);
        Transfer transfer = service.getTransfer(paymentRequestMapped);
        assertTrue(transfer != null);
        assertTrue(transfer.getTransactionReference() > 0);
        assertTrue(transfer.getTransactionHistory().getTransaction() != null);
        assertTrue(transfer.getTransactionHistory().getTransaction().get(0).getResponse().getCode() == 00);
        assertTrue(testUtils.validateXML(transfer, "Transfer.xsd"));
    }

}

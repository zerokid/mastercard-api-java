package com.mastercard.api.fraud.merchantscoring.v1.scorelookup.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.common.apiexception.MCApiRuntimeException;
import com.mastercard.api.fraud.merchantscoring.v1.scorelookup.domain.MatchIndicatorStatus;
import com.mastercard.api.fraud.merchantscoring.v1.scorelookup.domain.ScoreLookup;
import com.mastercard.api.fraud.merchantscoring.v1.scorelookup.domain.ScoreLookupRequest;
import com.mastercard.api.fraud.merchantscoring.v1.scorelookup.domain.factory.ObjectFactory;
import junit.framework.TestCase;
import utils.TestUtils;

public class FraudScoringServiceTest extends TestCase {

    FraudScoringService service;
    TestUtils testUtils = new TestUtils(Environment.SANDBOX);
    ObjectFactory factory = new ObjectFactory();
    ScoreLookupRequest request;

    public void setUp(){
        service = new FraudScoringService(
                Environment.SANDBOX,
                testUtils.getConsumerKey(),
                testUtils.getPrivateKey()
        );

        request = factory.createScoreLookupRequest();
        request.getTransactionDetail().setCustomerIdentifier(1996);
        request.getTransactionDetail().setMerchantIdentifier(123);
        request.getTransactionDetail().setAccountNumber(5555555555555555555L);
        request.getTransactionDetail().setAccountPrefix(555555);
        request.getTransactionDetail().setAccountSuffix(Short.valueOf("5555"));
        request.getTransactionDetail().setTransactionDate(Short.valueOf("1231"));
        request.getTransactionDetail().setTransactionTime("035959");
        request.getTransactionDetail().setBankNetReferenceNumber("abcABC123");
        request.getTransactionDetail().setStan(123456);
    }

    public void testLowFraudScoreSingleTransactionMatch(){
        request.getTransactionDetail().setTransactionAmount(62500L);
        ScoreLookup scoreLookup = service.getScoreLookup(request);
        assertTrue(scoreLookup.getScoreResponse().getMatchIndicator() == MatchIndicatorStatus.SINGLE_TRANSACTION_MATCH);
        assertTrue(testUtils.validateXML(scoreLookup, "scoreLookup.xsd"));
    }

    public void testMidFraudScoreMultipleTransactionMatchesSameCard(){
        request.getTransactionDetail().setTransactionAmount(10001L);
        ScoreLookup scoreLookup = service.getScoreLookup(request);
        assertTrue(scoreLookup.getScoreResponse().getMatchIndicator() == MatchIndicatorStatus.MULTIPLE_TRANS_IDENTICAL_CARD_MATCH);
        assertTrue(testUtils.validateXML(scoreLookup, "scoreLookup.xsd"));
    }

    public void testHighFraudScoreMultipleTransactionMatchesDifferingCards(){
        request.getTransactionDetail().setTransactionAmount(20001L);
        ScoreLookup scoreLookup = service.getScoreLookup(request);
        assertTrue(scoreLookup.getScoreResponse().getMatchIndicator() == MatchIndicatorStatus.MULTIPLE_TRANS_DIFFERING_CARDS_MATCH);
        assertTrue(testUtils.validateXML(scoreLookup, "scoreLookup.xsd"));
    }

    public void testNoMatchFound(){
        request.getTransactionDetail().setTransactionAmount(30001L);
        ScoreLookup scoreLookup = service.getScoreLookup(request);
        assertTrue(scoreLookup.getScoreResponse().getMatchIndicator() == MatchIndicatorStatus.NO_MATCH_FOUND);
        //cannot validate XML, null fields returned when NO_MATCH_FOUND
    }

    public void testSystemError(){
        request.getTransactionDetail().setTransactionAmount(50001L);
        try {
            service.getScoreLookup(request);
            fail();
        } catch (MCApiRuntimeException ex){

        }
    }
}

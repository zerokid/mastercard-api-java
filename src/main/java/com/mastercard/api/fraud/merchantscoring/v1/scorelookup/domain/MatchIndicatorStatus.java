package com.mastercard.api.fraud.merchantscoring.v1.scorelookup.domain;

public class MatchIndicatorStatus {
    public static final int SINGLE_TRANSACTION_MATCH = 1;
    public static final int MULTIPLE_TRANS_IDENTICAL_CARD_MATCH = 2;
    public static final int MULTIPLE_TRANS_DIFFERING_CARDS_MATCH = 3;
    public static final int NO_MATCH_FOUND = 4;
}

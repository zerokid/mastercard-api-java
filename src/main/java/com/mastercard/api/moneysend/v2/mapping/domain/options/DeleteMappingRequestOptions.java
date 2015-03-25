package com.mastercard.api.moneysend.v2.mapping.domain.options;

public class DeleteMappingRequestOptions {

    private Integer cardId;
    private Integer mappingId;

    public Integer getCardId() {
        return cardId;
    }

    public Integer getMappingId() {
        return mappingId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public void setMappingId(Integer mappingId) {
        this.mappingId = mappingId;
    }

}

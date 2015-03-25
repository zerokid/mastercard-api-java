package com.mastercard.api.partnerwallet.services;

import com.mastercard.api.common.Environment;
import com.mastercard.api.partnerwallet.domain.all.RewardProgramOfferingsResponse;
import com.mastercard.api.partnerwallet.domain.switchapi.Merchant;
import com.mastercard.api.partnerwallet.services.common.AbstractPartnerService;

import javax.xml.bind.JAXBElement;

import java.security.PrivateKey;
import java.util.Map;

public class RewardProgramOfferingService extends AbstractPartnerService {
    public RewardProgramOfferingService(Environment environment, String consumerKey, PrivateKey privateKey) {
        super(environment, consumerKey, privateKey);
        this.sandboxUrl = "https://sandbox.api.mastercard.com/masterpass/partner/v6/reward-program-offerings";
        this.productionUrl = "https://api.mastercard.com/masterpass/partner/v6/reward-program-offerings";
        this.mtfUrl = "https://api.mastercard.com/mtf/masterpass/v6/reward-program-offerings";
    }

    public RewardProgramOfferingsResponse getRewardProgramOfferingsResponse() {
        Map<String,String> responseMap = doRequest(
                getUrl(),
                GET,
                null
        );
        String response = responseMap.get(MESSAGE);
        RewardProgramOfferingsResponse rpoResponse = (RewardProgramOfferingsResponse) stringToXml(response, RewardProgramOfferingsResponse.class);
        return rpoResponse;
    }
}

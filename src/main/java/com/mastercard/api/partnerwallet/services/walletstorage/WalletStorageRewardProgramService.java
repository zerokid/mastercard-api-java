package com.mastercard.api.partnerwallet.services.walletstorage;

import java.security.PrivateKey;
import java.util.Map;

import com.mastercard.api.common.Environment;
import com.mastercard.api.partnerwallet.domain.all.RewardProgram;
import com.mastercard.api.partnerwallet.services.common.AbstractPartnerService;

import javax.xml.bind.JAXBElement;

public class WalletStorageRewardProgramService extends AbstractPartnerService {

    String sandboxUpdateUrl;
    String productionUpdateUrl;
    String mtfUpdateUrl;

    public WalletStorageRewardProgramService(Environment environment,
                                             String consumerKey, PrivateKey privateKey) {
        super(environment, consumerKey, privateKey);
        this.environment = environment;
        this.sandboxUrl = "https://sandbox.api.mastercard.com/masterpass/partner/v6/wallet-provider/<wallet_provider_id>/wallet/<wallet_id>/reward-program";
        this.sandboxUpdateUrl = "https://sandbox.api.mastercard.com/masterpass/partner/v6/wallet-provider/<wallet_provider_id>/wallet/<wallet_id>/reward-program/<reward_program_id>";
        this.productionUrl = "https://api.mastercard.com/masterpass/partner/v6/wallet-provider/<wallet_provider_id>/wallet/<wallet_id>/reward-program";
        this.productionUpdateUrl = "https://api.mastercard.com/masterpass/partner/v6/wallet-provider/<wallet_provider_id>/wallet/<wallet_id>/reward-program/<reward_program_id>";
        this.mtfUrl = "https://api.mastercard.com/mtf/masterpass/v6/wallet-provider/<wallet_provider_id>/wallet/<wallet_id>/reward-program";
        this.mtfUpdateUrl = "https://api.mastercard.com/mtf/masterpass/v6/wallet-provider/<wallet_provider_id>/wallet/<wallet_id>/reward-program/<reward_program_id>";
    }

    protected String getUrl(String method, String walletProviderId, String walletId, String rewardProgramId){
        String url;
        switch(environment) {
            case PRODUCTION:
                if (method.equals(POST)){
                    url = this.productionUrl;
                } else {
                    url = this.productionUpdateUrl;
                }
                break;
            case SANDBOX:
                if (method.equals(POST)){
                    url = this.sandboxUrl;
                } else {
                    url = this.sandboxUpdateUrl;
                }
                break;
            case MTF:
                if (method.equals(POST)){
                    url = this.mtfUrl;
                } else {
                    url = this.mtfUpdateUrl;
                }
                break;
            default:
                url = null;
        }
        url = url.replace("<wallet_provider_id>", walletProviderId);
        url = url.replace("<wallet_id>", walletId);
        if ((!method.equals(POST)) && rewardProgramId != null){
            url = url.replace("<reward_program_id>", rewardProgramId);
        }
        return url;
    }

    public RewardProgram readRewardProgam(String walletProviderId, String walletId, String rewardProgramId) {
        Map<String,String> responseMap = doRequest(
                getUrl(GET, walletProviderId, walletId, rewardProgramId),
                GET,
                null
        );
        String response = responseMap.get(MESSAGE);
        JAXBElement<RewardProgram> connectedResponse = (JAXBElement<RewardProgram>) stringToXml(response,  RewardProgram.class);
        return connectedResponse.getValue();
    }

    public String createRewardProgam(String walletProviderId, String walletId, RewardProgram rewardProgram) {
        Map<String,String> responseMap = doRequest(
                getUrl(POST, walletProviderId, walletId, null),
                POST,
                xmlToString(rewardProgram)
        );
        return responseMap.get(MESSAGE);
    }

    public String updateRewardProgam(String walletProviderId, String walletId, String rewardProgramId, RewardProgram rewardProgram) {
        Map<String,String> responseMap = doRequest(
                getUrl(PUT, walletProviderId, walletId, rewardProgramId),
                PUT,
                xmlToString(rewardProgram)
        );
        return responseMap.get(MESSAGE);
    }

    public String deleteRewardProgam(String walletProviderId, String walletId, String rewardProgramId) {
        Map<String,String> responseMap = doRequest(
                getUrl(DELETE, walletProviderId, walletId, rewardProgramId),
                DELETE,
                null
        );
        return responseMap.get(MESSAGE);
    }

}

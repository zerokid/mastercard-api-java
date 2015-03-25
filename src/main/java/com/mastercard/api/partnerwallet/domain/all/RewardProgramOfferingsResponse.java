
package com.mastercard.api.partnerwallet.domain.all;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for rewardProgramOfferingsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rewardProgramOfferingsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RewardProgramOfferings" type="{}RewardProgramOfferings"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rewardProgramOfferingsResponse", propOrder = {
    "rewardProgramOfferings"
})
@XmlRootElement(name="rewardProgramOfferingsResponse")
public class RewardProgramOfferingsResponse {

    @XmlElement(name = "RewardProgramOfferings", required = true)
    protected RewardProgramOfferings rewardProgramOfferings;

    /**
     * Gets the value of the rewardProgramOfferings property.
     * 
     * @return
     *     possible object is
     *     {@link RewardProgramOfferings }
     *     
     */
    public RewardProgramOfferings getRewardProgramOfferings() {
        return rewardProgramOfferings;
    }

    /**
     * Sets the value of the rewardProgramOfferings property.
     * 
     * @param value
     *     allowed object is
     *     {@link RewardProgramOfferings }
     *     
     */
    public void setRewardProgramOfferings(RewardProgramOfferings value) {
        this.rewardProgramOfferings = value;
    }

}

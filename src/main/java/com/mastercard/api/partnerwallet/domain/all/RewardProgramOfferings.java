
package com.mastercard.api.partnerwallet.domain.all;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;


/**
 * <p>Java class for RewardProgramOfferings complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RewardProgramOfferings">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RewardProgramOffering" type="{}RewardProgramOffering" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RewardProgramOfferings", propOrder = {
    "rewardProgramOffering"
})
@XmlRootElement(name="RewardProgramOfferings")
public class RewardProgramOfferings {

    @XmlElement(name = "RewardProgramOffering")
    protected List<RewardProgramOffering> rewardProgramOffering;

    /**
     * Gets the value of the rewardProgramOffering property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rewardProgramOffering property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRewardProgramOffering().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RewardProgramOffering }
     * 
     * 
     */
    public List<RewardProgramOffering> getRewardProgramOffering() {
        if (rewardProgramOffering == null) {
            rewardProgramOffering = new ArrayList<RewardProgramOffering>();
        }
        return this.rewardProgramOffering;
    }

}

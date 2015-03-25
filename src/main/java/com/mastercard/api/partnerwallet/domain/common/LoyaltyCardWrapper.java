
package com.mastercard.api.partnerwallet.domain.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LoyaltyCardWrapper complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoyaltyCardWrapper">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LoyaltyCard" type="{}LoyaltyCard"/>
 *         &lt;element name="ExtensionPoint" type="{}ExtensionPoint" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoyaltyCardWrapper", propOrder = {
    "loyaltyCard",
    "extensionPoint"
})
public class LoyaltyCardWrapper {

    @XmlElement(name = "LoyaltyCard", required = true)
    protected LoyaltyCard loyaltyCard;
    @XmlElement(name = "ExtensionPoint")
    protected ExtensionPoint extensionPoint;

    /**
     * Gets the value of the loyaltyCard property.
     * 
     * @return
     *     possible object is
     *     {@link LoyaltyCard }
     *     
     */
    public LoyaltyCard getLoyaltyCard() {
        return loyaltyCard;
    }

    /**
     * Sets the value of the loyaltyCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoyaltyCard }
     *     
     */
    public void setLoyaltyCard(LoyaltyCard value) {
        this.loyaltyCard = value;
    }

    /**
     * Gets the value of the extensionPoint property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionPoint }
     *     
     */
    public ExtensionPoint getExtensionPoint() {
        return extensionPoint;
    }

    /**
     * Sets the value of the extensionPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionPoint }
     *     
     */
    public void setExtensionPoint(ExtensionPoint value) {
        this.extensionPoint = value;
    }

}

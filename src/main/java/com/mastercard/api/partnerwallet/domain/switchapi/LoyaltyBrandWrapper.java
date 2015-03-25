
package com.mastercard.api.partnerwallet.domain.switchapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LoyaltyBrandWrapper complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoyaltyBrandWrapper">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LoyaltyBrand" type="{}LoyaltyBrand"/>
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
@XmlType(name = "LoyaltyBrandWrapper", propOrder = {
    "loyaltyBrand",
    "extensionPoint"
})
public class LoyaltyBrandWrapper {

    @XmlElement(name = "LoyaltyBrand", required = true)
    protected LoyaltyBrand loyaltyBrand;
    @XmlElement(name = "ExtensionPoint")
    protected ExtensionPoint extensionPoint;

    /**
     * Gets the value of the loyaltyBrand property.
     * 
     * @return
     *     possible object is
     *     {@link LoyaltyBrand }
     *     
     */
    public LoyaltyBrand getLoyaltyBrand() {
        return loyaltyBrand;
    }

    /**
     * Sets the value of the loyaltyBrand property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoyaltyBrand }
     *     
     */
    public void setLoyaltyBrand(LoyaltyBrand value) {
        this.loyaltyBrand = value;
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

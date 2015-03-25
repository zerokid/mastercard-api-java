
package com.mastercard.api.partnerwallet.domain.all;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuthorizedCheckout complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuthorizedCheckout">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Card" type="{}Card"/>
 *         &lt;element name="Contact" type="{}Contact"/>
 *         &lt;element name="ShippingAddress" type="{}ShippingAddress" minOccurs="0"/>
 *         &lt;element name="AuthenticationOptions" type="{}AuthenticationOptions" minOccurs="0"/>
 *         &lt;element name="RewardProgram" type="{}RewardProgram" minOccurs="0"/>
 *         &lt;element name="ExtensionPoint" type="{}AuthorizedCheckoutExtension" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthorizedCheckout", propOrder = {
    "card",
    "contact",
    "shippingAddress",
    "authenticationOptions",
    "rewardProgram",
    "extensionPoint"
})
public class AuthorizedCheckout {

    @XmlElement(name = "Card", required = true)
    protected Card card;
    @XmlElement(name = "Contact", required = true)
    protected Contact contact;
    @XmlElement(name = "ShippingAddress")
    protected ShippingAddress shippingAddress;
    @XmlElement(name = "AuthenticationOptions")
    protected AuthenticationOptions authenticationOptions;
    @XmlElement(name = "RewardProgram")
    protected RewardProgram rewardProgram;
    @XmlElement(name = "ExtensionPoint")
    protected AuthorizedCheckoutExtension extensionPoint;

    /**
     * Gets the value of the card property.
     * 
     * @return
     *     possible object is
     *     {@link Card }
     *     
     */
    public Card getCard() {
        return card;
    }

    /**
     * Sets the value of the card property.
     * 
     * @param value
     *     allowed object is
     *     {@link Card }
     *     
     */
    public void setCard(Card value) {
        this.card = value;
    }

    /**
     * Gets the value of the contact property.
     * 
     * @return
     *     possible object is
     *     {@link Contact }
     *     
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     * 
     * @param value
     *     allowed object is
     *     {@link Contact }
     *     
     */
    public void setContact(Contact value) {
        this.contact = value;
    }

    /**
     * Gets the value of the shippingAddress property.
     * 
     * @return
     *     possible object is
     *     {@link ShippingAddress }
     *     
     */
    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Sets the value of the shippingAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShippingAddress }
     *     
     */
    public void setShippingAddress(ShippingAddress value) {
        this.shippingAddress = value;
    }

    /**
     * Gets the value of the authenticationOptions property.
     * 
     * @return
     *     possible object is
     *     {@link AuthenticationOptions }
     *     
     */
    public AuthenticationOptions getAuthenticationOptions() {
        return authenticationOptions;
    }

    /**
     * Sets the value of the authenticationOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthenticationOptions }
     *     
     */
    public void setAuthenticationOptions(AuthenticationOptions value) {
        this.authenticationOptions = value;
    }

    /**
     * Gets the value of the rewardProgram property.
     * 
     * @return
     *     possible object is
     *     {@link RewardProgram }
     *     
     */
    public RewardProgram getRewardProgram() {
        return rewardProgram;
    }

    /**
     * Sets the value of the rewardProgram property.
     * 
     * @param value
     *     allowed object is
     *     {@link RewardProgram }
     *     
     */
    public void setRewardProgram(RewardProgram value) {
        this.rewardProgram = value;
    }

    /**
     * Gets the value of the extensionPoint property.
     * 
     * @return
     *     possible object is
     *     {@link AuthorizedCheckoutExtension }
     *     
     */
    public AuthorizedCheckoutExtension getExtensionPoint() {
        return extensionPoint;
    }

    /**
     * Sets the value of the extensionPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorizedCheckoutExtension }
     *     
     */
    public void setExtensionPoint(AuthorizedCheckoutExtension value) {
        this.extensionPoint = value;
    }

}


package com.mastercard.api.partnerwallet.domain.switchapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeliveryDestination complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeliveryDestination">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ShippingDestination" type="{}ShippingDestination" minOccurs="0"/>
 *         &lt;element name="EmailDestination" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "DeliveryDestination", propOrder = {
    "shippingDestination",
    "emailDestination",
    "extensionPoint"
})
public class DeliveryDestination {

    @XmlElement(name = "ShippingDestination")
    protected ShippingDestination shippingDestination;
    @XmlElement(name = "EmailDestination")
    protected String emailDestination;
    @XmlElement(name = "ExtensionPoint")
    protected ExtensionPoint extensionPoint;

    /**
     * Gets the value of the shippingDestination property.
     * 
     * @return
     *     possible object is
     *     {@link ShippingDestination }
     *     
     */
    public ShippingDestination getShippingDestination() {
        return shippingDestination;
    }

    /**
     * Sets the value of the shippingDestination property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShippingDestination }
     *     
     */
    public void setShippingDestination(ShippingDestination value) {
        this.shippingDestination = value;
    }

    /**
     * Gets the value of the emailDestination property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailDestination() {
        return emailDestination;
    }

    /**
     * Sets the value of the emailDestination property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailDestination(String value) {
        this.emailDestination = value;
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

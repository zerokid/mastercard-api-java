
package com.mastercard.api.partnerwallet.domain.all;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExpressCheckoutResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExpressCheckoutResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Checkout" type="{}Checkout" minOccurs="0"/>
 *         &lt;element name="LongAccessToken" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Errors" type="{}Errors" minOccurs="0"/>
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
@XmlType(name = "ExpressCheckoutResponse", propOrder = {
    "checkout",
    "longAccessToken",
    "errors",
    "extensionPoint"
})
public class ExpressCheckoutResponse {

    @XmlElement(name = "Checkout")
    protected Checkout checkout;
    @XmlElement(name = "LongAccessToken", required = true)
    protected String longAccessToken;
    @XmlElement(name = "Errors")
    protected Errors errors;
    @XmlElement(name = "ExtensionPoint")
    protected ExtensionPoint extensionPoint;

    /**
     * Gets the value of the checkout property.
     * 
     * @return
     *     possible object is
     *     {@link Checkout }
     *     
     */
    public Checkout getCheckout() {
        return checkout;
    }

    /**
     * Sets the value of the checkout property.
     * 
     * @param value
     *     allowed object is
     *     {@link Checkout }
     *     
     */
    public void setCheckout(Checkout value) {
        this.checkout = value;
    }

    /**
     * Gets the value of the longAccessToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongAccessToken() {
        return longAccessToken;
    }

    /**
     * Sets the value of the longAccessToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongAccessToken(String value) {
        this.longAccessToken = value;
    }

    /**
     * Gets the value of the errors property.
     * 
     * @return
     *     possible object is
     *     {@link Errors }
     *     
     */
    public Errors getErrors() {
        return errors;
    }

    /**
     * Sets the value of the errors property.
     * 
     * @param value
     *     allowed object is
     *     {@link Errors }
     *     
     */
    public void setErrors(Errors value) {
        this.errors = value;
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

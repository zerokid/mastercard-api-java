
package com.mastercard.api.partnerwallet.domain.all;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuthorizeCheckoutResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuthorizeCheckoutResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MerchantCallbackURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="StepupPending" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="OAuthVerifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PreCheckoutTransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "AuthorizeCheckoutResponse", propOrder = {
    "merchantCallbackURL",
    "stepupPending",
    "oAuthVerifier",
    "preCheckoutTransactionId",
    "extensionPoint"
})
@XmlRootElement(name="AuthorizeCheckoutResponse")
public class AuthorizeCheckoutResponse {

    @XmlElement(name = "MerchantCallbackURL", required = true)
    protected String merchantCallbackURL;
    @XmlElement(name = "StepupPending")
    protected boolean stepupPending;
    @XmlElement(name = "OAuthVerifier")
    protected String oAuthVerifier;
    @XmlElement(name = "PreCheckoutTransactionId")
    protected String preCheckoutTransactionId;
    @XmlElement(name = "ExtensionPoint")
    protected ExtensionPoint extensionPoint;

    /**
     * Gets the value of the merchantCallbackURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantCallbackURL() {
        return merchantCallbackURL;
    }

    /**
     * Sets the value of the merchantCallbackURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantCallbackURL(String value) {
        this.merchantCallbackURL = value;
    }

    /**
     * Gets the value of the stepupPending property.
     * 
     */
    public boolean isStepupPending() {
        return stepupPending;
    }

    /**
     * Sets the value of the stepupPending property.
     * 
     */
    public void setStepupPending(boolean value) {
        this.stepupPending = value;
    }

    /**
     * Gets the value of the oAuthVerifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOAuthVerifier() {
        return oAuthVerifier;
    }

    /**
     * Sets the value of the oAuthVerifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOAuthVerifier(String value) {
        this.oAuthVerifier = value;
    }

    /**
     * Gets the value of the preCheckoutTransactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreCheckoutTransactionId() {
        return preCheckoutTransactionId;
    }

    /**
     * Sets the value of the preCheckoutTransactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreCheckoutTransactionId(String value) {
        this.preCheckoutTransactionId = value;
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


package com.mastercard.api.partnerwallet.domain.switchapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MerchantParametersRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MerchantParametersRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MerchantCheckoutIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RequestBasicCheckout" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="OauthToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PreCheckoutTransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OriginUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReturnUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MerchantCallbackUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QueryString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CheckoutVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "MerchantParametersRequest", propOrder = {
    "merchantCheckoutIdentifier",
    "requestBasicCheckout",
    "oauthToken",
    "preCheckoutTransactionId",
    "originUrl",
    "returnUrl",
    "merchantCallbackUrl",
    "queryString",
    "checkoutVersion",
    "extensionPoint"
})
public class MerchantParametersRequest {

    @XmlElement(name = "MerchantCheckoutIdentifier", required = true)
    protected String merchantCheckoutIdentifier;
    @XmlElement(name = "RequestBasicCheckout")
    protected boolean requestBasicCheckout;
    @XmlElement(name = "OauthToken")
    protected String oauthToken;
    @XmlElement(name = "PreCheckoutTransactionId")
    protected String preCheckoutTransactionId;
    @XmlElement(name = "OriginUrl")
    protected String originUrl;
    @XmlElement(name = "ReturnUrl")
    protected String returnUrl;
    @XmlElement(name = "MerchantCallbackUrl")
    protected String merchantCallbackUrl;
    @XmlElement(name = "QueryString")
    protected String queryString;
    @XmlElement(name = "CheckoutVersion")
    protected String checkoutVersion;
    @XmlElement(name = "ExtensionPoint")
    protected ExtensionPoint extensionPoint;

    /**
     * Gets the value of the merchantCheckoutIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantCheckoutIdentifier() {
        return merchantCheckoutIdentifier;
    }

    /**
     * Sets the value of the merchantCheckoutIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantCheckoutIdentifier(String value) {
        this.merchantCheckoutIdentifier = value;
    }

    /**
     * Gets the value of the requestBasicCheckout property.
     * 
     */
    public boolean isRequestBasicCheckout() {
        return requestBasicCheckout;
    }

    /**
     * Sets the value of the requestBasicCheckout property.
     * 
     */
    public void setRequestBasicCheckout(boolean value) {
        this.requestBasicCheckout = value;
    }

    /**
     * Gets the value of the oauthToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOauthToken() {
        return oauthToken;
    }

    /**
     * Sets the value of the oauthToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOauthToken(String value) {
        this.oauthToken = value;
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
     * Gets the value of the originUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginUrl() {
        return originUrl;
    }

    /**
     * Sets the value of the originUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginUrl(String value) {
        this.originUrl = value;
    }

    /**
     * Gets the value of the returnUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnUrl() {
        return returnUrl;
    }

    /**
     * Sets the value of the returnUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnUrl(String value) {
        this.returnUrl = value;
    }

    /**
     * Gets the value of the merchantCallbackUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantCallbackUrl() {
        return merchantCallbackUrl;
    }

    /**
     * Sets the value of the merchantCallbackUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantCallbackUrl(String value) {
        this.merchantCallbackUrl = value;
    }

    /**
     * Gets the value of the queryString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryString() {
        return queryString;
    }

    /**
     * Sets the value of the queryString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryString(String value) {
        this.queryString = value;
    }

    /**
     * Gets the value of the checkoutVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckoutVersion() {
        return checkoutVersion;
    }

    /**
     * Sets the value of the checkoutVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckoutVersion(String value) {
        this.checkoutVersion = value;
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


package com.mastercard.api.partnerwallet.domain.switchapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MerchantParametersResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MerchantParametersResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MerchantParametersId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MerchantCallbackUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReturnUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="QueryString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MerchantSuppressSignUp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "MerchantParametersResponse", propOrder = {
    "merchantParametersId",
    "merchantCallbackUrl",
    "returnUrl",
    "queryString",
    "merchantSuppressSignUp",
    "extensionPoint"
})
public class MerchantParametersResponse {

    @XmlElement(name = "MerchantParametersId", required = true)
    protected String merchantParametersId;
    @XmlElement(name = "MerchantCallbackUrl", required = true)
    protected String merchantCallbackUrl;
    @XmlElement(name = "ReturnUrl", required = true)
    protected String returnUrl;
    @XmlElement(name = "QueryString")
    protected String queryString;
    @XmlElement(name = "MerchantSuppressSignUp")
    protected String merchantSuppressSignUp;
    @XmlElement(name = "ExtensionPoint")
    protected ExtensionPoint extensionPoint;

    /**
     * Gets the value of the merchantParametersId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantParametersId() {
        return merchantParametersId;
    }

    /**
     * Sets the value of the merchantParametersId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantParametersId(String value) {
        this.merchantParametersId = value;
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
     * Gets the value of the merchantSuppressSignUp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantSuppressSignUp() {
        return merchantSuppressSignUp;
    }

    /**
     * Sets the value of the merchantSuppressSignUp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantSuppressSignUp(String value) {
        this.merchantSuppressSignUp = value;
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

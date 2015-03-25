
package com.mastercard.api.partnerwallet.domain.switchapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MerchantParameters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MerchantParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MerchantCallbackUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReturnUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MerchantSuppressSignUp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DSRP" type="{}DSRPExtension" minOccurs="0"/>
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
@XmlType(name = "MerchantParameters", propOrder = {
    "merchantCallbackUrl",
    "returnUrl",
    "merchantSuppressSignUp",
    "dsrp",
    "extensionPoint"
})
public class MerchantParameters {

    @XmlElement(name = "MerchantCallbackUrl", required = true)
    protected String merchantCallbackUrl;
    @XmlElement(name = "ReturnUrl", required = true)
    protected String returnUrl;
    @XmlElement(name = "MerchantSuppressSignUp")
    protected String merchantSuppressSignUp;
    @XmlElement(name = "DSRP")
    protected DSRPExtension dsrp;
    @XmlElement(name = "ExtensionPoint")
    protected ExtensionPoint extensionPoint;

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
     * Gets the value of the dsrp property.
     * 
     * @return
     *     possible object is
     *     {@link DSRPExtension }
     *     
     */
    public DSRPExtension getDSRP() {
        return dsrp;
    }

    /**
     * Sets the value of the dsrp property.
     * 
     * @param value
     *     allowed object is
     *     {@link DSRPExtension }
     *     
     */
    public void setDSRP(DSRPExtension value) {
        this.dsrp = value;
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

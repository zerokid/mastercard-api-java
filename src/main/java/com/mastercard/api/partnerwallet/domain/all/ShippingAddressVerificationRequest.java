
package com.mastercard.api.partnerwallet.domain.all;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for ShippingAddressVerificationRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ShippingAddressVerificationRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OAuthToken" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="VerifiableAddresses" type="{}VerifiableAddresses"/>
 *         &lt;element name="ShippingLocationProfileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "ShippingAddressVerificationRequest", propOrder = {
    "oAuthToken",
    "verifiableAddresses",
    "shippingLocationProfileName",
    "extensionPoint"
})
@XmlRootElement(name = "ShippingAddressVerificationRequest")
public class ShippingAddressVerificationRequest {

    @XmlElement(name = "OAuthToken", required = true)
    protected String oAuthToken;
    @XmlElement(name = "VerifiableAddresses", required = true)
    protected VerifiableAddresses verifiableAddresses;
    @XmlElement(name = "ShippingLocationProfileName")
    protected String shippingLocationProfileName;
    @XmlElement(name = "ExtensionPoint")
    protected ExtensionPoint extensionPoint;

    /**
     * Gets the value of the oAuthToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOAuthToken() {
        return oAuthToken;
    }

    /**
     * Sets the value of the oAuthToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOAuthToken(String value) {
        this.oAuthToken = value;
    }

    /**
     * Gets the value of the verifiableAddresses property.
     * 
     * @return
     *     possible object is
     *     {@link VerifiableAddresses }
     *     
     */
    public VerifiableAddresses getVerifiableAddresses() {
        return verifiableAddresses;
    }

    /**
     * Sets the value of the verifiableAddresses property.
     * 
     * @param value
     *     allowed object is
     *     {@link VerifiableAddresses }
     *     
     */
    public void setVerifiableAddresses(VerifiableAddresses value) {
        this.verifiableAddresses = value;
    }

    /**
     * Gets the value of the shippingLocationProfileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShippingLocationProfileName() {
        return shippingLocationProfileName;
    }

    /**
     * Sets the value of the shippingLocationProfileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShippingLocationProfileName(String value) {
        this.shippingLocationProfileName = value;
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

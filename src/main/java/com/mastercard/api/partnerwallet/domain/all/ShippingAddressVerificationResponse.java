
package com.mastercard.api.partnerwallet.domain.all;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for ShippingAddressVerificationResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ShippingAddressVerificationResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OAuthToken" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="VerificationResults" type="{}VerificationResults"/>
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
@XmlType(name = "ShippingAddressVerificationResponse", propOrder = {
    "oAuthToken",
    "verificationResults",
    "extensionPoint"
})
@XmlRootElement(name = "ShippingAddressVerificationResponse")
public class ShippingAddressVerificationResponse {

    @XmlElement(name = "OAuthToken", required = true)
    protected String oAuthToken;
    @XmlElement(name = "VerificationResults", required = true)
    protected VerificationResults verificationResults;
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
     * Gets the value of the verificationResults property.
     * 
     * @return
     *     possible object is
     *     {@link VerificationResults }
     *     
     */
    public VerificationResults getVerificationResults() {
        return verificationResults;
    }

    /**
     * Sets the value of the verificationResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link VerificationResults }
     *     
     */
    public void setVerificationResults(VerificationResults value) {
        this.verificationResults = value;
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

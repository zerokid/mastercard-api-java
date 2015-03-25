
package com.mastercard.api.partnerwallet.domain.all;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PrecheckoutDataResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrecheckoutDataResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PrecheckoutData" type="{}PrecheckoutData"/>
 *         &lt;element name="WalletPartnerLogoUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="MasterpassLogoUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="LongAccessToken" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "PrecheckoutDataResponse", propOrder = {
    "precheckoutData",
    "walletPartnerLogoUrl",
    "masterpassLogoUrl",
    "longAccessToken",
    "extensionPoint"
})
public class PrecheckoutDataResponse {

    @XmlElement(name = "PrecheckoutData", required = true)
    protected PrecheckoutData precheckoutData;
    @XmlElement(name = "WalletPartnerLogoUrl", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String walletPartnerLogoUrl;
    @XmlElement(name = "MasterpassLogoUrl", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String masterpassLogoUrl;
    @XmlElement(name = "LongAccessToken", required = true)
    protected String longAccessToken;
    @XmlElement(name = "ExtensionPoint")
    protected ExtensionPoint extensionPoint;

    /**
     * Gets the value of the precheckoutData property.
     * 
     * @return
     *     possible object is
     *     {@link PrecheckoutData }
     *     
     */
    public PrecheckoutData getPrecheckoutData() {
        return precheckoutData;
    }

    /**
     * Sets the value of the precheckoutData property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrecheckoutData }
     *     
     */
    public void setPrecheckoutData(PrecheckoutData value) {
        this.precheckoutData = value;
    }

    /**
     * Gets the value of the walletPartnerLogoUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWalletPartnerLogoUrl() {
        return walletPartnerLogoUrl;
    }

    /**
     * Sets the value of the walletPartnerLogoUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWalletPartnerLogoUrl(String value) {
        this.walletPartnerLogoUrl = value;
    }

    /**
     * Gets the value of the masterpassLogoUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterpassLogoUrl() {
        return masterpassLogoUrl;
    }

    /**
     * Sets the value of the masterpassLogoUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterpassLogoUrl(String value) {
        this.masterpassLogoUrl = value;
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

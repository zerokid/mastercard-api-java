
package com.mastercard.api.partnerwallet.domain.switchapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MerchantPermissionResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MerchantPermissionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConnectPermitted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ExpressCheckoutPermitted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="PairingDataTypes" type="{}PairingDataTypes"/>
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
@XmlType(name = "MerchantPermissionResponse", propOrder = {
    "connectPermitted",
    "expressCheckoutPermitted",
    "pairingDataTypes",
    "extensionPoint"
})
public class MerchantPermissionResponse {

    @XmlElement(name = "ConnectPermitted")
    protected boolean connectPermitted;
    @XmlElement(name = "ExpressCheckoutPermitted")
    protected boolean expressCheckoutPermitted;
    @XmlElement(name = "PairingDataTypes", required = true)
    protected PairingDataTypes pairingDataTypes;
    @XmlElement(name = "ExtensionPoint")
    protected ExtensionPoint extensionPoint;

    /**
     * Gets the value of the connectPermitted property.
     * 
     */
    public boolean isConnectPermitted() {
        return connectPermitted;
    }

    /**
     * Sets the value of the connectPermitted property.
     * 
     */
    public void setConnectPermitted(boolean value) {
        this.connectPermitted = value;
    }

    /**
     * Gets the value of the expressCheckoutPermitted property.
     * 
     */
    public boolean isExpressCheckoutPermitted() {
        return expressCheckoutPermitted;
    }

    /**
     * Sets the value of the expressCheckoutPermitted property.
     * 
     */
    public void setExpressCheckoutPermitted(boolean value) {
        this.expressCheckoutPermitted = value;
    }

    /**
     * Gets the value of the pairingDataTypes property.
     * 
     * @return
     *     possible object is
     *     {@link PairingDataTypes }
     *     
     */
    public PairingDataTypes getPairingDataTypes() {
        return pairingDataTypes;
    }

    /**
     * Sets the value of the pairingDataTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link PairingDataTypes }
     *     
     */
    public void setPairingDataTypes(PairingDataTypes value) {
        this.pairingDataTypes = value;
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

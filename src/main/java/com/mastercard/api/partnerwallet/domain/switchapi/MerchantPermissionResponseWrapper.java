
package com.mastercard.api.partnerwallet.domain.switchapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MerchantPermissionResponseWrapper complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MerchantPermissionResponseWrapper">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MerchantPermissionResponse" type="{}MerchantPermissionResponse"/>
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
@XmlType(name = "MerchantPermissionResponseWrapper", propOrder = {
    "merchantPermissionResponse",
    "extensionPoint"
})
public class MerchantPermissionResponseWrapper {

    @XmlElement(name = "MerchantPermissionResponse", required = true)
    protected MerchantPermissionResponse merchantPermissionResponse;
    @XmlElement(name = "ExtensionPoint")
    protected ExtensionPoint extensionPoint;

    /**
     * Gets the value of the merchantPermissionResponse property.
     * 
     * @return
     *     possible object is
     *     {@link MerchantPermissionResponse }
     *     
     */
    public MerchantPermissionResponse getMerchantPermissionResponse() {
        return merchantPermissionResponse;
    }

    /**
     * Sets the value of the merchantPermissionResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link MerchantPermissionResponse }
     *     
     */
    public void setMerchantPermissionResponse(MerchantPermissionResponse value) {
        this.merchantPermissionResponse = value;
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


package com.mastercard.api.partnerwallet.domain.switchapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ValidateSecurityChallengeWrapper complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ValidateSecurityChallengeWrapper">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ValidateSecurityChallenge" type="{}ValidateSecurityChallenge"/>
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
@XmlType(name = "ValidateSecurityChallengeWrapper", propOrder = {
    "validateSecurityChallenge",
    "extensionPoint"
})
public class ValidateSecurityChallengeWrapper {

    @XmlElement(name = "ValidateSecurityChallenge", required = true)
    protected ValidateSecurityChallenge validateSecurityChallenge;
    @XmlElement(name = "ExtensionPoint")
    protected ExtensionPoint extensionPoint;

    /**
     * Gets the value of the validateSecurityChallenge property.
     * 
     * @return
     *     possible object is
     *     {@link ValidateSecurityChallenge }
     *     
     */
    public ValidateSecurityChallenge getValidateSecurityChallenge() {
        return validateSecurityChallenge;
    }

    /**
     * Sets the value of the validateSecurityChallenge property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidateSecurityChallenge }
     *     
     */
    public void setValidateSecurityChallenge(ValidateSecurityChallenge value) {
        this.validateSecurityChallenge = value;
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

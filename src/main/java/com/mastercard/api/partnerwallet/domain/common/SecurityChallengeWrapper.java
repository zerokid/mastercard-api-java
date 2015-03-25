
package com.mastercard.api.partnerwallet.domain.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SecurityChallengeWrapper complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SecurityChallengeWrapper">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SecurityChallenge" type="{}SecurityChallenge"/>
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
@XmlType(name = "SecurityChallengeWrapper", propOrder = {
    "securityChallenge",
    "extensionPoint"
})
public class SecurityChallengeWrapper {

    @XmlElement(name = "SecurityChallenge", required = true)
    protected SecurityChallenge securityChallenge;
    @XmlElement(name = "ExtensionPoint")
    protected ExtensionPoint extensionPoint;

    /**
     * Gets the value of the securityChallenge property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityChallenge }
     *     
     */
    public SecurityChallenge getSecurityChallenge() {
        return securityChallenge;
    }

    /**
     * Sets the value of the securityChallenge property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityChallenge }
     *     
     */
    public void setSecurityChallenge(SecurityChallenge value) {
        this.securityChallenge = value;
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


package com.mastercard.api.partnerwallet.domain.all;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuthorizedCheckoutExtension complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuthorizedCheckoutExtension">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CardVerificationStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LoginAuthenticationMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DSRP" type="{}DSRP" minOccurs="0"/>
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
@XmlType(name = "AuthorizedCheckoutExtension", propOrder = {
    "cardVerificationStatus",
    "loginAuthenticationMethod",
    "dsrp",
    "extensionPoint"
})
public class AuthorizedCheckoutExtension {

    @XmlElement(name = "CardVerificationStatus")
    protected String cardVerificationStatus;
    @XmlElement(name = "LoginAuthenticationMethod")
    protected String loginAuthenticationMethod;
    @XmlElement(name = "DSRP")
    protected DSRP dsrp;
    @XmlElement(name = "ExtensionPoint")
    protected ExtensionPoint extensionPoint;

    /**
     * Gets the value of the cardVerificationStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardVerificationStatus() {
        return cardVerificationStatus;
    }

    /**
     * Sets the value of the cardVerificationStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardVerificationStatus(String value) {
        this.cardVerificationStatus = value;
    }

    /**
     * Gets the value of the loginAuthenticationMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginAuthenticationMethod() {
        return loginAuthenticationMethod;
    }

    /**
     * Sets the value of the loginAuthenticationMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginAuthenticationMethod(String value) {
        this.loginAuthenticationMethod = value;
    }

    /**
     * Gets the value of the dsrp property.
     * 
     * @return
     *     possible object is
     *     {@link DSRP }
     *     
     */
    public DSRP getDSRP() {
        return dsrp;
    }

    /**
     * Sets the value of the dsrp property.
     * 
     * @param value
     *     allowed object is
     *     {@link DSRP }
     *     
     */
    public void setDSRP(DSRP value) {
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

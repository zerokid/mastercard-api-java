
package com.mastercard.api.partnerwallet.domain.all;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CheckoutExtension complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CheckoutExtension">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CardVerificationStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LoginAuthenticationMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RiskDecisioning" type="{}RiskDecisioning" minOccurs="0"/>
 *         &lt;element name="DSRP" type="{}CheckoutDSRP"/>
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
@XmlType(name = "CheckoutExtension", propOrder = {
    "cardVerificationStatus",
    "loginAuthenticationMethod",
    "riskDecisioning",
    "dsrp",
    "extensionPoint"
})
public class CheckoutExtension {

    @XmlElement(name = "CardVerificationStatus")
    protected String cardVerificationStatus;
    @XmlElement(name = "LoginAuthenticationMethod")
    protected String loginAuthenticationMethod;
    @XmlElement(name = "RiskDecisioning")
    protected RiskDecisioning riskDecisioning;
    @XmlElement(name = "DSRP", required = true)
    protected CheckoutDSRP dsrp;
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
     * Gets the value of the riskDecisioning property.
     * 
     * @return
     *     possible object is
     *     {@link RiskDecisioning }
     *     
     */
    public RiskDecisioning getRiskDecisioning() {
        return riskDecisioning;
    }

    /**
     * Sets the value of the riskDecisioning property.
     * 
     * @param value
     *     allowed object is
     *     {@link RiskDecisioning }
     *     
     */
    public void setRiskDecisioning(RiskDecisioning value) {
        this.riskDecisioning = value;
    }

    /**
     * Gets the value of the dsrp property.
     * 
     * @return
     *     possible object is
     *     {@link CheckoutDSRP }
     *     
     */
    public CheckoutDSRP getDSRP() {
        return dsrp;
    }

    /**
     * Sets the value of the dsrp property.
     * 
     * @param value
     *     allowed object is
     *     {@link CheckoutDSRP }
     *     
     */
    public void setDSRP(CheckoutDSRP value) {
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

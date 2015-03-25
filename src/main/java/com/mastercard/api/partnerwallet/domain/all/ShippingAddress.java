
package com.mastercard.api.partnerwallet.domain.all;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ShippingAddress complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ShippingAddress">
 *   &lt;complexContent>
 *     &lt;extension base="{}Address">
 *       &lt;sequence>
 *         &lt;element name="RecipientName" type="{}NonEmptyString"/>
 *         &lt;element name="RecipientPhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShippingAddress", propOrder = {
    "recipientName",
    "recipientPhoneNumber"
})
public class ShippingAddress
    extends Address
{

    @XmlElement(name = "RecipientName", required = true)
    protected String recipientName;
    @XmlElement(name = "RecipientPhoneNumber", required = true)
    protected String recipientPhoneNumber;

    /**
     * Gets the value of the recipientName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipientName() {
        return recipientName;
    }

    /**
     * Sets the value of the recipientName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipientName(String value) {
        this.recipientName = value;
    }

    /**
     * Gets the value of the recipientPhoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipientPhoneNumber() {
        return recipientPhoneNumber;
    }

    /**
     * Sets the value of the recipientPhoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipientPhoneNumber(String value) {
        this.recipientPhoneNumber = value;
    }

}

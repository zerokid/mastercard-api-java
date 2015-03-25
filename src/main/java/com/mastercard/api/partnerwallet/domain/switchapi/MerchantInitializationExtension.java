
package com.mastercard.api.partnerwallet.domain.switchapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MerchantInitializationExtension complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MerchantInitializationExtension">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DSRP" type="{}DSRPExtension"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MerchantInitializationExtension", propOrder = {
    "dsrp"
})
public class MerchantInitializationExtension {

    @XmlElement(name = "DSRP", required = true)
    protected DSRPExtension dsrp;

    /**
     * Gets the value of the dsrp property.
     * 
     * @return
     *     possible object is
     *     {@link DSRPExtension }
     *     
     */
    public DSRPExtension getDSRP() {
        return dsrp;
    }

    /**
     * Sets the value of the dsrp property.
     * 
     * @param value
     *     allowed object is
     *     {@link DSRPExtension }
     *     
     */
    public void setDSRP(DSRPExtension value) {
        this.dsrp = value;
    }

}

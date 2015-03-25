
package com.mastercard.api.partnerwallet.domain.all;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DSRP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DSRP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DSRPData" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DSRPDataType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UnpredictableNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "DSRP", propOrder = {
    "dsrpData",
    "dsrpDataType",
    "unpredictableNumber",
    "extensionPoint"
})
@XmlSeeAlso({
    CheckoutDSRP.class
})
public class DSRP {

    @XmlElement(name = "DSRPData", required = true)
    protected String dsrpData;
    @XmlElement(name = "DSRPDataType", required = true)
    protected String dsrpDataType;
    @XmlElement(name = "UnpredictableNumber")
    protected String unpredictableNumber;
    @XmlElement(name = "ExtensionPoint")
    protected ExtensionPoint extensionPoint;

    /**
     * Gets the value of the dsrpData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDSRPData() {
        return dsrpData;
    }

    /**
     * Sets the value of the dsrpData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDSRPData(String value) {
        this.dsrpData = value;
    }

    /**
     * Gets the value of the dsrpDataType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDSRPDataType() {
        return dsrpDataType;
    }

    /**
     * Sets the value of the dsrpDataType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDSRPDataType(String value) {
        this.dsrpDataType = value;
    }

    /**
     * Gets the value of the unpredictableNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnpredictableNumber() {
        return unpredictableNumber;
    }

    /**
     * Sets the value of the unpredictableNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnpredictableNumber(String value) {
        this.unpredictableNumber = value;
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

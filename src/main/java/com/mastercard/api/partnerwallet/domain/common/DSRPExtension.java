
package com.mastercard.api.partnerwallet.domain.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DSRPExtension complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DSRPExtension">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DSRPOptions" type="{}DSRPOptions"/>
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
@XmlType(name = "DSRPExtension", propOrder = {
    "dsrpOptions",
    "unpredictableNumber",
    "extensionPoint"
})
public class DSRPExtension {

    @XmlElement(name = "DSRPOptions", required = true)
    protected DSRPOptions dsrpOptions;
    @XmlElement(name = "UnpredictableNumber")
    protected String unpredictableNumber;
    @XmlElement(name = "ExtensionPoint")
    protected ExtensionPoint extensionPoint;

    /**
     * Gets the value of the dsrpOptions property.
     * 
     * @return
     *     possible object is
     *     {@link DSRPOptions }
     *     
     */
    public DSRPOptions getDSRPOptions() {
        return dsrpOptions;
    }

    /**
     * Sets the value of the dsrpOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link DSRPOptions }
     *     
     */
    public void setDSRPOptions(DSRPOptions value) {
        this.dsrpOptions = value;
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

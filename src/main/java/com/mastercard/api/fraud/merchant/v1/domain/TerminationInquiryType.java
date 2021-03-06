//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-548 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.11.18 at 10:47:12 AM CST 
//


package com.mastercard.api.fraud.merchant.v1.domain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for termination-inquiry_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="termination-inquiry_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PageOffset" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="TotalLength" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="Ref" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TransactionReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TerminatedMerchant" type="{http://mastercard.com/termination}terminated-merchant_Type" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "termination-inquiry_Type", propOrder = {
    "pageOffset",
    "totalLength",
    "ref",
    "transactionReferenceNumber",
    "terminatedMerchant"
})
@XmlRootElement(name = "TerminationInquiryType")
public class TerminationInquiryType {

    @XmlElement(name = "PageOffset", required = true)
    protected BigInteger pageOffset;
    @XmlElement(name = "TotalLength", required = true)
    protected BigInteger totalLength;
    @XmlElement(name = "Ref", required = true)
    protected String ref;
    @XmlElement(name = "TransactionReferenceNumber")
    protected String transactionReferenceNumber;
    @XmlElement(name = "TerminatedMerchant", required = true)
    protected List<TerminatedMerchantType> terminatedMerchant;

    /**
     * Gets the value of the pageOffset property.
     * 
     * @return
     *     possible object is
     *     {@link java.math.BigInteger }
     *     
     */
    public BigInteger getPageOffset() {
        return pageOffset;
    }

    /**
     * Sets the value of the pageOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.math.BigInteger }
     *     
     */
    public void setPageOffset(BigInteger value) {
        this.pageOffset = value;
    }

    /**
     * Gets the value of the totalLength property.
     * 
     * @return
     *     possible object is
     *     {@link java.math.BigInteger }
     *     
     */
    public BigInteger getTotalLength() {
        return totalLength;
    }

    /**
     * Sets the value of the totalLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.math.BigInteger }
     *     
     */
    public void setTotalLength(BigInteger value) {
        this.totalLength = value;
    }

    /**
     * Gets the value of the ref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRef() {
        return ref;
    }

    /**
     * Sets the value of the ref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRef(String value) {
        this.ref = value;
    }

    /**
     * Gets the value of the transactionReferenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionReferenceNumber() {
        return transactionReferenceNumber;
    }

    /**
     * Sets the value of the transactionReferenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionReferenceNumber(String value) {
        this.transactionReferenceNumber = value;
    }

    /**
     * Gets the value of the terminatedMerchant property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the terminatedMerchant property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTerminatedMerchant().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TerminatedMerchantType }
     * 
     * 
     */
    public List<TerminatedMerchantType> getTerminatedMerchant() {
        if (terminatedMerchant == null) {
            terminatedMerchant = new ArrayList<TerminatedMerchantType>();
        }
        return this.terminatedMerchant;
    }

}

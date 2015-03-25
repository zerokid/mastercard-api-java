
package com.mastercard.api.partnerwallet.domain.all;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RewardProgram complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RewardProgram">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RewardNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RewardId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RewardName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExpiryMonth" type="{}Month" minOccurs="0"/>
 *         &lt;element name="ExpiryYear" type="{}Year" minOccurs="0"/>
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
@XmlType(name = "RewardProgram", propOrder = {
    "id",
    "programId",
    "number",
    "expiryMonth",
    "expiryYear"
    
})
@XmlRootElement(name="RewardProgram")
public class RewardProgram {

    @XmlElement(name = "ID")
    protected String id;
    @XmlElement(name = "ProgramID")
    protected String programId;
    @XmlElement(name = "Number")
    protected String number;
    @XmlElement(name = "ExpiryMonth")
    protected String expiryMonth;
    @XmlElement(name = "ExpiryYear")
    protected String expiryYear;
	protected String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProgramId() {
		return programId;
	}
	public void setProgramId(String programId) {
		this.programId = programId;
	}
	public String getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public String getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}
    
}

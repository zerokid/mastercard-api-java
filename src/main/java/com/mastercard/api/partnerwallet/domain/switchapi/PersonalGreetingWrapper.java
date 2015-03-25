
package com.mastercard.api.partnerwallet.domain.switchapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonalGreetingWrapper complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonalGreetingWrapper">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PersonalGreeting" type="{}PersonalGreeting"/>
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
@XmlType(name = "PersonalGreetingWrapper", propOrder = {
    "personalGreeting",
    "extensionPoint"
})
public class PersonalGreetingWrapper {

    @XmlElement(name = "PersonalGreeting", required = true)
    protected PersonalGreeting personalGreeting;
    @XmlElement(name = "ExtensionPoint")
    protected ExtensionPoint extensionPoint;

    /**
     * Gets the value of the personalGreeting property.
     * 
     * @return
     *     possible object is
     *     {@link PersonalGreeting }
     *     
     */
    public PersonalGreeting getPersonalGreeting() {
        return personalGreeting;
    }

    /**
     * Sets the value of the personalGreeting property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonalGreeting }
     *     
     */
    public void setPersonalGreeting(PersonalGreeting value) {
        this.personalGreeting = value;
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

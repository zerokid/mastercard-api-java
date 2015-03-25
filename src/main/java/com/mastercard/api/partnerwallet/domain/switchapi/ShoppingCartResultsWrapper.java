
package com.mastercard.api.partnerwallet.domain.switchapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ShoppingCartResultsWrapper complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ShoppingCartResultsWrapper">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ShoppingCartResults" type="{}ShoppingCartResults"/>
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
@XmlType(name = "ShoppingCartResultsWrapper", propOrder = {
    "shoppingCartResults",
    "extensionPoint"
})
public class ShoppingCartResultsWrapper {

    @XmlElement(name = "ShoppingCartResults", required = true)
    protected ShoppingCartResults shoppingCartResults;
    @XmlElement(name = "ExtensionPoint")
    protected ExtensionPoint extensionPoint;

    /**
     * Gets the value of the shoppingCartResults property.
     * 
     * @return
     *     possible object is
     *     {@link ShoppingCartResults }
     *     
     */
    public ShoppingCartResults getShoppingCartResults() {
        return shoppingCartResults;
    }

    /**
     * Sets the value of the shoppingCartResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShoppingCartResults }
     *     
     */
    public void setShoppingCartResults(ShoppingCartResults value) {
        this.shoppingCartResults = value;
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

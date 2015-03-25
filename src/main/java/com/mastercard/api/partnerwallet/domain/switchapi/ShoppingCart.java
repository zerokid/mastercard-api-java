
package com.mastercard.api.partnerwallet.domain.switchapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ShoppingCart complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ShoppingCart">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CartTotal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OrderNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CurrencyNumCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CartItem" type="{}CartItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ExtensionPoint" type="{}DSRPExtension" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShoppingCart", propOrder = {
    "cartTotal",
    "currencyCode",
    "orderNumber",
    "currencyNumCode",
    "cartItem",
    "extensionPoint"
})
public class ShoppingCart {

    @XmlElement(name = "CartTotal", required = true)
    protected String cartTotal;
    @XmlElement(name = "CurrencyCode", required = true)
    protected String currencyCode;
    @XmlElement(name = "OrderNumber", required = true)
    protected String orderNumber;
    @XmlElement(name = "CurrencyNumCode", required = true)
    protected String currencyNumCode;
    @XmlElement(name = "CartItem")
    protected List<CartItem> cartItem;
    @XmlElement(name = "ExtensionPoint")
    protected DSRPExtension extensionPoint;

    /**
     * Gets the value of the cartTotal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCartTotal() {
        return cartTotal;
    }

    /**
     * Sets the value of the cartTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCartTotal(String value) {
        this.cartTotal = value;
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the orderNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * Sets the value of the orderNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderNumber(String value) {
        this.orderNumber = value;
    }

    /**
     * Gets the value of the currencyNumCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyNumCode() {
        return currencyNumCode;
    }

    /**
     * Sets the value of the currencyNumCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyNumCode(String value) {
        this.currencyNumCode = value;
    }

    /**
     * Gets the value of the cartItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cartItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCartItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CartItem }
     * 
     * 
     */
    public List<CartItem> getCartItem() {
        if (cartItem == null) {
            cartItem = new ArrayList<CartItem>();
        }
        return this.cartItem;
    }

    /**
     * Gets the value of the extensionPoint property.
     * 
     * @return
     *     possible object is
     *     {@link DSRPExtension }
     *     
     */
    public DSRPExtension getExtensionPoint() {
        return extensionPoint;
    }

    /**
     * Sets the value of the extensionPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link DSRPExtension }
     *     
     */
    public void setExtensionPoint(DSRPExtension value) {
        this.extensionPoint = value;
    }

}

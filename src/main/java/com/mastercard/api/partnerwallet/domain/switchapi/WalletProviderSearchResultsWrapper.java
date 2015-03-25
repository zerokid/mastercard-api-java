
package com.mastercard.api.partnerwallet.domain.switchapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WalletProviderSearchResultsWrapper complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WalletProviderSearchResultsWrapper">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WalletProviderSearchResults" type="{}WalletProviderSearchResults"/>
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
@XmlType(name = "WalletProviderSearchResultsWrapper", propOrder = {
    "walletProviderSearchResults",
    "extensionPoint"
})
public class WalletProviderSearchResultsWrapper {

    @XmlElement(name = "WalletProviderSearchResults", required = true)
    protected WalletProviderSearchResults walletProviderSearchResults;
    @XmlElement(name = "ExtensionPoint")
    protected ExtensionPoint extensionPoint;

    /**
     * Gets the value of the walletProviderSearchResults property.
     * 
     * @return
     *     possible object is
     *     {@link WalletProviderSearchResults }
     *     
     */
    public WalletProviderSearchResults getWalletProviderSearchResults() {
        return walletProviderSearchResults;
    }

    /**
     * Sets the value of the walletProviderSearchResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link WalletProviderSearchResults }
     *     
     */
    public void setWalletProviderSearchResults(WalletProviderSearchResults value) {
        this.walletProviderSearchResults = value;
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

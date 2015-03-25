package com.mastercard.api.partnerwallet.services;

import com.mastercard.api.partnerwallet.domain.factory.ObjectFactory;
import com.mastercard.api.partnerwallet.domain.all.AuthenticationOptions;
import com.mastercard.api.partnerwallet.domain.all.DateOfBirth;
import com.mastercard.api.partnerwallet.domain.all.Address;
import com.mastercard.api.partnerwallet.domain.all.AuthorizeCheckoutRequest;
import com.mastercard.api.partnerwallet.domain.all.AuthorizedCheckout;
import com.mastercard.api.partnerwallet.domain.all.Card;
import com.mastercard.api.partnerwallet.domain.all.Contact;
import com.mastercard.api.partnerwallet.domain.all.RewardProgram;
import com.mastercard.api.partnerwallet.domain.all.ShippingAddress;
import com.mastercard.api.partnerwallet.domain.all.ShippingAddressVerificationRequest;
import com.mastercard.api.partnerwallet.domain.all.VerifiableAddress;
import com.mastercard.api.partnerwallet.domain.all.VerifiableAddresses;
import com.mastercard.api.partnerwallet.domain.all.Gender;

/**
 * Created by JLR1110 on 11/14/14.
 */
public class MockObjectFactory extends ObjectFactory {

    public MockObjectFactory(){
    	super();
    }
	
	public ShippingAddressVerificationRequest mockShippingAddressVerificationRequest(String oauthToken) {
        ShippingAddressVerificationRequest request = super.createShippingAddressVerificationRequest();
        request.setOAuthToken(oauthToken);
        request.setShippingLocationProfileName("");
        VerifiableAddresses addresses = super.createVerifiableAddresses();
        VerifiableAddress address1 = super.createVerifiableAddress();
        address1.setCountry("US");
        address1.setCountrySubdivision("US-VA");
        addresses.getVerifiableAddress().add(address1);
        VerifiableAddress address2 = super.createVerifiableAddress();
        address2.setCountry("US");
        address2.setCountrySubdivision("US-MD");
        addresses.getVerifiableAddress().add(address2);
        request.setVerifiableAddresses(addresses);
        return request;
    }
    
    public AuthorizeCheckoutRequest mockAuthorizeCheckoutRequest(String oauthToken) {
    	AuthorizeCheckoutRequest request = super.createAuthorizeCheckoutRequest();
    	request.setOAuthToken(oauthToken);
    	request.setPreCheckoutTransactionId("4sj4x12-dxmw0b-hwdt9h7q-1-hwdupih1-1ol");
    	request.setAuthorizedCheckout(super.createAuthorizedCheckout());
    	AuthorizedCheckout authCheckout = request.getAuthorizedCheckout();
    	authCheckout.setCard(mockCard());
    	authCheckout.setContact(mockContact());
    	authCheckout.setRewardProgram(mockRewardProgram());
    	authCheckout.setShippingAddress(mockShippingAddress());
    	authCheckout.setAuthenticationOptions(mockAuthenticationOptions());
    	request.setDeviceType("DESKTOP");
    	request.setMerchantParameterId("parameterID");
    	return request;
    }
    
	public Address mockAddress() {
    	Address address = super.createAddress();
    	address.setCity("St. Louis");
    	address.setCountry("US");
    	address.setCountrySubdivision("US-MO");
    	address.setLine1("ABC 123 Street");
    	address.setPostalCode("63101");
    	return address;
    }

	public ShippingAddress mockShippingAddress() {
    	ShippingAddress address = super.createShippingAddress();
    	address.setCity("St. Louis");
    	address.setCountry("US");
    	address.setCountrySubdivision("US-MO");
    	address.setLine1("ABC 123 Street");
    	address.setLine2("");
    	address.setLine3("");
    	address.setPostalCode("63101");
		address.setRecipientName("Joe Testerson");
		address.setRecipientPhoneNumber("555-837-5609");
		return address;
	}

    public Card mockCard() {
    	Card card = super.createCard();
    	card.setAccountNumber("5292140300200102");
    	card.setBillingAddress(mockAddress());
    	card.setBrandId("master");
    	card.setCardHolderName("Joe Testerson");
    	card.setExpiryMonth(06);
    	card.setExpiryYear(2015);
    	card.setBrandName("Mastercard");
    	return card;
    }
    
    public Contact mockContact() {
    	Contact contact = super.createContact();
    	contact.setCountry("US");
    	DateOfBirth dob = super.createDateOfBirth();
    	dob.setDay(04);
    	dob.setMonth(04);
    	dob.setYear(1979);
    	contact.setDateOfBirth(dob);
    	contact.setEmailAddress("abc@123.com");
    	contact.setFirstName("Joe");
    	contact.setLastName("Testerson");
    	contact.setGender(Gender.M);
    	contact.setMiddleName("Sammy");
    	contact.setPhoneNumber("6345644485");
    	return contact;
    }

    public RewardProgram mockRewardProgram() {
    	RewardProgram reward = super.createRewardProgram();
    	reward.setExpiryMonth("05");
    	reward.setExpiryYear("2016");
    	reward.setProgramId("areward");
    	reward.setNumber("1234567890123456");
    	return reward;
	}
    
    public AuthenticationOptions mockAuthenticationOptions() {
    	AuthenticationOptions authOps = super.createAuthenticationOptions();
    	authOps.setAuthenticateMethod("3ds");
    	authOps.setXid("xid");
    	return authOps;
    }

}

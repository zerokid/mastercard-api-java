package com.mastercard.api.partnerwallet.domain.factory;

import com.mastercard.api.partnerwallet.domain.all.Address;
import com.mastercard.api.partnerwallet.domain.all.AuthenticationOptions;
import com.mastercard.api.partnerwallet.domain.all.AuthorizeCheckoutRequest;
import com.mastercard.api.partnerwallet.domain.all.AuthorizedCheckout;
import com.mastercard.api.partnerwallet.domain.all.Card;
import com.mastercard.api.partnerwallet.domain.all.Contact;
import com.mastercard.api.partnerwallet.domain.all.DateOfBirth;
import com.mastercard.api.partnerwallet.domain.all.RewardProgram;
import com.mastercard.api.partnerwallet.domain.all.ShippingAddress;
import com.mastercard.api.partnerwallet.domain.all.ShippingAddressVerificationRequest;
import com.mastercard.api.partnerwallet.domain.all.VerifiableAddress;
import com.mastercard.api.partnerwallet.domain.all.VerifiableAddresses;

/**
 * Created by JLR1110 on 11/14/14.
 */
public class ObjectFactory {

    /**
     * Create an instance of {@link com.mastercard.api.partnerwallet.domain.all.ShippingAddressVerificationRequest }
     *
     */
    public ShippingAddressVerificationRequest createShippingAddressVerificationRequest() {
        ShippingAddressVerificationRequest request = new ShippingAddressVerificationRequest();
        request.setVerifiableAddresses(createVerifiableAddresses());
        return request;
    }

    /**
     * Create an instance of {@link com.mastercard.api.partnerwallet.domain.all.VerifiableAddress }
     *
     */
    public VerifiableAddress createVerifiableAddress() {
        return new VerifiableAddress();
    }

    /**
     * Create an instance of {@link com.mastercard.api.partnerwallet.domain.all.VerifiableAddresses }
     *
     */
    public VerifiableAddresses createVerifiableAddresses() {
        return new VerifiableAddresses();
    }

	public AuthorizeCheckoutRequest createAuthorizeCheckoutRequest() {
		return new AuthorizeCheckoutRequest();
	}
	
	public AuthorizedCheckout createAuthorizedCheckout() {
		return new AuthorizedCheckout();
	}

	public Card createCard() {
		return new Card();
	}

	public Address createAddress() {
		return new Address();
	}

	public Contact createContact() {
		return new Contact();
	}

	public DateOfBirth createDateOfBirth() {
		return new DateOfBirth();
	}

	public RewardProgram createRewardProgram() {
		return new RewardProgram();
	}

	public ShippingAddress createShippingAddress() {
		return new ShippingAddress();
	}

	public AuthenticationOptions createAuthenticationOptions() {
		return new AuthenticationOptions();
	}

}

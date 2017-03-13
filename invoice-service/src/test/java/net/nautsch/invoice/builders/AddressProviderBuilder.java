package net.nautsch.invoice.builders;

import net.nautsch.invoice.Address;
import net.nautsch.invoice.AddressProvider;

/**
 * test data builder.
 */
public class AddressProviderBuilder {

    private Address addressToDeliver;

    AddressProviderBuilder() {
        super();
    }

    public AddressProvider build() {
        return new AddressProviderDummy();
    }

    public AddressProviderBuilder delivering(Address address) {
        this.addressToDeliver = address;
        return this;
    }

    public AddressProviderBuilder delivering(AddressBuilder address) {
        this.delivering(address.build());
        return this;
    }

    private class AddressProviderDummy implements AddressProvider {

        @Override
        public Address getAddress(String addressId) {
            return addressToDeliver;
        }
    }
}

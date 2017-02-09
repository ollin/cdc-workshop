package net.nautsch.invoice;

/**
 * test data builder.
 */
class AddressProviderBuilder {

    private Address addressToDeliver;

    AddressProvider build() {
        return new AddressProviderDummy();
    }

    AddressProviderBuilder delivering(Address address) {
        this.addressToDeliver = address;
        return this;
    }

    AddressProviderBuilder delivering(AddressBuilder address) {
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

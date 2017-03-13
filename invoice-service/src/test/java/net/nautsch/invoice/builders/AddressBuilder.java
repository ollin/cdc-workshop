package net.nautsch.invoice.builders;

import net.nautsch.invoice.Address;

/**
 * test data builder.
 */
public class AddressBuilder {

    private String surname = "surname";
    private String firstname = "firstname";

    AddressBuilder() {
        super();
    }

    public Address build() {
        return new AddressDummy();
    }

    public AddressBuilder withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public AddressBuilder withForename(String firstname) {
        this.firstname = firstname;
        return this;
    }

    private class AddressDummy implements Address {
        @Override
        public String getSurname() {
            return surname;
        }

        public String getFirstName() {
            return firstname;
        }
    }
}

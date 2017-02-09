package net.nautsch.invoice;

/**
 * test data builder.
 */
public class AddressBuilder {

    private String surname = "surname";
    private String firstname = "firstname";

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

        @Override
        public String getFirstname() {
            return firstname;
        }
    }
}

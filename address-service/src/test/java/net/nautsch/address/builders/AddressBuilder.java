package net.nautsch.address.builders;

import net.nautsch.address.Address;

public class AddressBuilder {

    private String id = "1";
    private String surname = "Wloka";
    private String firstName = "Jan";

    public AddressBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public Address build() {
        return new Address(id, surname, firstName);
    }
}

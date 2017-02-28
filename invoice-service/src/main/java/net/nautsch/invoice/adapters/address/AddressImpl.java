package net.nautsch.invoice.adapters.address;

import net.nautsch.invoice.Address;

/**
 * tolerant reader for address data.
 */
class AddressImpl implements Address {

    private String surname;
    private String firstName;

    @Override
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}

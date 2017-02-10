package net.nautsch.invoice.adapters.address;

import net.nautsch.invoice.Address;

/**
 * tolerant reader for address data.
 */
class AddressImpl implements Address {

    private String surname;
    private String forename;

    @Override
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }
}

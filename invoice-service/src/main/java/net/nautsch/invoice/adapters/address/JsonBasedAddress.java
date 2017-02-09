package net.nautsch.invoice.adapters.address;

import net.nautsch.invoice.Address;

/**
 * tolerant reader for address data.
 */
class JsonBasedAddress implements Address {

    @Override
    public String getSurname() {
        return null;
    }

    @Override
    public String getFirstname() {
        return null;
    }
}

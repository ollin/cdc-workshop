package net.nautsch.invoice.adapters.address;

import net.nautsch.invoice.Address;
import net.nautsch.invoice.AddressProvider;

/**
 * calls the address service.
 */
public class AddressServiceAdapter implements AddressProvider {

    @Override
    public Address getAddress(String addressId) {
        // call the backendservice
        return new JsonBasedAddress();
    }
}

package net.nautsch.invoice.adapters.address;

import net.nautsch.invoice.Address;
import net.nautsch.invoice.Recipient;

import java.util.function.Function;

/**
 * implements a converter from address to recipient.
 */
public class AddressToRecipientConverter implements Function<Address, Recipient> {
    @Override
    public Recipient apply(Address address) {
        return new Recipient(address.getFirstName() + " " + address.getSurname());
    }
}

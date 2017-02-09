package net.nautsch.invoice;

/**
 * implementations providing a address.
 */
@FunctionalInterface
public interface AddressProvider {

    Address getAddress(String addressId);

}

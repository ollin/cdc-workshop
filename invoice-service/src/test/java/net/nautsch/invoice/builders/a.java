package net.nautsch.invoice.builders;

/**
 * start point for all test data builders.
 */
public class a {

    public static AddressProviderBuilder addressProvider() {
        return new AddressProviderBuilder();
    }

    public static AddressBuilder address() {
        return new AddressBuilder();
    }
}

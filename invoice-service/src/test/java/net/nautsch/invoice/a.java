package net.nautsch.invoice;

/**
 * start point for all test data builders.
 */
public class a {

    public static AddressProviderBuilder recipientProvider() {
        return new AddressProviderBuilder();
    }

    public static AddressBuilder address() {
        return new AddressBuilder();
    }
}

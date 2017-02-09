package net.nautsch.invoice;

import java.util.function.Function;

/**
 * delivers a recipient.
 */
class RecipientProvider {

    private final AddressProvider addressProvider;
    private final Function<Address, Recipient> converter;

    RecipientProvider(
            AddressProvider addressProvider,
            Function<Address, Recipient> converter
    ) {
        this.addressProvider = addressProvider;
        this.converter = converter;
    }

    Recipient getRecipient(String recipientId) {
        Address address = this.addressProvider.getAddress(recipientId);
        return converter.apply(address);
    }
}

package net.nautsch.invoice;

import net.nautsch.invoice.adapters.address.AddressToRecipientConverter;
import net.nautsch.invoice.builders.a;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * unit test.
 */
public class RecipientProviderTest {

    @Test
    public void shouldDeliverRecipient() {
        // given
        AddressProvider addressProvider =
                a.addressProvider().delivering(a.address()).build();

        RecipientProvider sut = new RecipientProvider(addressProvider, new AddressToRecipientConverter());
        // when
        Recipient result = sut.getRecipient("address-1");
        // then
        assertThat(result, notNullValue());
    }
}
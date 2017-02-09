package net.nautsch.invoice.adapters.address;

import net.nautsch.invoice.Address;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * unit test.
 */
public class AddressServiceAdapterTest {

    @Test
    public void shouldDeliverAnAddress() {
        // given
        AddressServiceAdapter sut = new AddressServiceAdapter();
        // when
        Address result = sut.getAddress("address-1");
        // then
        assertThat(result, notNullValue());
    }

}
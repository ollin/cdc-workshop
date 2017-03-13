package net.nautsch.invoice.adapters.address;

import net.nautsch.invoice.Address;
import net.nautsch.invoice.Recipient;
import net.nautsch.invoice.builders.a;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * unit test.
 */
public class AddressToRecipientConverterTest {

    @Test
    public void shouldConvertForeNameAndSurenameToLine1() {
        // given
        Address givenAddress = a.address().withForename("Jan").withSurname("Wloka").build();
        AddressToRecipientConverter sut = new AddressToRecipientConverter();
        // when
        Recipient result = sut.apply(givenAddress);
        // then
        assertThat(result.getLine1(), is("Jan Wloka"));
    }

}
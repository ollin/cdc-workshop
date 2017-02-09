package net.nautsch.address;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AddressTest {

    @Test
    public void shouldContainSurname() {
        // given
        String givenSurname = "Wloka";
        Address address = new Address(givenSurname, "");
        // when
        String result = address.getSurname();
        // then
        assertThat(result, is(givenSurname));
    }

    @Test
    public void shouldReturnFirstname() {
        // given
        String givenFirstName = "Jan";
        Address address = new Address("", givenFirstName);
        // when
        String result = address.getFirstname();
        // then
        assertThat(result, is(givenFirstName));
        fail("test travis -> gitter.im/ollin/cdc-workshop");

    }

}
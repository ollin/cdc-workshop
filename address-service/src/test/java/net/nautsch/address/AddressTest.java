package net.nautsch.address;

import net.nautsch.address.builders.a;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * unit test.
 */
public class AddressTest {

    @Test
    public void shouldContainSurname() {
        // given
        String givenSurname = "Wloka";
        Address address = new Address("1", givenSurname, "");
        // when
        String result = address.getSurname();
        // then
        assertThat(result, is(givenSurname));
    }

    @Test
    public void shouldReturnFirstname() {
        // given
        String givenFirstName = "Jan";
        Address address = new Address("1","", givenFirstName);
        // when
        String result = address.getFirstName();
        // then
        assertThat(result, is(givenFirstName));
    }

    @Test
    public void shouldContainId() {
        // given
        String givenId = "1";
        Address sut = a.address().withId(givenId).build();
        // when
        String result = sut.getId();
        // then
        assertThat(result, is(givenId));
    }
}

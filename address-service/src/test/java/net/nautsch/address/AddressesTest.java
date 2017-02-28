package net.nautsch.address;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * unit test.
 */
public class AddressesTest {

    @Test
    public void shouldReturnList() throws Exception {
        // given
        Addresses sut = new Addresses();
        // when
        Address[] result = sut.all();
        // then
        assertThat(result, notNullValue());
    }

    @Test
    public void shouldReturnOneAddress() {
        // given
        Addresses sut = new Addresses();
        // when
        Address result = sut.getAddress("1");
        // then
        assertThat(result, notNullValue());
    }
}

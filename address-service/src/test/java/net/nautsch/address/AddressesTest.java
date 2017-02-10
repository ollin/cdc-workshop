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
        Addresses cut = new Addresses();
        // when
        Address[] result = cut.all();
        // then
        assertThat(result, notNullValue());
    }

}

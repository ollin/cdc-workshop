package net.nautsch.invoice;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * unit test.
 */
public class InvoicesTest {

    @Test
    public void shouldReturnList() throws Exception {
        // given
        Invoices cut = new Invoices();
        // when
        Invoice[] result = cut.all();
        // then
        assertThat(result, notNullValue());
    }

}

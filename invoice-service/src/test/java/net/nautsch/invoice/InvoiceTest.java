package net.nautsch.invoice;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InvoiceTest {

    @Test
    public void shouldContainRecipientLine1() {
        // given
        String givenLine1 = "Line 1";
        Recipient givenRecipient = new Recipient(givenLine1);
        Invoice invoice = new Invoice(givenRecipient, null);
        // when
        String result = invoice.getRecipientLine1();
        // then
        assertThat(result, is(givenLine1));
    }
}
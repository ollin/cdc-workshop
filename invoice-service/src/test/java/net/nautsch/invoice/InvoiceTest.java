package net.nautsch.invoice;

import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class InvoiceTest {

    @Test
    public void shouldContainRecipient() {
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
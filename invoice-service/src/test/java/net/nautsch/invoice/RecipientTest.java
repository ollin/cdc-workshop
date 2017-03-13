package net.nautsch.invoice;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * unit test.
 */
public class RecipientTest {

    @Test
    public void shouldContainLine1() {
        // given
        String givenLine1 = "line 1";
        Recipient sut = new Recipient(givenLine1);
        // when
        String result = sut.getLine1();
        // then
        assertThat(result, is(givenLine1));
    }

}
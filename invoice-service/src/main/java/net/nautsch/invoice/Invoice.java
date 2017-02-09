package net.nautsch.invoice;

import java.math.BigDecimal;

public class Invoice {

    private final Recipient recipient;
    private final BigDecimal sum;

    public Invoice(Recipient recipient, BigDecimal sum) {
        this.recipient = recipient;
        this.sum = sum;
    }

    public String getRecipientLine1() {
        return this.recipient.getLine1();
    }
}

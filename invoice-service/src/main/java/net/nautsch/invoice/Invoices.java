package net.nautsch.invoice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

@Controller
@RequestMapping("/invoices")
public class Invoices {

    private final Invoice[] invoices;

    public Invoices() {
        this.invoices = new Invoice[] {
                new Invoice(new Recipient("Jan Wloka"), BigDecimal.ONE)
                , new Invoice(new Recipient("Miko Nieminen"), BigDecimal.ONE)
                , new Invoice(new Recipient("Oliver Nautsch"), BigDecimal.ONE)
        };
    }

    @RequestMapping(method= RequestMethod.GET)
    public @ResponseBody Invoice[] all() {
        return this.invoices;
    }
}

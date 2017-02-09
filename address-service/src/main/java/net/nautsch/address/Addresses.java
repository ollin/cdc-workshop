package net.nautsch.address;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/addresses")
public class Addresses {

    private final Address[] addresses;

    public Addresses() {
        this.addresses = new Address[] {
                new Address("Wloka", "Jan")
                , new Address("Nieminen", "Miko")
                , new Address("Nautsch", "Oliver")
        };
    }

    @RequestMapping(method= RequestMethod.GET)
    public @ResponseBody Address[] all() {
        return this.addresses;
    }
}

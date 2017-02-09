package net.nautsch.address;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/addresses")
public class Addresses {

    private final Address[] addressesBackend;

    Addresses() {
        this.addressesBackend = new Address[] {
                new Address("Wloka", "Jan")
                , new Address("Nieminen", "Miko")
                , new Address("Nautsch", "Oliver")
        };
    }

    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody public Address[] all() {
        return this.addressesBackend;
    }

    public Address getAddress(String addressId) {
        return null;
    }
}

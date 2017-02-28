package net.nautsch.address;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/addresses")
public class Addresses {

    private final Map<String, Address> addressesBackend = new HashMap<>();

    Addresses() {
        add(new Address("1","Wloka", "Jan"));
        add(new Address("2","Nieminen", "Miko"));
        add(new Address("3","Nautsch", "Oliver"));
    }

    private void add(Address address) {
        this.addressesBackend.put(address.getId(), address);
    }

    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody public Address[] all() {
        Collection<Address> addresses = this.addressesBackend.values();
        return addresses.toArray(new Address[addresses.size()]);
    }

    @RequestMapping(method= RequestMethod.GET, path = "/{addressId}")
    @ResponseBody public Address getAddress(@PathVariable String addressId) {
        return this.addressesBackend.get(addressId);
    }
}

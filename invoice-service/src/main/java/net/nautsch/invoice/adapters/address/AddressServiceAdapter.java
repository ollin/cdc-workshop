package net.nautsch.invoice.adapters.address;

import net.nautsch.invoice.Address;
import net.nautsch.invoice.AddressProvider;
import org.springframework.web.client.RestTemplate;

/**
 * calls the address service.
 */
public class AddressServiceAdapter implements AddressProvider {

    private final String baseUrl;

    public AddressServiceAdapter(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public Address getAddress(String addressId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(baseUrl + "/address/" + addressId, AddressImpl.class);
    }
}

package net.nautsch.invoice.adapters.address;

import au.com.dius.pact.consumer.ConsumerPactBuilder;
import au.com.dius.pact.consumer.PactError;
import au.com.dius.pact.consumer.TestRun;
import au.com.dius.pact.consumer.VerificationResult;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.model.MockProviderConfig;
import au.com.dius.pact.model.PactFragment;
import au.com.dius.pact.model.PactSpecVersion;
import net.nautsch.invoice.Address;
import org.apache.http.entity.ContentType;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static au.com.dius.pact.consumer.ConsumerPactTest.PACT_VERIFIED;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * integration test.
 */
public class AddressServiceAdapterTest {

    private static final String ADDRESS = "address_service";
    private static final String INVOICE = "invoice_service";


    // tag::shouldDeliverAnAddress[]
    @Test
    public void shouldDeliverAnAddress() {
        PactDslJsonBody responseBody = new PactDslJsonBody()
                .stringType("firstName", "Jan")
                .stringType("surname", "Wloka");

        PactFragment fragment = buildPactFragment(responseBody, "get an address");

        runTest(fragment);
    }
    // end::shouldDeliverAnAddress[]

    private PactFragment buildPactFragment(PactDslJsonBody responseBody, String description) {
        return buildPactFragment("", responseBody, description);
    }

    private PactFragment buildPactFragment(String requestBody, PactDslJsonBody responseBody, String description) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", ContentType.APPLICATION_JSON.toString());
        return ConsumerPactBuilder
                .consumer(INVOICE)
                .hasPactWith(ADDRESS)
                .uponReceiving(description)
                    .path("/addresses/1")
                    .method("GET")
                    .body(requestBody)
                    .headers(new HashMap<>())
                .willRespondWith()
                    .status(200)
                    .body(responseBody)
                    .headers(headers)
                    .toFragment();
    }

    private void runTest(final PactFragment pactFragment) {
        MockProviderConfig config = MockProviderConfig.createDefault(PactSpecVersion.V3);
        VerificationResult result = pactFragment.runConsumer(config, new TestRun() {
            @Override
            public void run(MockProviderConfig config) {
                Address result = new AddressServiceAdapter(config.url()).getAddress("1");
                assertThat(result.getFirstName(), is("Jan"));
                assertThat(result.getSurname(), is("Wloka"));
            }
        });

        if (result instanceof PactError) {
            throw new RuntimeException(((PactError)result).error());
        }

        assertThat(result, is(PACT_VERIFIED));
    }
}
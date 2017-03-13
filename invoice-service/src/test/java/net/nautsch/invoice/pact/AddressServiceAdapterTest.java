package net.nautsch.invoice.pact;

import au.com.dius.pact.consumer.ConsumerPactBuilder;
import au.com.dius.pact.consumer.PactError;
import au.com.dius.pact.consumer.VerificationResult;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.model.MockProviderConfig;
import au.com.dius.pact.model.PactFragment;
import au.com.dius.pact.model.PactSpecVersion;
import java.util.Collections;
import java.util.function.Consumer;
import net.nautsch.invoice.Address;
import net.nautsch.invoice.adapters.address.AddressServiceAdapter;

import org.apache.http.HttpStatus;
import org.junit.Test;

import static au.com.dius.pact.consumer.ConsumerPactTest.PACT_VERIFIED;
import static org.apache.http.entity.ContentType.APPLICATION_JSON;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Pact consumer test, generates the consumer contract.
 */
public class AddressServiceAdapterTest {

    private static final String ADDRESS = "address_service";
    private static final String INVOICE = "invoice_service";

    // tag::shouldDeliverValidAddress[]
    @Test
    public void shouldDeliverValidAddress() {
        PactDslJsonBody responseBody = new PactDslJsonBody()
                .stringType("firstName", "Jan")
                .stringType("surname", "Wloka");

        PactFragment pact = buildPact("", responseBody, "get an address");

        assertPact(pact, config -> {
            Address actual = new AddressServiceAdapter(config.url()).getAddress("1");

            assertThat(actual.getFirstName(), is("Jan"));
            assertThat(actual.getSurname(), is("Wloka"));
        });
    }
    // end::shouldDeliverValidAddress[]

    private PactFragment buildPact(String requestBody, PactDslJsonBody responseBody, String description) {
        return ConsumerPactBuilder
                .consumer(INVOICE)
                .hasPactWith(ADDRESS)
                .uponReceiving(description)
                    .path("/addresses/1")
                    .method("GET")
                    .body(requestBody)
                    .headers(Collections.emptyMap())
                .willRespondWith()
                    .status(HttpStatus.SC_OK)
                    .body(responseBody)
                    .headers(Collections.singletonMap("Content-Type", APPLICATION_JSON.toString()))
                    .toFragment();
    }

    private void assertPact(PactFragment pact, Consumer<MockProviderConfig> consumer) {
        MockProviderConfig config = MockProviderConfig.createDefault(PactSpecVersion.V3);
        VerificationResult result = pact.runConsumer(config, consumer::accept);

        if (result instanceof PactError) {
            throw new RuntimeException(((PactError)result).error());
        }

        assertThat(result, is(PACT_VERIFIED));
    }
}
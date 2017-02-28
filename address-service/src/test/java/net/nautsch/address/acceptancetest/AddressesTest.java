package net.nautsch.address.acceptancetest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * acceptance test.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddressesTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldDeliver3Addresses() throws IOException, JSONException {
        // given

        // when
        JSONArray result = new JSONArray(this.restTemplate.getForObject("/addresses", String.class));
        // then
        assertThat(result, notNullValue());
        assertThat(result.length(), is(3));
    }

    @Test
    public void shouldHaveEndpointToGetOneAddress() {
        // given

        // when
        ResponseEntity<String> result = this.restTemplate.getForEntity("/addresses/1", String.class);
        //
        assertThat(result.getStatusCodeValue(), is(200));
    }

    @Test
    public void shouldDeliverJanWloka() throws IOException, JSONException {
        // given

        // when
        JSONObject result = new JSONObject(this.restTemplate.getForObject("/addresses/1", String.class));
        // then
        assertThat(result, notNullValue());
        assertThat(result.getString("id"), is("1"));
        assertThat(result.getString("firstName"), is("Jan"));
        assertThat(result.getString("surname"), is("Wloka"));
    }
}

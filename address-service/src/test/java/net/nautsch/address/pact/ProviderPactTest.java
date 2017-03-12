package net.nautsch.address.pact;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestContextManager;

/**
 * running the net.nautsch.address.pact tests against our provider implementation.
 */
@RunWith(PactRunner.class) // Say JUnit to run tests with custom Runner
@Provider("address_service")
@PactFolder("pacts")
//@PactBroker(host="broker.nautsch.net", port = "80")
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProviderPactTest {

    private static int port =8888;


    @Before
    public void before() throws Exception {
        TestContextManager testContextManager = new TestContextManager(ProviderPactTest.class);
        testContextManager.prepareTestInstance(this);
    }


    @TestTarget
    public final Target target = new HttpTarget(port);
}

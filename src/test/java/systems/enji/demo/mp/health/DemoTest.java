package systems.enji.demo.mp.health;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.jupiter.api.Test;

/**
 * This test requires the demo service to be up and running.
 */
public class DemoTest {

  // beware: WildFly exposes health checks under a different port than the normal application
  private static final String ENDPOINT = "http://localhost:9990";

  @Test
  public void readiness() {
    
    Client client = ClientBuilder.newClient();
    WebTarget target = client.target(ENDPOINT + "/health/ready");
    
    String responseString = target.request().get(String.class);
    System.out.println(responseString);
    
    // we only perform a simple assertion, no need to parse the JSON response
//    JsonReader jsonReader = Json.createReader(new StringReader(responseString));
//    JsonObject jsonObject = jsonReader.readObject();

    assertNotNull(responseString);
    assertTrue(responseString.contains(ReadinessCheck.class.getName()));
    assertTrue(responseString.contains(ReadinessCheckProducer.class.getName()));
    
  }

  @Test
  public void liveness() {
    
    Client client = ClientBuilder.newClient();
    WebTarget target = client.target(ENDPOINT + "/health/live");
    
    String responseString = target.request().get(String.class);
    System.out.println(responseString);

    assertNotNull(responseString);
    assertTrue(responseString.contains(LivenessCheck.class.getName()));
    
  }

}

package systems.enji.demo.mp.health;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * This test requires the demo service to be up and running.
 */
public class DemoTest {

  // beware: WildFly exposes health checks under a different port than the normal application
  private static final String ENDPOINT = "http://localhost:9990";

  @BeforeAll
  static void beforeAll() {
    
  }
  
  @Test
  public void readiness() {
    Client client = ClientBuilder.newClient();
    WebTarget target = client.target(ENDPOINT + "/health/ready");
    
    String responseString = target.request().get(String.class);
    JsonReader jsonReader = Json.createReader(new StringReader(responseString));
    JsonObject jsonObject = jsonReader.readObject();
    System.out.println(jsonObject);
    
  }

}

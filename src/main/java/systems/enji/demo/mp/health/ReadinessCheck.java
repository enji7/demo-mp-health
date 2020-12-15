package systems.enji.demo.mp.health;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

/**
 * Checks whether the application is ready to process requests.
 * 
 * Liveness and readiness annotations can also be applied to a single class.
 * 
 * There can be several liveness and readiness checks per application. 
 * In this case, there is no guaranteed order of invocation.
 */
@ApplicationScoped
@Readiness
public class ReadinessCheck implements HealthCheck {

  @Override
  public HealthCheckResponse call() {
    return HealthCheckResponse.named(ReadinessCheck.class.getName())
        .withData("demo-key-1", "demo-value-1")
        .withData("demo-key-2", "demo-value-2")
        .up()
        .build();
  }

}

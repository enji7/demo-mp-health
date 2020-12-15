package systems.enji.demo.mp.health;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

/**
 * Checks whether the application is running.
 * If this check fails, the application can be discarded.
 */
@ApplicationScoped
@Liveness
public class LivenessCheck implements HealthCheck {

  @Override
  public HealthCheckResponse call() {
    return HealthCheckResponse.named(LivenessCheck.class.getName())
        .withData("demo-key-1", "demo-value-1")
        .withData("demo-key-2", "demo-value-2")
        .up()
        .build();
  }

}

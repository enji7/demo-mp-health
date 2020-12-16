package systems.enji.demo.mp.health;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

/**
 * Health checks can also be provided via CDI producer.
 */
@ApplicationScoped
public class ReadinessCheckProducer {

  @Produces
  @Readiness
  public HealthCheck liveness() {
    return () -> HealthCheckResponse.named(ReadinessCheckProducer.class.getName())
        .withData("demo-key-1", "demo-value-1")
        .withData("demo-key-2", "demo-value-2")
        .up()
        .build();
  }

}

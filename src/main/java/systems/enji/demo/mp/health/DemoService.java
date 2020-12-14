package systems.enji.demo.mp.health;

import systems.enji.demo.mp.health.api.IDemoService;

/**
 * Demo service.
 * 
 * See interface for high-level documentation.
 */
public class DemoService implements IDemoService {

  @Override
  public String ping() {
    return "pong";
  }

}

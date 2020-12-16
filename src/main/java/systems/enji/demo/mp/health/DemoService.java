package systems.enji.demo.mp.health;

import systems.enji.demo.mp.health.api.IDemoService;

/**
 * Demo service.
 */
public class DemoService implements IDemoService {

  @Override
  public String ping() {
    return "pong";
  }

}

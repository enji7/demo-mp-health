package systems.enji.demo.mp.health.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("")
public interface IDemoService {

  @GET
  @Path("ping")
  String ping();
  
}

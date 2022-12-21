package Controller;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.Response;

@Path("application")
public class RequestController {

    @GET
    @Path ("jegyarak")
    public Response jegyarak(){

        return Response.ok().build();
    }

    @GET
    @Path ("korcsolyak")
    public Response korcsolyak(){

        return Response.ok().build();
    }

}

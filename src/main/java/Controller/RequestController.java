package Controller;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.Response;

@Path("application")
public class RequestController {

    @GET
    @Path ("jegyarak")
    public Response getAllGames(){

        return Response.ok().build();
    }

    @GET
    @Path ("nyitvatartasok")
    public Response getAllNyitvatartas(){

        return Response.ok().build();
    }

}

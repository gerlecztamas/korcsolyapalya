package Controller;

import Model.Korcsolya;
import Model.KorcsolyaTipusEnum;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.Response;
import org.json.JSONArray;

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

            JSONArray korcsolyak = new JSONArray();
            Korcsolya korcsolya1 = new Korcsolya(1, KorcsolyaTipusEnum.HockeyKorcsolya, 36, "kék");
            Korcsolya korcsolya2 = new Korcsolya(2, KorcsolyaTipusEnum.Mukorcsolya, 38, "piros");
            korcsolyak.put(korcsolya1.toJson());
            korcsolyak.put(korcsolya2.toJson());

        return Response.ok(korcsolyak.toString()).build();
    }

    @GET
    @Path ("nyitvatartas")
    public Response getNyitvatartas(){

        return Response.ok().build();
    }

}

package Controller;

import Model.Jegy;
import Model.Korcsolya;
import Model.KorcsolyaTipusEnum;
import Model.RequestModel;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;

@Path("application")
public class RequestController {

    @GET
    @Path ("jegyarak")
    public Response jegyarak(){

            Jegy jegy1 = new Jegy("Diák", 2000);
            Jegy jegy2 = new Jegy("Nyugdíjas", 1500, "Csak 85 év felett");
            String jegyek = jegy1.toString() + "\n" + jegy2.toString();

        return Response.ok(jegyek).build();
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

    @POST
    @Path("korcsolyaKolcsonzes")
    public Response kolcsonzes(String igeny) {
        JSONObject igenyJson = new JSONObject(igeny);

        return Response.ok(RequestModel.kolcsonzes(igenyJson)).build();
    }


}

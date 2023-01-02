package Controller;

import Model.*;
import View.JegyView;
import View.KorcsolyaView;
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
        JSONArray jegyek = XmlReader.read(System.getProperty("user.dir") +
                "\\IdeaProjects\\korcsolyapalya\\src\\main\\resources\\jegy.xml");



        return Response.ok(JegyView.showJegyek(jegyek)).build();
    }


    @GET
    @Path ("korcsolyak")
    public Response korcsolyak(){
        JSONArray korcsolyak = XmlReader.read(System.getProperty("user.dir") +
                "\\IdeaProjects\\korcsolyapalya\\src\\main\\resources\\korcsolyak.xml");

        return Response.ok(KorcsolyaView.showKorcsolyak(korcsolyak)).build();
    }

    @GET
    @Path ("nyitvatartas")
    public Response getNyitvatartas(){
        JSONArray korcsolyak = XmlReader.read(System.getProperty("user.dir") +
                "\\IdeaProjects\\korcsolyapalya\\src\\main\\resources\\korcsolyak.xml");

        return Response.ok(korcsolyak.toString()).build();
    }

    @POST
    @Path("korcsolyaKolcsonzes")
    public Response kolcsonzes(String igeny) {
        JSONObject igenyJson = new JSONObject(igeny);

        return Response.ok(RequestModel.kolcsonzes(igenyJson)).build();
    }

    /*@POST
    @Path("korcsolyaFelvetel")
    public Response felvetel(String json){
        JSONObject korcsolya = new JSONObject(json);
        Boolean result = RequestModel.addKorcsolya(korcsolya);
        if(result){
            return Response.ok("A korcsolyát hozzáadtuk az adatbázishoz!").build();
        }
        return Response.ok("Rossz formában adta meg a request body tartalmát vagy nem létező korcsolyatípust adott meg!").build();
    }*/


}

package Model;

import org.json.JSONArray;
import org.json.JSONObject;
import Model.XmlWriter;

import java.io.File;


public class RequestModel {

    public static String kolcsonzes(JSONObject igeny){
        String result = "Nincs az igényeknek megfelelő korcsolya!";

        JSONArray korcsolyak = XmlReader.read(System.getProperty("user.dir") + "\\IdeaProjects\\korcsolyapalya\\src\\main\\resources\\korcsolyak.xml");

        for(int i = 0; i < korcsolyak.length(); i++){
            JSONObject korcsolya = korcsolyak.getJSONObject(i);
            try{
                if(korcsolya.getString("meret").equals(igeny.getString("meret")) && korcsolya.getString("tipus").equals(igeny.getString("tipus"))){

                    Korcsolya kolcsonzott = new Korcsolya(3, KorcsolyaTipusEnum.valueOf(korcsolya.getString("tipus")), korcsolya.getInt("meret"), korcsolya.getString("szin"));
                    result = "A következő korcsolyát sikeresen kikölcsönözte: \n"+ kolcsonzott.toString();

                    Korcsolya ujKorcsolya = new Korcsolya(korcsolya.getInt("id"),
                            KorcsolyaTipusEnum.valueOf(korcsolya.getString("tipus")), korcsolya.getInt("meret"),
                            korcsolya.getString("szin"));
                    ujKorcsolya.writer();

                    return result;

                }
            }
            catch(Exception e){
                result = "Hibás bemenő paraméterek!";
                return result;
            }
        }
        return result;
    }

}

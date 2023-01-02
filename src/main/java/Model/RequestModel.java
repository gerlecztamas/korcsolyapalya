package Model;

import org.json.JSONArray;
import org.json.JSONObject;
import Model.XmlWriter;

import java.io.File;
import java.time.LocalDate;


public class RequestModel {

    public static String kolcsonzes(JSONObject igeny){
        String result = "Nincs az igényeknek megfelelő korcsolya!";

        JSONArray korcsolyak = XmlReader.read(System.getProperty("user.dir") +
                "\\IdeaProjects\\korcsolyapalya\\src\\main\\resources\\korcsolyak.xml");
        JSONArray kolcsonzottek = XmlReader.read(System.getProperty("user.dir") +
                "\\IdeaProjects\\korcsolyapalya\\src\\main\\resources\\korcsolyakolcsonzes.xml");

        for(int i = 0; i < korcsolyak.length(); i++){
            JSONObject korcsolya = korcsolyak.getJSONObject(i);
            try{
                if(korcsolya.getString("meret").equals(igeny.getString("meret")) &&
                        korcsolya.getString("tipus").equals(igeny.getString("tipus"))){
                    //szükséges ellenőrizni hogy aznapra már ki van-e kölcsönözve!

                    //AZT MEG KELL JAVÍTANI AHOGY JELENLEG KIÍRJA A KORCSOLYÁT MERT ÍGY NEM TUDJA MEGNÉZNI, HOGY AZ KI VAN-E KÖLCSÖNÖZVE MÁR!!!
                    if(kolcsonzottek.length() == 0){
                        result = makeKolcsonzes(korcsolya, igeny, kolcsonzottek);
                        return result;
                    }
                    else {
                        for(int j = 0; j < kolcsonzottek.length(); j++){
                            JSONObject kolcsonzottKorcsolya = kolcsonzottek.getJSONObject(j);
                            if(kolcsonzottKorcsolya.getString("id").equals(korcsolya.getString("id")) &&
                                    kolcsonzottKorcsolya.getString("datum").equals(korcsolya.getString("datum"))){
                                System.out.println("Már ki van kölcsönözve erre az időpontra!");
                            }
                            else{
                                result = makeKolcsonzes(korcsolya, igeny, kolcsonzottek);
                                return result;
                            }
                        }
                    }
                }
            }
            catch(Exception e){
                result = "Hibás bemenő paraméterek!";
                return result;
            }
        }
        return result;
    }

    public static String makeKolcsonzes(JSONObject korcsolya, JSONObject igeny, JSONArray kolcsonzottek){
        String result;
        Korcsolya kolcsonzott = new Korcsolya(korcsolya.getInt("id"),
                KorcsolyaTipusEnum.valueOf(korcsolya.getString("tipus")), korcsolya.getInt("meret"),
                korcsolya.getString("szin"));
        result = "A következő korcsolyát sikeresen kikölcsönözte: \n"+ kolcsonzott.toString();


        Kolcsonzes kolcsonzes = new Kolcsonzes(kolcsonzottek.length(), igeny.getString("keresztnev"),
                igeny.getString("vezeteknev"), igeny.getString("email"), kolcsonzott,
                LocalDate.parse(igeny.getString("datum")));
        kolcsonzes.writer();

        return result;
    }

}

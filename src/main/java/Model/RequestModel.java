package Model;

import org.json.JSONArray;
import org.json.JSONObject;

public class RequestModel {

    public static String kolcsonzes(JSONObject igeny){
        String result = "Nincs az igényeknek megfelelő korcsolya!";

        //TEST LISTA, MEG KELL HOGY KAPJA JSONARRAYBEN AZ ÖSSZES KORI ADATÁT:
        JSONArray korcsolyak = new JSONArray();
        Korcsolya korcsolya1 = new Korcsolya(1, KorcsolyaTipusEnum.HockeyKorcsolya, 36, "kék");
        Korcsolya korcsolya2 = new Korcsolya(2, KorcsolyaTipusEnum.Mukorcsolya, 38, "piros");
        korcsolyak.put(korcsolya1.toJson());
        korcsolyak.put(korcsolya2.toJson());

        for(int i = 0; i < korcsolyak.length(); i++){
            JSONObject korcsolya = korcsolyak.getJSONObject(i);
            try{
                if(korcsolya.get("meret") == igeny.get("meret") && korcsolya.getString("tipus").equals(igeny.getString("tipus"))){
                result = korcsolya.toString();
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

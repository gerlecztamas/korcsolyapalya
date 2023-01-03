package Model;

import org.json.JSONArray;
import org.json.JSONObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.LocalTime;


public class RequestModel {

    public static String kolcsonzes(JSONObject igeny){
        String result = "Nincs az igényeknek megfelelő korcsolya!";

        JSONArray korcsolyak = XmlReader.read(System.getProperty("user.dir") +
                "\\IdeaProjects\\korcsolyapalya\\src\\main\\resources\\korcsolyak.xml");
        JSONArray kolcsonzottek = XmlReader.read(System.getProperty("user.dir") +
                "\\IdeaProjects\\korcsolyapalya\\src\\main\\resources\\korcsolyakolcsonzes.xml");

        for(int i = 0; i < korcsolyak.length(); i++){
            JSONObject korcsolya = korcsolyak.getJSONObject(i); //a listában lévő korcsolya az összes korcsolya közül
            try{
                if(korcsolya.getString("meret").equals(igeny.getString("meret")) &&
                        korcsolya.getString("tipus").equals(igeny.getString("tipus"))){

                    if(kolcsonzottek.length() == 0){
                        result = makeKolcsonzes(korcsolya, igeny, kolcsonzottek);
                        return result;
                    }
                    else {
                        boolean szabad = true;
                        for(int j = 0; j < kolcsonzottek.length(); j++){
                            JSONObject kolcsonzottKorcsolya = kolcsonzottek.getJSONObject(j);

                            if(kolcsonzottKorcsolya.getString("korcsolyaId").equals(korcsolya.getString("id")) &&
                                    kolcsonzottKorcsolya.getString("datum").equals(igeny.getString("datum"))){
                                result = "Már minden korcsolya ezzel a paraméterrel ki van kölcsönözve az adott dátumra!";
                                szabad = false;
                            }

                        }
                        if(szabad){
                            result = makeKolcsonzes(korcsolya, igeny, kolcsonzottek);
                            return result;
                        }

                    }
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
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

        Kolcsonzes kolcsonzes = new Kolcsonzes(kolcsonzottek.length(), igeny.getString("keresztnev"),
                igeny.getString("vezeteknev"), igeny.getString("email"), Integer.valueOf(korcsolya.getString("id")),
                LocalDate.parse(igeny.getString("datum")));
        kolcsonzes.writer();

        result = "A következő korcsolyát sikeresen kikölcsönözte: \n"+ kolcsonzott + "\naz alábbi napra: "
                + kolcsonzes.getDatum().toString() + " (" + kolcsonzes.getDatum().getDayOfWeek() + ")";

        return result;
    }

    public static String foglalas(JSONObject igeny){
        String result;

        if(LocalTime.parse(igeny.getString("veg")).isBefore(LocalTime.parse(igeny.getString("kezdet")))){
            return "A pályafoglalás befejezése nem lehet a kezdete előtti időpont!";
        }

        JSONArray foglalasok = XmlReader.read(System.getProperty("user.dir") +
                "\\IdeaProjects\\korcsolyapalya\\src\\main\\resources\\palyafoglalas.xml");

        //csak végig kell menni a létező foglalásokon és megnézni, hogy bármelyikkel egyezik-e!!!
        try {
            for (int i = 0; i < foglalasok.length(); i++) {
                JSONObject foglalas = foglalasok.getJSONObject(i);

                //x1 <= y2 && y1 <= x2
                if (LocalDate.parse(igeny.getString("datum")).isEqual(LocalDate.parse(foglalas.getString("datum")))) {
                    if (LocalTime.parse(igeny.getString("kezdet")).isBefore(LocalTime.parse(foglalas.getString("veg")))
                            && LocalTime.parse(foglalas.getString("kezdet")).isBefore(LocalTime.parse(igeny.getString("veg")))) {
                        result = "Az adott időpontra már foglalt a pálya!";
                        return result;
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            result = "Hibás bemenő paraméterek!";
            return result;
        }

        result = makeFoglalas(igeny, foglalasok);
        return result;
    }

    public static String makeFoglalas(JSONObject igeny, JSONArray foglalasok){
        String result;

        Foglalas foglalas = new Foglalas(foglalasok.length(), igeny.getString("vezeteknev"),
                igeny.getString("keresztnev"), igeny.getString("email"),
                LocalDate.parse(igeny.getString("datum")), LocalTime.parse(igeny.getString("kezdet")),
                LocalTime.parse(igeny.getString("veg")));
        foglalas.writer();

        result = "Sikeres foglalás!"; //IDE KÉNE EGY SZEBB KIIRATÁS TOMI!!!!

        return result;
    }


    public static Boolean addKorcsolya(JSONObject korcsolya){
        try {
            JSONArray korcsolyak = XmlReader.read(System.getProperty("user.dir") +
                    "\\IdeaProjects\\korcsolyapalya\\src\\main\\resources\\korcsolyak.xml");
            String tipus = korcsolya.getString("tipus");
            ArrayList<String> tipusLista = new ArrayList<String>();
            for (KorcsolyaTipusEnum tipusEnum : KorcsolyaTipusEnum.values()) {
                String tipusString = tipusEnum.name();
                tipusLista.add(tipusString);
                System.out.println(tipusString.getClass().getName() + "hahooo" + tipusString);
            }
            if (!tipusLista.contains(tipus)) {
                return false;
            }
            Korcsolya ujKorcsolya = new Korcsolya(korcsolyak.length(), KorcsolyaTipusEnum.valueOf(korcsolya.getString("tipus")), korcsolya.getInt("meret"), korcsolya.getString("szin"));
            ujKorcsolya.writer();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }

        return true;
    }

}

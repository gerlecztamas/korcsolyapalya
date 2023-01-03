package Model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Kolcsonzes extends Tranzakcio implements WriterInterface{

    @GetterFunctionName(name="getKorcsolya")
    private Integer korcsolyaId;
    @GetterFunctionName(name="getDatum")
    private LocalDate datum;

    public Kolcsonzes(int id, String vezeteknev, String keresztnev, String email, Integer korcsolyaId, LocalDate datum) {
        super(id, vezeteknev, keresztnev, email);
        this.korcsolyaId = korcsolyaId;
        this.datum = datum;
    }

    public Integer getKorcsolya() {
        return korcsolyaId;
    }

    public LocalDate getDatum() {
        return datum;
    }

    @Override
    public String toString(){
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd.");
        String kolcsonzes = "Kölcsönző neve: " + this.getVezeteknev() + " " + this.getKeresztnev() + "\n";
        kolcsonzes += "Email címe: " + this.getEmail() + "\n";
        kolcsonzes += "Kölcsönzés dátuma: " + FORMATTER.format(this.datum) + "\n";
        kolcsonzes += "Kölcsönzött korcsolya:\n\n";
        JSONArray korcsolyak = XmlReader.read(System.getProperty("user.dir") +
                "\\IdeaProjects\\korcsolyapalya\\src\\main\\resources\\korcsolyak.xml");
        for(int i = 0; i < korcsolyak.length(); i++){
            JSONObject korcsolya = korcsolyak.getJSONObject(i);
            if(korcsolya.getInt("id") == this.korcsolyaId){
                Korcsolya ujKorcsolya = new Korcsolya(korcsolya.getInt("id"), KorcsolyaTipusEnum.valueOf(korcsolya.getString("tipus")), korcsolya.getInt("meret"), korcsolya.getString("szin"));
                kolcsonzes += ujKorcsolya + "\n\n\n";
            }
        }
        return kolcsonzes;
    }

    @Override
    public void writer() {
        XmlWriter<Kolcsonzes> t = new XmlWriter<Kolcsonzes>();
        t.writer(this, System.getProperty("user.dir") +
                "\\IdeaProjects\\korcsolyapalya\\src\\main\\resources\\korcsolyakolcsonzes.xml");
    }
}

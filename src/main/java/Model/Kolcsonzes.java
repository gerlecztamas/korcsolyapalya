package Model;

import java.time.LocalDate;

public class Kolcsonzes extends Tranzakcio {

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

    public void writer(){
        XmlWriter<Kolcsonzes> t = new XmlWriter<Kolcsonzes>();
        t.writer(this, System.getProperty("user.dir") +
                "\\IdeaProjects\\korcsolyapalya\\src\\main\\resources\\korcsolyakolcsonzes.xml");
    }
}

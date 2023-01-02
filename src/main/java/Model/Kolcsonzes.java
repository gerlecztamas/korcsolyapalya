package Model;

import java.time.LocalDate;

public class Kolcsonzes extends Tranzakcio {

    @GetterFunctionName(name="getKorcsolya")
    private Korcsolya korcsolya;
    @GetterFunctionName(name="getDatum")
    private LocalDate datum;

    public Kolcsonzes(int id, String vezeteknev, String keresztnev, String email, Korcsolya korcsolya, LocalDate datum) {
        super(id, vezeteknev, keresztnev, email);
        this.korcsolya = korcsolya;
        this.datum = datum;
    }

    public Korcsolya getKorcsolya() {
        return korcsolya;
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

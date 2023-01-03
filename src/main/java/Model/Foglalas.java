package Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Foglalas extends Tranzakcio {

    @GetterFunctionName(name="getDatum")
    private LocalDate datum;
    @GetterFunctionName(name="getKezdet")
    private LocalTime kezdet;
    @GetterFunctionName(name="getVeg")
    private LocalTime veg;

    public Foglalas(int id, String vezeteknev, String keresztnev, String email, LocalDate datum, LocalTime kezdet, LocalTime veg) {
        super(id, vezeteknev, keresztnev, email);
        this.datum = datum;
        this.kezdet = kezdet;
        this.veg = veg;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public LocalTime getKezdet() {
        return kezdet;
    }

    public LocalTime getVeg() {
        return veg;
    }

    public void writer(){
        XmlWriter<Foglalas> t = new XmlWriter<>();
        t.writer(this, System.getProperty("user.dir") +
                "\\IdeaProjects\\korcsolyapalya\\src\\main\\resources\\palyafoglalas.xml");
    }

    @Override
    public String toString(){
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        String foglalas = FORMATTER.format(this.datum) + "-én/-án, ";
        foglalas += this.kezdet + "-tól/-től ";
        foglalas += this.veg + "-ig ";
        foglalas += this.getVezeteknev() + " " + this.getKeresztnev() + " néven";
        return foglalas;
    }
}

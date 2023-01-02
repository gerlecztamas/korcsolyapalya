package Model;

import java.time.LocalDate;

public class Kolcsonzes extends Tranzakcio {

    private Korcsolya korcsolya;
    private LocalDate datum;

    public Kolcsonzes(int id, String vezeteknev, String keresztnev, String email, Korcsolya korcsolya, LocalDate datum) {
        super(id, vezeteknev, keresztnev, email);
        this.korcsolya = korcsolya;
        this.datum = datum;
    }

    public Korcsolya getKorcsolya() {
        return korcsolya;
    }
}

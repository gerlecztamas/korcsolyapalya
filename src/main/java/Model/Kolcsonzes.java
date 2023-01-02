package Model;

import java.time.LocalDateTime;

public class Kolcsonzes extends Tranzakcio {

    private Korcsolya korcsolya;

    public Kolcsonzes(int id, String vezeteknev, String keresztnev, String email, LocalDateTime kezdet, LocalDateTime veg, Korcsolya korcsolya) {
        super(id, vezeteknev, keresztnev, email, kezdet, veg);
        this.korcsolya = korcsolya;
    }

    public Korcsolya getKorcsolya() {
        return korcsolya;
    }
}

package Model;

import java.time.LocalDateTime;

public class Tranzakcio {
    private int id;
    private String vezeteknev;
    private String keresztnev;
    private String email;
    private LocalDateTime kezdet;
    private LocalDateTime veg;

    public Tranzakcio() {
    }
    public Tranzakcio(int id, String vezeteknev, String keresztnev, String email, LocalDateTime kezdet, LocalDateTime veg) {
        this.id = id;
        this.vezeteknev = vezeteknev;
        this.keresztnev = keresztnev;
        this.email = email;
        this.kezdet = kezdet;
        if(veg.isAfter(kezdet)){
            this.veg = veg;
        }
        else {
            this.veg = kezdet;
        }
    }

    public int getId() {
        return id;
    }

    public String getVezeteknev() {
        return vezeteknev;
    }

    public String getKeresztnev() {
        return keresztnev;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getKezdet() {
        return kezdet;
    }

    public LocalDateTime getVeg() {
        return veg;
    }
}

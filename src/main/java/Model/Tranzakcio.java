package Model;

import java.time.LocalDateTime;

public class Tranzakcio {
    private int id;
    private String vezeteknev;
    private String keresztnev;
    private String email;


    public Tranzakcio() {
    }
    public Tranzakcio(int id, String vezeteknev, String keresztnev, String email) {
        this.id = id;
        this.vezeteknev = vezeteknev;
        this.keresztnev = keresztnev;
        this.email = email;
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

}

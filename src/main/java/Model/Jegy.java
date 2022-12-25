package Model;

import org.json.JSONObject;

public class Jegy {
    private String nev;
    private int ar;
    private String megjegyzes;

    public Jegy() {
    }

    public Jegy(String nev, int ar) {
        this.nev = nev;
        this.ar = ar;
    }

    public Jegy(String nev, int ar, String megjegyzes) {
        this.nev = nev;
        this.ar = ar;
        this.megjegyzes = megjegyzes;
    }

    public String getNev() {
        return nev;
    }

    public int getAr() {
        return ar;
    }

    public String getMegjegyzes() {
        return megjegyzes;
    }

    @Override
    public String toString() {
        String jegy = "Jegy típusa: " + this.nev;
        if(this.megjegyzes != null) {
            jegy += " (" + this.megjegyzes + ")";
        }
        jegy += "\nÁra: " + this.ar;
        return jegy;
    }
}
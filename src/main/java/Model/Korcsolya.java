package Model;


import org.json.JSONObject;

public class Korcsolya {
    private int id;
    private KorcsolyaTipusEnum tipus;
    private int meret;
    private String szin;

    public Korcsolya() {
    }

    public Korcsolya(int id, KorcsolyaTipusEnum tipus, int meret, String szin) {
        this.id = id;
        this.tipus = tipus;
        this.meret = meret;
        this.szin = szin;
    }

    public int getId() {
        return id;
    }

    public KorcsolyaTipusEnum getTipus() {
        return tipus;
    }

    public int getMeret() {
        return meret;
    }

    public String getSzin() {
        return szin;
    }

    public JSONObject toJson() {
        JSONObject korcsolyaJSON = new JSONObject();
        korcsolyaJSON.append("id", this.id);
        korcsolyaJSON.append("tipus", this.tipus.toString());
        korcsolyaJSON.append("meret", this.meret);
        korcsolyaJSON.append("szin", this.szin);

        return korcsolyaJSON;
    }

}

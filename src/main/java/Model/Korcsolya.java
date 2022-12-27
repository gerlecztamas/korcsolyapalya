package Model;


import org.json.JSONObject;

public class Korcsolya implements ToJsonInterface {
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


    @Override
    public JSONObject toJson() {
        JSONObject korcsolyaJSON = new JSONObject();
        korcsolyaJSON.put("id", this.id);
        korcsolyaJSON.put("tipus", this.tipus.toString());
        korcsolyaJSON.put("meret", this.meret);
        korcsolyaJSON.put("szin", this.szin);

        return korcsolyaJSON;
    }
}
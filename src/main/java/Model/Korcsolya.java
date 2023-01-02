package Model;

import Model.KorcsolyaTipusEnum;
import org.json.JSONObject;

public class Korcsolya implements ToJsonInterface {
    @GetterFunctionName(name="getId")
    private Integer id;
    @GetterFunctionName(name="getTipus")
    private KorcsolyaTipusEnum tipus;
    @GetterFunctionName(name="getMeret")
    private Integer meret;
    @GetterFunctionName(name="getSzin")
    private String szin;

    public Korcsolya() {
    }

    public Korcsolya(Integer id, KorcsolyaTipusEnum tipus, Integer meret, String szin) {
        this.id = id;
        this.tipus = tipus;
        this.meret = meret;
        this.szin = szin;
    }

    public Integer getId() {
        return id;
    }

    public KorcsolyaTipusEnum getTipus() {
        return tipus;
    }

    public Integer getMeret() {
        return meret;
    }

    public String getSzin() {
        return szin;
    }

    @Override
    public String toString(){
        String korcsolya = "Korcsolya típusa: " + this.tipus;
        korcsolya += "\nMérete: " + this.meret;
        korcsolya += "\nSzíne: " + this.szin;
        return korcsolya;
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

    public void writer(){
        XmlWriter<Korcsolya> t = new XmlWriter<Korcsolya>();
        t.writer(this, "C:\\Users\\Adri\\IdeaProjects\\korcsolyapalya\\src\\main\\resources\\korcsolyakolcsonzes.xml");
    }
}
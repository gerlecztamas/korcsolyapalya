package Model;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class KorcsolyaXmlReader {


    public JSONArray read() {
        JSONArray korcsolyak = new JSONArray();

        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            //mindenki állitsa be magának
            File f = new File("");
            Document doc = db.parse(f);
            doc.normalize();

            NodeList nodeList = doc.getElementsByTagName("korcsolya");
            for(int i = 0; i < nodeList.getLength(); i++){
                Element el = (Element) nodeList.item(i);
                JSONObject korcsolya = new JSONObject();

                String id = el.getElementsByTagName("id").item(0).getTextContent();
                String tipus = el.getElementsByTagName("tipus").item(0).getTextContent();
                String meret = el.getElementsByTagName("meret").item(0).getTextContent();
                String szin = el.getElementsByTagName("szin").item(0).getTextContent();

                korcsolya.put("id", id);
                korcsolya.put("tipus", tipus);
                korcsolya.put("meret", meret);
                korcsolya.put("szin", szin);

                korcsolyak.put(korcsolya);
            }

        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return korcsolyak;
    }
}
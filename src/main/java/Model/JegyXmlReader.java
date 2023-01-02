package Model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class JegyXmlReader {


    public JSONArray read() {
        JSONArray jegyek = new JSONArray();

        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            //mindenki állitsa be magának
            File f = new File("");
            Document doc = db.parse(f);
            doc.normalize();

            NodeList nodeList = doc.getElementsByTagName("jegy");
            for(int i = 0; i < nodeList.getLength(); i++){
                Element el = (Element) nodeList.item(i);
                JSONObject jegy = new JSONObject();

                String nev = el.getElementsByTagName("nev").item(0).getTextContent();
                String ar = el.getElementsByTagName("ar").item(0).getTextContent();
                String megjegyzes = el.getElementsByTagName("megjegyzes").item(0).getTextContent();

                jegy.put("nev", nev);
                jegy.put("ar", ar);
                jegy.put("megjegyzes", megjegyzes);

                jegyek.put(jegy);
            }

        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return jegyek;
    }
}
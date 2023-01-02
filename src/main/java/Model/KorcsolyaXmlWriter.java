package Model;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class KorcsolyaXmlWriter {

    public void write(Korcsolya newKorcsolya) {
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            //mindenki állitsa be magának
            File f = new File("");
            Document doc = db.parse(f);
            doc.normalize();

            Element root = doc.getDocumentElement();
            Element korcsolya = doc.createElement("korcsolya");
            root.appendChild(korcsolya);

            Element id = doc.createElement("id");
            Element tipus = doc.createElement("tipus");
            Element meret = doc.createElement("meret");
            Element szin = doc.createElement("szin");

            id.setTextContent(newKorcsolya.getId().toString());
            tipus.setTextContent(newKorcsolya.getTipus().toString());
            meret.setTextContent(newKorcsolya.getMeret().toString());
            szin.setTextContent(newKorcsolya.getSzin());

            korcsolya.appendChild(id);
            korcsolya.appendChild(tipus);
            korcsolya.appendChild(meret);
            korcsolya.appendChild(szin);

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(f);

            t.transform(source, result);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}

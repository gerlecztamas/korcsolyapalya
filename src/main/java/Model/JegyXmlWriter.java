package Model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class JegyXmlWriter {

    public void write(Jegy newJegy) {
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            //mindenki állitsa be magának
            File f = new File("");
            Document doc = db.parse(f);
            doc.normalize();

            Element root = doc.getDocumentElement();
            Element jegy = doc.createElement("jegy");
            root.appendChild(jegy);

            Element nev = doc.createElement("nev");
            Element ar = doc.createElement("ar");
            Element megjegyzes = doc.createElement("megjegyzes");

            nev.setTextContent(newJegy.getNev());
            ar.setTextContent(newJegy.getAr().toString());
            megjegyzes.setTextContent(newJegy.getMegjegyzes());

            jegy.appendChild(nev);
            jegy.appendChild(ar);
            jegy.appendChild(megjegyzes);

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

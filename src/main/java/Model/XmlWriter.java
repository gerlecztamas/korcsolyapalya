package Model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import Model.GetterFunctionName;

public class XmlWriter <T>{
    public void writer(T entity, String path){
        Class clazz = entity.getClass();
        Class superclazz = clazz.getSuperclass();
        try {

            File f = new File(path);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document xml = db.parse(f);
            xml.setXmlStandalone(true);

            Element elem = xml.createElement("elem");

            Field[] osTulajdonsagok = superclazz.getDeclaredFields();
            for (Field tulajdonsag : osTulajdonsagok) {
                if(tulajdonsag.getAnnotation(GetterFunctionName.class) != null){
                    String gfn = tulajdonsag.getAnnotation(GetterFunctionName.class).name();
                    Method gm = clazz.getMethod(gfn);
                    String ertek = gm.invoke(entity).toString();
                    String valtozoNev = tulajdonsag.getName();

                    Element elemek = xml.createElement(valtozoNev);
                    elemek.setTextContent(ertek);
                    elem.appendChild(elemek);
                }
            }

            Field[] tulajdonsagok = clazz.getDeclaredFields();
            for(Field tulajdonsag: tulajdonsagok) {
                if(tulajdonsag.getAnnotation(GetterFunctionName.class) != null){
                    String gfn = tulajdonsag.getAnnotation(GetterFunctionName.class).name();
                    Method gm = clazz.getMethod(gfn);
                    String ertek = gm.invoke(entity).toString();
                    String valtozoNev = tulajdonsag.getName();

                    Element elemek = xml.createElement(valtozoNev);
                    elemek.setTextContent(ertek);
                    elem.appendChild(elemek);
                }
            }

            xml.getFirstChild().appendChild(elem);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            t.setOutputProperty(OutputKeys.STANDALONE, "yes");
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.setOutputProperty("{http://xml.apache.org/xslt%7Dindent-amount", "1");


            DOMSource s = new DOMSource(xml);
            StreamResult r = new StreamResult(f);
            t.transform(s, r);


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

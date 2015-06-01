package persistencia;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import modelo.entidades.Autor;
import modelo.entidades.Libro;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class XmlAutor {

	public void agregarAutorXml(Autor autor,int c){
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc = docBuilder.parse(new File("src/data/autores.xml"));

			doc.getDocumentElement().normalize();
			Node nodoRaiz = doc.getDocumentElement();
			
			Element autore = doc.createElement("Autor");
			
			Element idAutor = doc.createElement("Id");
			idAutor.setTextContent(Integer.toString(c));
			
			Element nombreAutor = doc.createElement("Nombre");
			nombreAutor.setTextContent(autor.getNombre());
			
			
			autore.appendChild(idAutor);
			autore.appendChild(nombreAutor);
			nodoRaiz.appendChild(autore);
			
			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer transformer = transFactory.newTransformer();
			DOMSource source = new  DOMSource(doc);
			StreamResult result = new StreamResult(new File("src/data/autores.xml"));
			transformer.transform(source, result);
			
			
		}
		catch(ParserConfigurationException parseE){
			System.out.println(parseE.getMessage());

		}catch(SAXException saxE){
			System.out.println(saxE.getMessage());
		}catch(IOException ioE){
			System.out.println(ioE.getMessage());
		}catch(TransformerConfigurationException transE){
			System.out.println(transE.getMessage());
		}catch(TransformerException transformE){
			System.out.println(transformE.getMessage());
		}
	}
}

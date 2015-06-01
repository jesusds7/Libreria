package persistencia;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LeerXmlLibros {
	private int libros;
	public int leerIdXmlLibros(){
		try {
		    DocumentBuilderFactory fábricaCreadorDocumento = DocumentBuilderFactory.newInstance();
		    DocumentBuilder creadorDocumento = fábricaCreadorDocumento.newDocumentBuilder();
		    Document documento = creadorDocumento.parse("src/data/libros.xml");
		   
		    Element raiz = documento.getDocumentElement();

		   
		    NodeList listaLibros = raiz.getElementsByTagName("Libro");
		    libros = listaLibros.getLength();
		  

		 
		} catch (SAXException ex) {
		    System.out.println("ERROR: El formato XML del fichero no es correcto\n"+ex.getMessage());
		    ex.printStackTrace();
		} catch (IOException ex) {
		    System.out.println("ERROR: Se ha producido un error el leer el fichero\n"+ex.getMessage());
		    ex.printStackTrace();
		} catch (ParserConfigurationException ex) {
		    System.out.println("ERROR: No se ha podido crear el generador de documentos XML\n"+ex.getMessage());
		    ex.printStackTrace();
		}
		  return libros;
		
	}
	
	

}

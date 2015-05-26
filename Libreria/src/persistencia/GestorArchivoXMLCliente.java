package persistencia;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import modelo.entidades.Cliente;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GestorArchivoXMLCliente {
	
	public static final String RUTA = "src/files/";
	public static final String EXTENSION = ".xml";
	public static final String NOMBRE = "Nombre";
	public static final String ID = "id";
	public static final String DINERO = "Dinero"; 
	public static final String VALOR = "Valor";
	
	public static void exportarArchivoXML(Cliente cliente){
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document archivo = builder.newDocument();

			Element cuerpo = archivo.createElement("Clientes");
			archivo.appendChild(cuerpo);

			Attr atributos = archivo.createAttribute(ID);
			atributos.setValue(Integer.toString(cliente.getId()));
			cuerpo.setAttributeNode(atributos);

			Element nombre = archivo.createElement(NOMBRE);
			nombre.appendChild(archivo.createTextNode(cliente.getNombre()));				
			cuerpo.appendChild(nombre);

			Element dinero = archivo.createElement(DINERO);
			dinero.appendChild(archivo.createTextNode(Double.toString(cliente.getDinero())));
			cuerpo.appendChild(dinero);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(archivo);
			StreamResult resultado = new StreamResult(new File(RUTA + cliente.getNombre() + EXTENSION));

			try {
				transformer.transform(domSource, resultado);
			} catch (TransformerException e) {
				e.printStackTrace();
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
	}
}
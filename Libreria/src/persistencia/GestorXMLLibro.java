package persistencia;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import modelo.entidades.Libro;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GestorXMLLibro {
	public static final String RUTA_GUARDAR_XML = "src/archivos/";
	public static final String C_NOMBRE = "Nombre";
	public static final String C_ID = "id";
	public static final String C_DESCRIPCION = "Descripcion";
	public static final String C_PRECIO = "Precio";
	public static final String C_NUMERO_COPIAS = "Numero_copias";
	public static final String C_AUTOR = "Autor";
	public static final String C_GENERO = "Genero";
	public static final String C_IMAGEN = "Imagen";
	
	public static void guardarArchivoXml(Libro libro){
		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document archivo = documentBuilder.newDocument();

			Element cuerpo = archivo.createElement("Libros");
			archivo.appendChild(cuerpo);

			Attr atributos = archivo.createAttribute(C_ID);
			atributos.setValue(Integer.toString(libro.getId()));
			cuerpo.setAttributeNode(atributos);

			Element nombre = archivo.createElement(C_NOMBRE);
			nombre.appendChild(archivo.createTextNode(libro.getNombre()));				
			cuerpo.appendChild(nombre);

			Element descripcion = archivo.createElement(C_DESCRIPCION);
			descripcion.appendChild(archivo.createTextNode(libro.getDescripcion()));
			cuerpo.appendChild(descripcion);
			
			Element imagen = archivo.createElement(C_IMAGEN);
			imagen.appendChild(archivo.createTextNode(libro.getImagen()));
			cuerpo.appendChild(imagen);

			Element copias = archivo.createElement(C_NUMERO_COPIAS);
			copias.appendChild(archivo.createTextNode(Integer.toString(libro.getNumeroCopias())));
			cuerpo.appendChild(copias);
			
			Element valor = archivo.createElement(C_PRECIO);
			valor.appendChild(archivo.createTextNode(Double.toString(libro.getPrecio())));
			cuerpo.appendChild(valor);
			
			Element autor = archivo.createElement(C_AUTOR);
			autor.appendChild(archivo.createTextNode(libro.getAutor().toString()));
			cuerpo.appendChild(autor);
			
			Element genero = archivo.createElement(C_GENERO);
			genero.appendChild(archivo.createTextNode(libro.getTipoGenero().toString()));
			cuerpo.appendChild(genero);
			

			/**
			 * crear el archivo xml, transformar de DOM a xml
			 */
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(archivo);
			StreamResult resultado = new StreamResult(new File(RUTA_GUARDAR_XML + libro.getId() + "-" + libro.getNombre() + ".xml"));

			try {
				transformer.transform(domSource, resultado);
			} catch (TransformerException e) {
				JOptionPane.showMessageDialog(null, "Error al guardar el archivo Xml");
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
	}

	public static Libro cargarArchivoXml(File archivo){
		Libro libroCargar = null;
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document documento;
			try {
				documento = docBuilder.parse(archivo);
				documento.getDocumentElement().normalize();

				Element doc = documento.getDocumentElement();
				NodeList lista = doc.getChildNodes();
				
				libroCargar = new Libro(lista.item(0).getTextContent(), lista.item(1).getTextContent(),
						lista.item(6).getTextContent(), Integer.parseInt(lista.item(2).getTextContent()), Double.parseDouble(lista.item(3).getTextContent()),
						lista.item(4).getTextContent(), null);
				libroCargar.setId(Integer.parseInt(doc.getAttribute(C_ID)));
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		return libroCargar;
	}
}
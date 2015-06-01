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
	public int leerXmlLibros(){
		try {
		    DocumentBuilderFactory fábricaCreadorDocumento = DocumentBuilderFactory.newInstance();
		    DocumentBuilder creadorDocumento = fábricaCreadorDocumento.newDocumentBuilder();
		    Document documento = creadorDocumento.parse("src/data/libros.xml");
		    //Obtener el elemento raíz del documento
		    Element raiz = documento.getDocumentElement();

		    //Obtener la lista de nodos que tienen etiqueta "EMPLEADO"
		    NodeList listaEmpleados = raiz.getElementsByTagName("Libro");
		    libros = listaEmpleados.getLength();
		  
		    //Recorrer la lista de empleados
//		    for(int i=0; i<listaEmpleados.getLength(); i++) {   
//		        //Obtener de la lista un empleado tras otro
//		        Node empleado = listaEmpleados.item(i);
//		    
//		        
//		        System.out.println("Empleado "+i);
//		        System.out.println("==========");    
//
//		        //Obtener la lista de los datos que contiene ese empleado
//		        NodeList datosEmpleado = empleado.getChildNodes();
//		        //Recorrer la lista de los datos que contiene el empleado
//		        for(int j=0; j<datosEmpleado.getLength(); j++) {
//		           this.libros=j;
//		                 
//		        }
//		       
//		    }
		 
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
		// return libros;
	}

}

package persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import modelo.entidades.Autor;
import modelo.entidades.Libro;
import modelo.entidades.TipoGenero;

import org.xml.sax.SAXException;

import vista.ConstantesGUI;
import xml.analizador.dom.JespXML;
import xml.analizador.dom.modelo.Atributo;
import xml.analizador.dom.modelo.Encoding;
import xml.analizador.dom.modelo.Tag;


public class XmlLibro{

	public static void crearXml(ArrayList<Libro>listaLibro, String ruta) {
		for (Libro libros : listaLibro) {
		Tag libroT = new Tag("Libro");

		libroT.addAtributo(new Atributo("Titulo" ,  Integer.toString(listaLibro.size())));

		Tag id = new Tag("Id Libro");
		id.addContenido(Integer.toString(libros.getId()));;

		Tag nombre = new Tag("Titulo");
		nombre.addContenido(libros.getNombre());

		Tag descripcion = new Tag("Descripcion");
		descripcion.addContenido(libros.getDescripcion());

		Tag valor = new Tag("Valor");
		valor.addContenido(Double.toString(libros.getPrecio()));

		Tag copias = new Tag("Copias Vendidas");
		copias.addContenido(Integer.toString(libros.getNumeroCopias()));
		
		Tag autor = new Tag("Autor");
		autor.addContenido(libros.getNombreAutor());
		
		Tag genero = new Tag("Genero");
		genero.addContenido(libros.getTipoGenero());

		libroT.addTagHijo(id);
		libroT.addTagHijo(nombre);
		libroT.addTagHijo(descripcion);
		libroT.addTagHijo(valor);
		libroT.addTagHijo(copias);

		JespXML xml = new JespXML("/src/data/arraylibros.xml", Encoding.UTF_8);

		try {
			xml.escribirXML(libroT);

		} catch (TransformerConfigurationException e) {
			System.out.println(e.toString() +"en transformer Configuration");
		} catch (FileNotFoundException e) {
			System.out.println(e.toString() +"en ruta no eencontrada");
		} catch (ParserConfigurationException e) {
			System.out.println(e.toString() +"en parser configuration");
		} catch (TransformerException e) {
			System.out.println(e.toString() +"en transformer");
		}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static ArrayList<Libro> leerXML(String ruta){
		JespXML xml = new JespXML(ruta);
		ArrayList<Libro> lista = new ArrayList<>();
		try {
			Tag raiz = xml.leerXML();
		
			for(Tag libro : raiz.getTagsHijos()){
				
				/**Tag id = libro.getTagHijoByName("id");
				Tag nombre = libro.getTagHijoByName("nombre");
				Tag descripcion = libro.getTagHijoByName("descripcion");
				Tag valor = libro.getTagHijoByName("valor");
				Tag genero = libro.getTagHijoByName("genero");
				Tag autor = libro.getTagHijoByName("autor");
				Tag copias = libro.getTagHijoByName("copias");
				Tag pathImagenTag = libro.getTagHijoByName("rutaImagen");
				
				lista.add(new  Libro(nombre.getContenido(),descripcion.getContenido(),pathImagenTag.getContenido(),
						Integer.parseInt(valor.getContenido()),Double.parseDouble(valor.getContenido()),
						autor.getContenido(),genero.getContenido()
						));**/
			}
		} catch (ParserConfigurationException ex) {
			Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SAXException ex) {
			Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
		} /**catch (TagHijoNotFoundException ex) {
			Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
		}**/
		return lista;
	}
}


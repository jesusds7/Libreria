package persistencia;

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

import org.jespxml.JespXML;
import org.jespxml.excepciones.AtributoNotFoundException;
import org.jespxml.excepciones.TagHijoNotFoundException;
import org.jespxml.modelo.Atributo;
import org.jespxml.modelo.Comentario;
import org.jespxml.modelo.Encoding;
import org.jespxml.modelo.Tag;
import org.xml.sax.SAXException;


public class XmlLibro{

	private static Tag raiz;
	private static Tag libro;
	private static Tag id;
	private static Tag nombre;
	private static Tag descripcion;
	private static Tag valor;
	private static Tag genero;
	private static Tag autor;
	private static Tag copias;
	private static Tag pathImagen;

	public static void EscribirXML(ArrayList<Libro>  listaLibro, String ruta){
		raiz = new Tag("Libreria");
		raiz.addAtributo(new Atributo("Cantidad-Libro", Integer.toString(listaLibro.size())));
		raiz.addComentario(new Comentario("comentario :v"));
		for (Libro libros : listaLibro) {
			libro = new Tag("libro");
			id = new Tag("id");
			nombre = new Tag("nombre");
			descripcion = new Tag("descripcion");
			valor = new Tag("valor");
			genero = new Tag("genero");
			autor = new Tag("autor");
			copias = new Tag("copias");
			pathImagen = new Tag("rutaImagen");
			id.addContenido(Integer.toString(libros.getId()));
			nombre.addContenido(libros.getNombre());
			descripcion.addContenido(libros.getDescripcion());
			valor.addContenido(Double.toString(libros.getPrecio()));
			genero.addContenido(libros.getTipoGenero().toString());
			autor.addContenido(libros.getNombreAutor());
			copias.addContenido(Integer.toString(libros.getNumeroCopias()));
			pathImagen.addContenido(libros.getImagen());
			raiz.addTagHijo(libro);
			libro.addTagHijo(id);
			libro.addTagHijo(nombre);
			libro.addTagHijo(descripcion);
			libro.addTagHijo(valor);
			libro.addTagHijo(genero);
			libro.addTagHijo(autor);
			libro.addTagHijo(copias);
			libro.addTagHijo(pathImagen);

			JespXML xml = new JespXML(ruta, Encoding.UTF_8);
			try {
				xml.escribirXML(raiz);
			} catch (ParserConfigurationException ex) {
				Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
			} catch (TransformerConfigurationException ex) {
				Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
			} catch (FileNotFoundException ex) {
				Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
			} catch (TransformerException ex) {
				Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
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
				
				Tag id = libro.getTagHijoByName("id");
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
						));
			}
		} catch (ParserConfigurationException ex) {
			Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SAXException ex) {
			Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
		} catch (TagHijoNotFoundException ex) {
			Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
		}
		return lista;
	}
}


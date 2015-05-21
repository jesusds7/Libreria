package modelo.util;

import modelo.entidades.Autor;
import modelo.entidades.Cliente;
import modelo.entidades.Libro;
import modelo.entidades.TipoGenero;
/**
 * @author JESUS
 */
public class Util {

	public static boolean validarDinero(String numero) {
		try {
			Double.parseDouble(numero);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static String[] sitioAVector(Libro  libro, TipoGenero genero){
		return new String[]{Integer.toString( libro.getId()),  libro.getNombre(),  libro.getDescripcion(),
				Double.toString(libro.getPrecio()), Integer.toString(libro.getNumeroCopias()),
				libro.getNombreAutor(), genero.toString() };
	}
	
	public static String[] sitioAVectorAutor(Autor autor){
		return new String[]{Integer.toString( autor.getId()),  autor.getNombre()};
	}
	
	public static String[] sitioAVectorCliente(Cliente cliente){
		return new String[]{Integer.toString( cliente.getId()),  cliente.getNombre(), Double.toString(cliente.getDinero())};
	}
}

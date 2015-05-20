package modelo.util;

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
				libro.getImagen(), Integer.toString(libro.getNumeroCopias()), Double.toString(libro.getPrecio()),
				libro.getNombreAutor(), genero.toString() };
	}
}

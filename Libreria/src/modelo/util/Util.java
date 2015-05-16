package modelo.util;

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

}

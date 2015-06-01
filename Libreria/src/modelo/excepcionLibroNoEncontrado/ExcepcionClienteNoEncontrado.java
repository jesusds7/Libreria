package modelo.excepcionLibroNoEncontrado;

import javax.swing.JOptionPane;

public class ExcepcionClienteNoEncontrado extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String ERROR_CLIENTE_NO_ENCONTRADO = "El cliente que intenta buscar no se encuentra";

	public ExcepcionClienteNoEncontrado(String nombreCliente) {
		super(ERROR_CLIENTE_NO_ENCONTRADO + "-" + nombreCliente + "-");
		JOptionPane.showMessageDialog(null, "No encontrado");
	}

	public ExcepcionClienteNoEncontrado(int id) {
		super(ERROR_CLIENTE_NO_ENCONTRADO + "-" + id + "-");
	}
}
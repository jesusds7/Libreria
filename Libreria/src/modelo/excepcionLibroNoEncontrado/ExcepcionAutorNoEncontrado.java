package modelo.excepcionLibroNoEncontrado;

public class ExcepcionAutorNoEncontrado extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ERROR_AUTOR_NO_ENCONTRADO = "El autor que intenta buscar no se encuentra";

	public ExcepcionAutorNoEncontrado(String nombreAutor) {
		super(ERROR_AUTOR_NO_ENCONTRADO + "-" + nombreAutor + "-");
	}

	public ExcepcionAutorNoEncontrado(int id) {
		super(ERROR_AUTOR_NO_ENCONTRADO + "-" + id + "-");
	}
}
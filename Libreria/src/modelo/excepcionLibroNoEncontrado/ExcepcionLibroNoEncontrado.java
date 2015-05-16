package modelo.excepcionLibroNoEncontrado;

public class ExcepcionLibroNoEncontrado extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ERROR_LIBRO_NO_ENCONTRADO = "El libro que intenta buscar no se encuentra";

	public ExcepcionLibroNoEncontrado(String nombreLibro) {
		super(ERROR_LIBRO_NO_ENCONTRADO + "-" + nombreLibro + "-");
	}

	public ExcepcionLibroNoEncontrado(int id) {
		super(ERROR_LIBRO_NO_ENCONTRADO + "-" + id + "-");
	}
}

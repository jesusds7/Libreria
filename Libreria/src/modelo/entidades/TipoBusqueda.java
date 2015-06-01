package modelo.entidades;

public enum TipoBusqueda {
	SELECION_OPCION("Seleccione Opción"),
	LIBRO_NOMBRE("Nombre libro"),
	LIBRO_ID("Id libro"),
	CLIENTE_NOMBRE("Nombre cliente"),
	CLIENTE_ID("Id Cliente"),
	AUTOR_NOMBRE("Nombre Autor"),
	AUTOR_ID("Id Autor");

	private String busqueda;

	private TipoBusqueda(String busqueda) {
		this.busqueda = busqueda;
	}

	@Override
	public String toString() {
		return busqueda;
	}

	public String getBusqueda() {
		return busqueda;
	}
}
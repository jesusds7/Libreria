package modelo.entidades;

public enum TipoBusqueda {
	SELLECION_OPCION("Seleccione Opción"),
	LIBRO_NOMBRE("Nombre libro"),
	LIBRO_ID("Id libro"),
	CLIENTE_NOMBRE("Nombre cliente"),
	CLIENTE_ID("Id Cliente"),
	AUTHOR_NOMBRE("Nombre Autor"),
	AUTHOR_ID("Id Autor");

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

package modelo.entidades;

public enum TipoGenero {
	ACCION ("Accion"), 
	AVENTURA ("Aventura"),
	CIENTIFICO("Cientifico"),
	INFANTIL("Infantil"),
	TERROR("Terror");
	
	private String genero;

	private TipoGenero(String genero) {
		this.setGenero(genero);
	}
	
	@Override
	public String toString() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
}

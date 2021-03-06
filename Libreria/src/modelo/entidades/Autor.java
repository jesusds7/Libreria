package modelo.entidades;

public class Autor {
	private int id;
	private static int consecutivo;
	private String imagen;
	private String nombre;

	public Autor(String nombre) {
		this.id = consecutivo;
		this.nombre = nombre;
		consecutivo++;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}
}
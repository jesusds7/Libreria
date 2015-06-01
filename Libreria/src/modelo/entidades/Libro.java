package modelo.entidades;

import java.io.Serializable;

public class Libro implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String descripcion;
	private int id;
	private String imagen;
	private int numeroCopias;
	private double precio;
	private Autor autor;
	private String nombreAutor;
	private String tipoGenero;
	private static int consecutivo;


	public Libro(String nombre, String descripcion, String imagen, int numeroCopias,
			double precio, String autor, String tipoGenero) {
		super();
		this.setNombre(nombre);
		this.descripcion = descripcion;
		this.id = consecutivo;
		this.imagen = imagen;
		this.numeroCopias = numeroCopias;
		this.precio = precio;
		this.nombreAutor = autor;
		this.tipoGenero = tipoGenero;
		consecutivo++;
	}

	@Override
	public String toString() {
		return id + "," + nombre + "," + descripcion + "," + imagen + "," + numeroCopias + ","
				+ precio + "," + autor + "," + tipoGenero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public int getNumeroCopias() {
		return numeroCopias;
	}

	public void setNumeroCopias(int numeroCopias) {
		this.numeroCopias = numeroCopias;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	

	public String getTipoGenero() {
		return tipoGenero;
	}

	public void setTipoGenero(String tipoGenero) {
		this.tipoGenero = tipoGenero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}
}
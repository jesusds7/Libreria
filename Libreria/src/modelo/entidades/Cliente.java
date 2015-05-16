package modelo.entidades;

/** 
 * @author JESUS
 */

public class Cliente {
	
	private String nombre;
	private double dinero;
	private int id;
	private static int consecutivo;	

	public Cliente(String nombre, double dinero) {
		super();
		this.id = consecutivo;
		consecutivo++;
		this.nombre = nombre;
		this.dinero = dinero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getDinero() {
		return dinero;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	

}

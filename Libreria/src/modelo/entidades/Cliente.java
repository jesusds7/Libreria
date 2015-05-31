package modelo.entidades;
/** 
 * @author JESUS
 */
public class Cliente {
	private int id;
	private String nombre;
	private double dinero;
	private static int consecutivo;

	public Cliente(String nombre, double dinero) {
		super();
		this.id = consecutivo;
		this.nombre = nombre;
		this.dinero = dinero;
		consecutivo++;
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
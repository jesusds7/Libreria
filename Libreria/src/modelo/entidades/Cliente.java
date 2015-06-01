package modelo.entidades;


/** 
 * @author JESUS
 */
public class Cliente {
	private String nombre;
	private double dinero;
	private String usuario;
	private String contrasenia;
	private int id;
	private static int consecutivo;

	public Cliente(String nombre, double dinero, String usuario, String contrasenia) {
		super();
		this.id = consecutivo;
		this.nombre = nombre;
		this.dinero = dinero;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
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

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}

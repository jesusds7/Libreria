package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import modelo.dao.GestorAutor;
import modelo.dao.GestorLibro;
import modelo.entidades.Libro;
import modelo.entidades.TipoGenero;
import vista.DialogoAgregarLibro;
import vista.DialogoInicio;
import vista.VentanaAdministrador;
import vista.VentanaUsuario;

public class Controlador extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String A_BTN_DIALOGO_ADMINISTRADOR = "DIALOGO_ADMINISTRADOR";
	public static final String A_MOSTAR_AGREGAR_LIBRO = "A_MOSTRAR_AGREGAR_LIBRO";
	public static final String A_REMOVER_LIBRO = "REMOVER_LIBRO";
	public static final String A_MOSTAR_EDITAR_LIBRO = "EDITAR_LIBRO";
	public static final String A_BUSCAR_LIBRO = "BUSCAR_LIBRO";
	public static final String A_BUSCAR_NOMBRE_LIBRO = "RADIO_LIBRO";
	public static final String A_BUSCAR_ID_LIBRO = "RADIO_ID_LIBRO";
	public static final String A_BUSCAR_NOMBRE_USUARIO = "RADIO_USUARIO";
	public static final String A_BUSCAR_ID_USUARIO = "RADIO_ID_USUARIO";
	public static final String A_COMPRAR_LIBRO = "COMPRAR_LIBRO";
	public static final String A_BTN_DIALOGO_USUARIO = "VENTANA USARIO";
	public static final String A_AGREGAR_IMAGEN = "Agregar_imagen";
	public static final String A_CANCELAR_LIBRO = "CANCELAR_LIBRO";
	public static final String A_AGREGAR_LIBRO = "ACCION_AGREGAR_LIBRO";
	public static final String A_MOSTRAR_DIALOGO_AGREGAR_LIBRO = "ACCION_MOSTAR_AGREGAR_LIBRO";
	public static final String A_SALIR = "SALIR";
	private VentanaAdministrador ventanaAdministrador;
	private DialogoInicio dialogoPrimario;
	private DialogoAgregarLibro dialogoAgregarLibro;
	private VentanaUsuario ventanaUsuario;
	private GestorLibro gestorLibro;
	
	
	public Controlador() {
		dialogoPrimario = new DialogoInicio(this);
		dialogoAgregarLibro = new DialogoAgregarLibro(ventanaAdministrador, this);
		ventanaAdministrador = new VentanaAdministrador(this);
		ventanaUsuario = new VentanaUsuario(this);
		dialogoPrimario.setVisible(true);
	}
	
	public static void main(String[] args) {
		Controlador controlador = new Controlador();
		controlador.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case A_BTN_DIALOGO_ADMINISTRADOR:
			ventanaAdministrador.setVisible(true);
			break;
		case A_BTN_DIALOGO_USUARIO:
			ventanaUsuario.setVisible(true);
			break;
		case A_MOSTRAR_DIALOGO_AGREGAR_LIBRO:
			dialogoAgregarLibro.setVisible(true);
			break;
		case A_AGREGAR_IMAGEN:
			dialogoAgregarLibro.obtenerRutaImagen();
			break;
		case A_CANCELAR_LIBRO:
			dialogoAgregarLibro.cancelar();
			break;
		case A_SALIR:
			ventanaAdministrador.setVisible(false);
			break;
		case A_AGREGAR_LIBRO:
			agregarLibro();
			break;
		default:
			break;
		}
	}
	
	public void agregarLibro(){
		TipoGenero genero = TipoGenero.ACCION;
		Libro libro = dialogoAgregarLibro.crearLibro();
		crearLibro(libro, genero);
	}
	
	private void crearLibro(Libro libro, TipoGenero genero){
		if(libro != null){
			gestorLibro.agregarLibro(libro);
			ventanaAdministrador.agregarLibroTabla(libro, genero);
		}
	}
}

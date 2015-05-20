package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import vista.DialogoInicio;
import vista.VentanaAdministrador;
import vista.VentanaUsuario;

public class Controlador extends JPanel implements ActionListener {
	
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
	
	private VentanaAdministrador ventanaAdministrador;
	private DialogoInicio dialogoPrimario;
	
	private VentanaUsuario ventanaUsuario;
	
	
	public Controlador() {
		dialogoPrimario = new DialogoInicio(this);
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
		default:
			break;
		}
	}

}

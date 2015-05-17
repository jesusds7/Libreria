package controlador;

import javax.swing.JPanel;

import vista.VentanaPrincipal;

public class Controlador extends JPanel {
	private VentanaPrincipal ventanaPrincipal;
	
	public Controlador() {
		ventanaPrincipal = new VentanaPrincipal(this);
		ventanaPrincipal.setVisible(true);
	}
	
	public static void main(String[] args) {
		Controlador controlador = new Controlador();
		controlador.setVisible(true);
	}

}

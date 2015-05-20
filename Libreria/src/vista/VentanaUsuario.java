package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controlador.Controlador;

public class VentanaUsuario extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private BarraHerramientasUs barraHerramientas;
	private BarraMenuUs barraMenu;
	
	public VentanaUsuario(Controlador controlador) {
		
		this.setTitle(ConstantesGUI.T_VENTANA_USUARIO);
		this.setLayout(new BorderLayout());
		this.setSize(ConstantesGUI.VENTANA_ANCHO, ConstantesGUI.VENTANA_ALTO);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		barraMenu = new BarraMenuUs(controlador);
		setJMenuBar(barraMenu);

		barraHerramientas = new BarraHerramientasUs(controlador);
		add(barraHerramientas, BorderLayout.PAGE_START);
	}

}

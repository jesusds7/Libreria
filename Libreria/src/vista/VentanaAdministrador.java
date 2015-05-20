package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;


import controlador.Controlador;

public class VentanaAdministrador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BarraHerramientasAdm barraHerramientas;
	private BarraMenuAdm barraMenu;

	public VentanaAdministrador(Controlador controlador) {
		setTitle(ConstantesGUI.T_TITULO_VENTANA);
		setLayout(new BorderLayout());
		setSize(ConstantesGUI.VENTANA_ALTO,ConstantesGUI.VENTANA_ANCHO);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		barraMenu = new BarraMenuAdm(controlador);
		setJMenuBar(barraMenu);	

		barraHerramientas = new BarraHerramientasAdm(controlador);
		add(barraHerramientas, BorderLayout.PAGE_START);
	}
}

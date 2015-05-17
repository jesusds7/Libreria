package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;


import controlador.Controlador;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BarraHerramientas barraHerramientas;
	private BarraMenu barraMenu;
	
	public VentanaPrincipal(Controlador controlador) {
		setTitle(ConstantesGUI.T_TITULO_VENTANA);
		setLayout(new BorderLayout());
		setSize(ConstantesGUI.VENTANA_ALTO,ConstantesGUI.VENTANA_ANCHO);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		barraMenu = new BarraMenu(controlador);
		setJMenuBar(barraMenu);	
		
		barraHerramientas = new BarraHerramientas(controlador);
		add(barraHerramientas, BorderLayout.PAGE_START);
		
		
		
	}

}

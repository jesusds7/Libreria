package vista;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

import controlador.Controlador;

public class BarraHerramientasUs extends JToolBar{
	
	private static final long serialVersionUID = 1L;
	
	private ImageIcon imgComprar;
	private ImageIcon imgBuscar;
	
	private JButton btnComprar;
	private JButton btnBuscar;
	
	private JRadioButton rBtnNombre;
	private JRadioButton rBtnId;
	private ButtonGroup grBuscar;
	

	public BarraHerramientasUs(Controlador controlador) {
		
		this.setFloatable(false);
		this.setRollover(true);
		
		imgComprar = new ImageIcon("ruta");
			
		btnComprar = new JButton(imgComprar);
		btnComprar.setActionCommand(Controlador.A_COMPRAR_LIBRO);
		btnComprar.addActionListener(controlador);
		btnComprar.setFocusable(false);
		btnComprar.setOpaque(false);
		btnComprar.setContentAreaFilled(false);
		btnComprar.setBorderPainted(false);
		add(btnComprar);
		

	}

}

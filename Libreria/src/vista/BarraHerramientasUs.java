package vista;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
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

	private JTextField txtBuscar;
	

	public BarraHerramientasUs(Controlador controlador) {
		
		this.setFloatable(false);
		this.setRollover(true);
		
		imgComprar = new ImageIcon(ConstantesGUI.IMG_COMPRAR_LIBRO);
			
		btnComprar = new JButton(imgComprar);
		btnComprar.setActionCommand(Controlador.A_COMPRAR_LIBRO);
		btnComprar.addActionListener(controlador);
		btnComprar.setFocusable(false);
		btnComprar.setOpaque(false);
		btnComprar.setContentAreaFilled(false);
		btnComprar.setBorderPainted(false);
		add(btnComprar);
		
		grBuscar = new ButtonGroup();

		rBtnNombre = new JRadioButton();
		rBtnNombre.setText(ConstantesGUI.RBTN_BUSCAR_NOMBRE);
		rBtnNombre.setFocusable(false);
		rBtnNombre.setOpaque(false);
		rBtnNombre.setContentAreaFilled(false);
		rBtnNombre.setBorderPainted(false);
		grBuscar.add(rBtnNombre);
		add(rBtnNombre);

		rBtnId = new JRadioButton();
		rBtnId.setText(ConstantesGUI.RBTN_BUSCAR_ID);
		rBtnId.setFocusable(false);
		rBtnId.setOpaque(false);
		rBtnId.setContentAreaFilled(false);
		rBtnId.setBorderPainted(false);
		grBuscar.add(rBtnId);
		add(rBtnId);

		txtBuscar = new JTextField();
		txtBuscar.setVisible(true);
		add(txtBuscar);
		
		imgBuscar = new ImageIcon(ConstantesGUI.IMG_BUSCAR_LIBRO);
		
		btnBuscar = new JButton(imgBuscar);
		btnBuscar.setActionCommand(Controlador.A_BUSCAR_LIBRO);
		btnBuscar.addActionListener(controlador);
		btnBuscar.setFocusable(false);
		btnBuscar.setOpaque(false);
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setBorderPainted(false);
		add(btnBuscar);
		

	}

}

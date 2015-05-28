package vista;

import javax.swing.ButtonGroup;
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
	private JRadioButton rBtnAutor;
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
		rBtnNombre.addActionListener(controlador);
		rBtnNombre.setActionCommand(Controlador.A_RDBUTTON_FILTRAR_TITULO);
		grBuscar.add(rBtnNombre);
		add(rBtnNombre);

		rBtnAutor = new JRadioButton();
		rBtnAutor.setText(ConstantesGUI.RBTN_BUSCAR_ID);
		rBtnAutor.setFocusable(false);
		rBtnAutor.setOpaque(false);
		rBtnAutor.setContentAreaFilled(false);
		rBtnAutor.setBorderPainted(false);
		rBtnAutor.addActionListener(controlador);
		rBtnAutor.setActionCommand(Controlador.A_RDBUTTON_FILTRAR_AUTOR);
		grBuscar.add(rBtnAutor);
		add(rBtnAutor);

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

	public JTextField getTxtBuscar() {
		return txtBuscar;
	}

	public void setTxtBuscar(JTextField txtBuscar) {
		this.txtBuscar = txtBuscar;
	}
}

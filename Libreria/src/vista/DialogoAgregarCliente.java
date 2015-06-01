package vista;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import modelo.entidades.Cliente;
import controlador.Controlador;

public class DialogoAgregarCliente extends JDialog{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtDinero;
	private JLabel labelPassword;
	private JPasswordField password;
	private JLabel lbNombre;
	protected JButton btnCrearCliente;
	private JButton btnCancelar;
	private JLabel lbDinero;
	private JLabel lbNick;
	private JTextField txContrasenia;

	public DialogoAgregarCliente(VentanaAdministrador administrador, Controlador controlador) {
		super(administrador);
		UIManager.put("TextField.font", new Font("Arial", Font.BOLD, 15));
		UIManager.put("TextArea.font", new Font("Arial", Font.BOLD, 15));
		setLayout(new GridBagLayout());
		setTitle("Ingresar Datos Cliente");
		setSize(600,350);
		setLocationRelativeTo(null);
		setModal(true);
		setIconImage(createImageIcon(ConstantesGUI.IMG_ICONO_LIBRO).getImage());

		GridBagConstraints cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.CENTER;
		
		lbNombre = new JLabel(ConstantesGUI.T_LABEL_NOMBRE);
		cons.gridx = 1;
		cons.gridy = 0;
		cons.weightx = 0.5;
		cons.weighty = 0.5;
		add(lbNombre, cons);

		txtNombre = new JTextField(10);
		cons.gridx = 1;
		cons.gridy = 0;
		cons.weightx = 0.5;
		cons.weighty = 0.5;
		add(txtNombre, cons);
		
		lbDinero = new JLabel(ConstantesGUI.T_LABEL_DINERO);

		labelPassword = new JLabel(ConstantesGUI.T_LABEL_PASSWORD);
		cons.gridx = 0;
		cons.gridy = 1;
		add(labelPassword, cons);

		password = new JPasswordField(20);
		cons.gridx=1;
		cons.gridy=1;
		add(password, cons);


		lbDinero = new JLabel(ConstantesGUI.T_LABEL_DINERO);
		cons.gridx = 0 ;
		cons.gridy = 2;
		add(lbDinero, cons);
		
		txtDinero = new JTextField(10);
		cons.gridx = 2;
		cons.gridy = 2;
		add(txtDinero, cons);

		btnCancelar = new JButton(ConstantesGUI.T_BTN_CANCELAR);
		btnCancelar.addActionListener(controlador);
		btnCancelar.setActionCommand(Controlador.A_CANCELAR_CLIENTE);
		cons.gridx = 0;
		cons.gridy = 3;
		cons.insets = new Insets(0, 100, 0, 0);
		add(btnCancelar, cons);

		btnCrearCliente = new JButton(ConstantesGUI.T_BTN_CREAR);
		cons.gridx = 3;
		cons.gridy = 3;
		cons.insets = new Insets(0, 0, 0, 100);
		btnCrearCliente.addActionListener(controlador);
		btnCrearCliente.setActionCommand(Controlador.A_AGREGAR_CLIENTE);
		add(btnCrearCliente, cons);
	}
	
	public Cliente crearCliente(){
		Cliente cliente = new Cliente(txtNombre.getText(), Double.parseDouble(txtDinero.getText()), "nombre usuario", "contrasenia");
		dispose();
		cancelar();
		return cliente;
	}

	public void cancelar(){
		txtNombre.setText("");
		txtDinero.setText("");
		dispose();
	}
	
	protected ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			return null;
		}
	}
}

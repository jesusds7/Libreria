package vista;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
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
	private JLabel lbNombre;
	protected JButton btnCrearCliente;
	private JButton btnCancelar;
	private JLabel lbDinero;

	public DialogoAgregarCliente(VentanaAdministrador administrador, Controlador controlador) {
		super(administrador);
		UIManager.put("TextField.font", new Font("Arial", Font.BOLD, 15));
		UIManager.put("TextArea.font", new Font("Arial", Font.BOLD, 15));
		setLayout(new GridBagLayout());
		setTitle("Ingresar Datos Cliente");
		setSize(ConstantesGUI.VENTANA_ANCHO, ConstantesGUI.VENTANA_ALTO);
		setLocationRelativeTo(null);
		setModal(true);
		setIconImage(createImageIcon(ConstantesGUI.IMG_ICONO_LIBRO).getImage());

		GridBagConstraints cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.CENTER;
		
		lbNombre = new JLabel(ConstantesGUI.T_LABEL_NOMBRE);
		cons.gridx = 0;
		cons.gridy = 0;
		cons.weightx = 0.5;
		cons.weighty = 0.5;
		add(lbNombre, cons);

		txtNombre = new JTextField(10);
		cons.gridx = 1;
		cons.gridy = 0;
		add(txtNombre, cons);
		
		lbDinero = new JLabel(ConstantesGUI.T_LABEL_DINERO);
		cons.gridx = 0;
		cons.gridy = 1;
		add(lbDinero, cons);
		
		txtDinero = new JTextField(10);
		cons.gridx = 1;
		cons.gridy = 1;
		cons.insets = new Insets(0, 0, 0, 0);
		add(txtDinero, cons);
		

		btnCancelar = new JButton(ConstantesGUI.T_BTN_CANCELAR);
		btnCancelar.addActionListener(controlador);
		btnCancelar.setActionCommand(Controlador.A_CANCELAR_CLIENTE);
		cons.gridx = 0;
		cons.gridy = 2;
		cons.insets = new Insets(0, 100, 0, 0);
		add(btnCancelar, cons);

		btnCrearCliente = new JButton(ConstantesGUI.T_BTN_CREAR);
		cons.gridx = 1;
		cons.gridy = 2;
		cons.insets = new Insets(0, 0, 0, 100);
		btnCrearCliente.addActionListener(controlador);
		btnCrearCliente.setActionCommand(Controlador.A_AGREGAR_CLIENTE);
		add(btnCrearCliente, cons);
	}
	
	public Cliente crearCliente(){
		Cliente cliente = new Cliente(txtNombre.getText(), Double.parseDouble(txtDinero.getText()));
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

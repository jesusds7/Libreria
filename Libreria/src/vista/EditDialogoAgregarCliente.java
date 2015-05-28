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

public class EditDialogoAgregarCliente extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtDinero;
	private JLabel lbNombre;
	protected JButton btnEditarCliente;
	private JButton btnCancelar;
	private JLabel lbDinero;
	public EditDialogoAgregarCliente(VentanaAdministrador administrador, Controlador controlador) {
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

		btnEditarCliente = new JButton(ConstantesGUI.T_MENU_ITEM_EDITAR_CLIENTE);
		cons.gridx = 1;
		cons.gridy = 2;
		cons.insets = new Insets(0, 0, 0, 100);
		btnEditarCliente.addActionListener(controlador);
		btnEditarCliente.setActionCommand(Controlador.A_EDITAR_CLIENTE);
		add(btnEditarCliente, cons);
	}

	public Cliente  editarCliente(Cliente cliente){
		cliente.setNombre(txtNombre.getText());
		cliente.setDinero(Double.parseDouble(txtDinero.getText()));
		cancelar();
		dispose();
		return cliente;	
	}

	public void cambiarValores(Cliente cliente){
		txtNombre.setText(cliente.getNombre());
		txtDinero.setText(Double.toString(cliente.getDinero()));
	}

	public void cancelar(){
		txtNombre.setText("");
		txtDinero.setText("");
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

package vista;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controlador.Controlador;

public class DialogoLoginUsuario extends JDialog {

	/**
	 * @author Ruth Rojas
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labelEncabezado;
	private JButton btnIngresar;
	private JButton btnCancelar;
	private JPanel panelBotones;
	private JLabel labelNombre;
	private JLabel labelContrasenia;
	private JTextField textFielNombre;
	private JPasswordField textFielContrasenia;
	private JPanel panelCampos;

	public DialogoLoginUsuario(Controlador controlador) {
		this.setTitle(ConstantesGUI.TITLE_LOGIN_USER);
		this.setSize(ConstantesGUI.VENTANA_ANCHO_PRIMARIA,ConstantesGUI.VENTANA_USUARIO_ALTO);
		this.setIconImage(createImageIcon(ConstantesGUI.IMG_ICONO_LIBRO).getImage());
		this.setLocationRelativeTo(null);
		
		GridBagConstraints gb = new GridBagConstraints();
		gb.fill = GridBagConstraints.BOTH;
		gb.insets = new Insets(1, 2, 5, 5);

		labelEncabezado = new JLabel();
		add(labelEncabezado);
		
		panelCampos = new JPanel();
		gb.gridx = 0;
		gb.gridy = 4;
		panelCampos.setLayout(new GridBagLayout());

		labelNombre = new JLabel();
		labelNombre.setText(ConstantesGUI.LBL_NAME_LOGIN_USER);
		gb.gridx = 0;
		gb.gridy = 1;
		panelCampos.add(labelNombre);

		textFielNombre = new JTextField(20);
		gb.gridx = 1;
		gb.gridy = 0;
		panelCampos.add(textFielNombre, gb);


		labelContrasenia = new JLabel();
		labelContrasenia.setText(ConstantesGUI.LBL_PASSWORD_LOGIN_USER);
		gb.gridx = 0;
		gb.gridy = 1;
		panelCampos.add(labelContrasenia, gb);

		textFielContrasenia = new JPasswordField(20);
		gb.gridx = 1;
		gb.gridy = 1;
		panelCampos.add(textFielContrasenia, gb);

		add(panelCampos);

		btnIngresar = new JButton();
		btnIngresar.setText(ConstantesGUI.BTN_INGRESAR_LOGIN_USER);
		btnIngresar.addActionListener(controlador);
		btnIngresar.setActionCommand(Controlador.AC_BTN_VERIFICAR_Y_ENTRAR_POR_USUARIO);

		btnCancelar = new JButton();
		btnCancelar.setText(ConstantesGUI.BTN_CANCELAR_LOGIN_USER);
		btnCancelar.addActionListener(controlador);
		btnCancelar.setActionCommand(Controlador.AC_BTN_CANCELAR_DIALOGO);

		panelBotones = new JPanel();
		panelBotones.add(btnIngresar);
		panelBotones.add(btnCancelar);
		add(panelBotones, BorderLayout.SOUTH);
	}

	protected ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			return null;
		}
	}
	public JTextField getTextFielNombre() {
		return textFielNombre;
	}

	public void setTextFielNombre(JTextField textFielNombre) {
		this.textFielNombre = textFielNombre;
	}

	public JPasswordField getTextFielContrasenia() {
		return textFielContrasenia;
	}

	public void setTextFielContrasenia(JPasswordField textFielContrasenia) {
		this.textFielContrasenia = textFielContrasenia;
	}
}

package vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import controlador.Controlador;

public class DialogoPrimario extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnAdministrador;
	private JButton btnusuario;

	public DialogoPrimario(Controlador controlador) {
		setLayout(new GridBagLayout());
		setTitle(ConstantesGUI.T_TITULO_VENTANA);
		setSize(ConstantesGUI.VENTANA_ANCHO_PRIMARIA, ConstantesGUI.VENTANA_ALTO_PRIMARIA);
		setLocationRelativeTo(null);
		setResizable(false);

		GridBagConstraints cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.CENTER;

		btnAdministrador = new JButton(ConstantesGUI.T_BTN_ADMINISTRADOR);
		cons.gridx = 0;
		cons.gridy = 0;
		cons.weightx = 0.5;
		cons.weighty = 0.5;
		btnAdministrador.addActionListener(controlador);
		btnAdministrador.setActionCommand(Controlador.A_BTN_DIALOGO_ADMINISTRADOR);
		add(btnAdministrador, cons);

		btnusuario = new JButton(ConstantesGUI.T_BTN_USUARIO);
		cons.gridx = 1;
		cons.gridy = 0;
		cons.weightx = 0.6;
		cons.weighty = 0.6;
		add(btnusuario, cons);		
	}
}

package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.UIManager;

import controlador.Controlador;

public class DialogoInicio extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btnAdministrador;
	private JButton btnUsuario;

	private ImageIcon imgAdministrador;
	private ImageIcon imgUsuario;
	
	
	public DialogoInicio(Controlador controlador) {
		
		UIManager.put("Button.font", new Font(null, 5, 14));
			
		setLayout(new BorderLayout());
		setTitle(ConstantesGUI.T_TITULO_VENTANA);
		setSize(ConstantesGUI.VENTANA_ANCHO_PRIMARIA, ConstantesGUI.VENTANA_ALTO_PRIMARIA);
		setLocationRelativeTo(null);
		setResizable(false);

		imgAdministrador = new ImageIcon(ConstantesGUI.IMG_ADMINISTRADOR);
		
		btnAdministrador = new JButton(imgAdministrador);
		btnAdministrador.setText("Administrador");
		btnAdministrador.setFocusable(false);
		btnAdministrador.setOpaque(false);
		btnAdministrador.setContentAreaFilled(false);
		btnAdministrador.setBorderPainted(false);
		btnAdministrador.addActionListener(controlador);
		btnAdministrador.setActionCommand(Controlador.A_BTN_DIALOGO_ADMINISTRADOR);
		btnAdministrador.setVisible(true);
		add(btnAdministrador,BorderLayout.WEST );

		imgUsuario = new ImageIcon(ConstantesGUI.IMG_USUARIO);
		
		btnUsuario = new JButton(imgUsuario);
		btnUsuario.setText("Usuario");
		btnUsuario.setFocusable(false);
		btnUsuario.setOpaque(false);
		btnUsuario.setContentAreaFilled(false);
		btnUsuario.setBorderPainted(false);
		btnUsuario.addActionListener(controlador);
		btnUsuario.setActionCommand(Controlador.A_BTN_DIALOGO_USUARIO);
		add(btnUsuario, BorderLayout.EAST);		
	}
	

}

package vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

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
			
		setLayout(new GridBagLayout());
		setTitle(ConstantesGUI.T_TITULO_VENTANA);
		setSize(ConstantesGUI.VENTANA_ANCHO_PRIMARIA, ConstantesGUI.VENTANA_ALTO_PRIMARIA);
		setLocationRelativeTo(null);
		setResizable(false);

		GridBagConstraints cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.CENTER;
		
//		JPanelFondo panelFondo = new JPanelFondo("src/imagenes/fondodialogoinicio.jpg");
//		cons.weightx = 10;
//		cons.weighty = 10;
//		add(panelFondo, cons);

		imgAdministrador = new ImageIcon(ConstantesGUI.IMG_ADMINISTRADOR);
		
		btnAdministrador = new JButton(imgAdministrador);
		btnAdministrador.setFocusable(false);
		btnAdministrador.setOpaque(false);
		btnAdministrador.setContentAreaFilled(false);
		btnAdministrador.setBorderPainted(false);
		cons.gridx = 0;
		cons.gridy = 0;
		cons.weightx = 0.5;
		cons.weighty = 0.5;
		btnAdministrador.addActionListener(controlador);
		btnAdministrador.setActionCommand(Controlador.A_BTN_DIALOGO_ADMINISTRADOR);
		add(btnAdministrador, cons);

		imgUsuario = new ImageIcon(ConstantesGUI.IMG_USUARIO);
		
		btnUsuario = new JButton(imgUsuario);
		btnUsuario.setFocusable(false);
		btnUsuario.setOpaque(false);
		btnUsuario.setContentAreaFilled(false);
		btnUsuario.setBorderPainted(false);
		cons.gridx = 1;
		cons.gridy = 0;
		cons.weightx = 0.6;
		cons.weighty = 0.6;
		btnUsuario.addActionListener(controlador);
		btnUsuario.setActionCommand(Controlador.A_BTN_DIALOGO_USUARIO);
		add(btnUsuario, cons);		
	}
}

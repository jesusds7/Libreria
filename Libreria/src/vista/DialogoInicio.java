package vista;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;

import controlador.Controlador;

public class DialogoInicio extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton btnAdministrador;
	private JButton btnUsuario;
	private Image imagenFondo;
	private ImageIcon imgAdministrador;
	private ImageIcon imgUsuario;


	public DialogoInicio(Controlador controlador) {

		UIManager.put("Button.font", new Font(null, 5, 14));

		setLayout(new GridBagLayout());
		setTitle(ConstantesGUI.T_TITULO_VENTANA);
		setSize(ConstantesGUI.VENTANA_ANCHO_PRIMARIA, ConstantesGUI.VENTANA_ALTO_PRIMARIA);
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(createImageIcon(ConstantesGUI.IMG_ICONO_LIBRO).getImage());
		imagenFondo = new ImageIcon("src/imagenes/lib.jpg").getImage();
		imgAdministrador = new ImageIcon(ConstantesGUI.IMG_ADMINISTRADOR);
		imgUsuario = new ImageIcon(ConstantesGUI.IMG_USUARIO);
		
		GridBagConstraints cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.CENTER;
		
		btnAdministrador = new JButton(imgAdministrador);
		btnAdministrador.setText("Administrador");
		btnAdministrador.setFocusable(false);
		btnAdministrador.setOpaque(false);
		btnAdministrador.setContentAreaFilled(false);
		btnAdministrador.setBorderPainted(false);
		btnAdministrador.addActionListener(controlador);
		btnAdministrador.setActionCommand(Controlador.A_BTN_DIALOGO_ADMINISTRADOR);
		btnAdministrador.setVisible(true);
		add(btnAdministrador, cons );


		btnUsuario = new JButton(imgUsuario);
		btnUsuario.setText("Usuario");
		btnUsuario.setFocusable(false);
		btnUsuario.setOpaque(false);
		btnUsuario.setContentAreaFilled(false);
		btnUsuario.setBorderPainted(false);
		btnUsuario.addActionListener(controlador);
		btnUsuario.setActionCommand(Controlador.A_BTN_DIALOGO_USUARIO);
		add(btnUsuario, cons);	
		
	}
	
//	@Override
//	public void paint(Graphics g) {
//		super.paint(g);
//		g.drawImage(imagenFondo, 0, 0, this);
//	}
	
	protected ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			return null;
		}
	}

}

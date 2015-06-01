package vista;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileSystemView;

import controlador.Controlador;
import modelo.entidades.Autor;

public class DialogoAgregarAutor extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  JTextField txtNombre;
	private JTextField txtRutaImagen;
	private JLabel lbNombre;
	protected JButton btnCrearAutor;
	private JButton btnCancelar;
	private JButton btnAgregarImagen;
	private ImageIcon image;

	public DialogoAgregarAutor(VentanaAdministrador administrador, Controlador controlador) {
		super(administrador);
		UIManager.put("TextField.font", new Font("Arial", Font.BOLD, 15));
		UIManager.put("TextArea.font", new Font("Arial", Font.BOLD, 15));
		setLayout(new GridBagLayout());
		setTitle("Ingresar Datos Autor");
		setSize(400,350);
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

		btnAgregarImagen = new JButton(ConstantesGUI.T_BTN_CARGAR_IMAGEN);
		btnAgregarImagen.setActionCommand(Controlador.A_AGREGAR_IMAGEN_AUTOR);
		btnAgregarImagen.addActionListener(controlador);
		cons.gridx = 0;
		cons.gridy = 2;
		cons.insets = new Insets(0, 20, 0, 0);
		add(btnAgregarImagen, cons);

		txtRutaImagen = new JTextField(10);
		txtRutaImagen.setEnabled(false);
		cons.gridx = 1;
		cons.gridy = 2;
		cons.insets = new Insets(0, 0, 0, 0);
		add(txtRutaImagen, cons);

		btnCancelar = new JButton(ConstantesGUI.T_BTN_CANCELAR);
		btnCancelar.addActionListener(controlador);
		btnCancelar.setActionCommand(Controlador.A_CANCELAR_AUTOR);
		cons.gridx = 0;
		cons.gridy = 3;
		cons.insets = new Insets(0, 100, 0, 0);
		add(btnCancelar, cons);

		btnCrearAutor = new JButton(ConstantesGUI.T_BTN_CREAR);
		cons.gridx = 1;
		cons.gridy = 3;
		cons.insets = new Insets(0, 0, 0, 100);
		btnCrearAutor.addActionListener(controlador);
		btnCrearAutor.setActionCommand(Controlador.A_AGREGAR_AUTOR);
		add(btnCrearAutor, cons);		
	}

	public Autor crearAutor(){
		Autor autor = new Autor(txtNombre.getText());
		dispose();
		cancelar();
		return autor;
	}
	
	public void cancelar(){
		txtNombre.setText("");
		txtRutaImagen.setText("");
		dispose();
	}

	public ImageIcon importarImagenAutor(){
		JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView());
		fc.showOpenDialog(null);
		File file = fc.getSelectedFile();
		if (file != null){
			txtRutaImagen.setText(file.getPath());
			image = new ImageIcon(file.getPath());
		}
		return image;
	}

	protected ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			return null;
		}
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}
}
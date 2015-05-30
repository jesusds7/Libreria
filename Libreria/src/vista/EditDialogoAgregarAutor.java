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

import modelo.dao.GestorAutor;
import modelo.entidades.Autor;
import controlador.Controlador;

public class EditDialogoAgregarAutor extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtRutaImagen;
	private JLabel lbNombre;
	protected JButton btnEditarAutor;
	private JButton btnCancelar;
	private JButton btnAgregarImagen;

	public EditDialogoAgregarAutor(VentanaAdministrador administrador, Controlador controlador) {
		super(administrador);
		UIManager.put("TextField.font", new Font("Arial", Font.BOLD, 15));
		UIManager.put("TextArea.font", new Font("Arial", Font.BOLD, 15));
		setLayout(new GridBagLayout());
		setTitle("Ingresar Datos Autor");
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

		btnAgregarImagen = new JButton(ConstantesGUI.T_BTN_CARGAR_IMAGEN);
		btnAgregarImagen.setActionCommand(Controlador.A_AGREGAR_IMAGEN_AUTOR);
		btnAgregarImagen.addActionListener(controlador);
		cons.gridx = 0;
		cons.gridy = 2;
		cons.insets = new Insets(0, 20, 0, 0);
		add(btnAgregarImagen, cons);

		txtRutaImagen = new JTextField(10);
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

		btnEditarAutor = new JButton(ConstantesGUI.T_MENU_ITEM_EDITAR_AUTOR);
		cons.gridx = 1;
		cons.gridy = 3;
		cons.insets = new Insets(0, 0, 0, 100);
		btnEditarAutor.addActionListener(controlador);
		btnEditarAutor.setActionCommand(Controlador.A_EDITAR_AUTOR);
		add(btnEditarAutor, cons);
	}
	
	public Autor crearAutor(){
		Autor autor = GestorAutor.crearAutor(txtNombre.getText());
		dispose();
		cancelar();
		return autor;
	}
	
	public Autor  editarAutor(Autor autor){
		autor.setNombre(txtNombre.getText());
		autor.setImagen(txtRutaImagen.getText());
		cancelar();
		dispose();
		return autor;	
	}

	public void cambiarValores(Autor autor){
		txtNombre.setText(autor.getNombre());
		txtRutaImagen.setText(autor.getImagen());
	}

	public void cancelar(){
		txtNombre.setText("");
		txtRutaImagen.setText("");
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
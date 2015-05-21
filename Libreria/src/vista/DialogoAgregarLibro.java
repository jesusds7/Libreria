package vista;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.dao.GestorLibro;
import modelo.entidades.Libro;
import modelo.entidades.TipoGenero;
import controlador.Controlador;

public class DialogoAgregarLibro extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextArea txtADescripcion;
	private JTextField txtValor;
	private JTextField txtRutaImagen;
	private JTextField txtNumeroCopias;
	private JTextField txtAutor;
	private JLabel lbNombre;
	private JLabel lbDescripcion;
	private JLabel lbValor;
	private JLabel lbNumeroCopias;
	private JLabel lbAutor;
	private JLabel lbGenero;
	protected JButton btnCrear;
	private JButton btnCancelar;
	private JButton btnAgregarImagen;
	private JComboBox<TipoGenero> listaGenero;

	public DialogoAgregarLibro(VentanaAdministrador administrador, Controlador controlador) {
		super(administrador);
		UIManager.put("TextField.font", new Font("Arial", Font.BOLD, 15));
		UIManager.put("TextArea.font", new Font("Arial", Font.BOLD, 15));
		setLayout(new GridBagLayout());
		setTitle("Ingresar Datos Libro");
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

		lbDescripcion = new JLabel(ConstantesGUI.T_LABEL_DESCRIPCION);
		cons.weightx = 0.5;
		cons.weighty = 0.5;
		cons.gridx = 0;
		cons.gridy = 1;
		add(lbDescripcion, cons);

		txtADescripcion = new JTextArea(4, 10);
		txtADescripcion.setLineWrap(true);
		txtADescripcion.setWrapStyleWord(true);
		cons.gridx = 1;
		cons.gridy = 1;
		add(new JScrollPane(txtADescripcion), cons);

		lbValor = new JLabel(ConstantesGUI.T_LABEL_SITIO_VALOR);
		cons.weightx = 0.5;
		cons.weighty = 0.5;
		cons.gridx = 0;
		cons.gridy = 2;
		add(lbValor, cons);

		txtValor = new JTextField(10);
		cons.gridx = 1;
		cons.gridy = 2;
		add(txtValor, cons);

		lbNumeroCopias = new JLabel(ConstantesGUI.T_LABEL_NUMERO_COPIAS);
		cons.gridx = 0;
		cons.gridy = 3;
		add(lbNumeroCopias, cons);

		txtNumeroCopias = new JTextField(10);
		cons.gridx = 1;
		cons.gridy = 3;
		add(txtNumeroCopias, cons);

		lbAutor = new JLabel(ConstantesGUI.T_LABEL_AUTOR);
		cons.gridx = 0;
		cons.gridy = 4;
		add(lbAutor, cons);

		txtAutor = new JTextField(10);
		cons.gridx = 1;
		cons.gridy = 4;
		add(txtAutor, cons);

		lbGenero = new JLabel(ConstantesGUI.T_LABEL_GENERO);
		cons.gridx = 0;
		cons.gridy = 5;
		add(lbGenero, cons);

		listaGenero = new JComboBox<TipoGenero>();
		cons.gridx = 1;
		cons.gridy = 5;
		listaGenero.addItem(TipoGenero.ACCION);
		listaGenero.addItem(TipoGenero.AVENTURA);
		listaGenero.addItem(TipoGenero.CIENTIFICO);
		listaGenero.addItem(TipoGenero.INFANTIL);
		listaGenero.addItem(TipoGenero.TERROR);
		add(listaGenero, cons);



		btnAgregarImagen = new JButton(ConstantesGUI.T_BTN_CARGAR_IMAGEN);
		btnAgregarImagen.setActionCommand(Controlador.A_AGREGAR_IMAGEN);
		btnAgregarImagen.addActionListener(controlador);
		cons.gridx = 0;
		cons.gridy = 6;
		cons.insets = new Insets(0, 20, 0, 0);
		add(btnAgregarImagen, cons);

		txtRutaImagen = new JTextField(10);
		cons.gridx = 1;
		cons.gridy = 6;
		cons.insets = new Insets(0, 0, 0, 0);
		add(txtRutaImagen, cons);

		btnCancelar = new JButton(ConstantesGUI.T_BTN_CANCELAR);
		btnCancelar.addActionListener(controlador);
		btnCancelar.setActionCommand(Controlador.A_CANCELAR_LIBRO);
		cons.gridx = 0;
		cons.gridy = 7;
		cons.insets = new Insets(0, 100, 0, 0);
		add(btnCancelar, cons);

		btnCrear = new JButton(ConstantesGUI.T_BTN_CREAR);
		cons.gridx = 1;
		cons.gridy = 7;
		cons.insets = new Insets(0, 0, 0, 100);
		btnCrear.addActionListener(controlador);
		btnCrear.setActionCommand(Controlador.A_AGREGAR_LIBRO);
		add(btnCrear, cons);
		seleccionBox();
	}

	public TipoGenero seleccionBox(){
		TipoGenero aux = (TipoGenero) listaGenero.getSelectedItem();
		return aux;
	}


	public void copiarImagen(){
		Path entrada = Paths.get(txtRutaImagen.getText());
		Path salida = Paths.get("/src/img");
		try {
			Files.copy(entrada, salida );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Libro crearLibro(){
		Libro libro = GestorLibro.crearLibro(txtNombre.getText(), txtADescripcion.getText(), txtRutaImagen.getText(),
				Integer.parseInt(txtNumeroCopias.getText()), Double.parseDouble(txtValor.getText()), txtAutor.getText(), TipoGenero.INFANTIL);
		dispose();
		cancelar();
		return libro;
	}

	public void cancelar(){
		txtNombre.setText("");
		txtADescripcion.setText("");
		txtValor.setText("");
		txtRutaImagen.setText("");
		txtAutor.setText("");
		txtNumeroCopias.setText("");
		dispose();
	}

	public void obtenerRutaImagen(){
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
		JFileChooser jf = new JFileChooser("/");
		jf.setFileFilter(filter);
		int opcion = jf.showOpenDialog(this);
		if (opcion == JFileChooser.APPROVE_OPTION) {
			txtRutaImagen.setText(jf.getSelectedFile().getPath());
		}		
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

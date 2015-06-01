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
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextArea txtADescripcion;
	private JTextField txtValor;
	private JTextField txtRutaImagen;
	private JTextField txtNumeroCopias;
	private String nombreAutor;
	private JLabel lbNombre;
	private JLabel lbDescripcion;
	private JLabel lbValor;
	private JLabel lbNumeroCopias;
	private JLabel lbAutor;
	private JLabel lbGenero;
	private JLabel lbEstadoNombre;
	private JLabel lbEstadoDescripcion;
	private JLabel lbEstadoValor;
	private JLabel lbEstadoNumeroCopias;
	private JLabel lbEstadoRuta;
	protected JButton btnCrear;
	private JButton btnCancelar;
	private JButton btnAgregarImagen;
	private JButton btnAgregarAutor;
	private JComboBox<TipoGenero> listaGenero;
	protected JComboBox<String> listaAutor;
	private Boolean peaje = true;
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
		
		lbEstadoNombre = new JLabel("");
		lbEstadoNombre.setOpaque(true);
		cons.gridx = 2;
		cons.gridy = 0;
		add(lbEstadoNombre, cons);

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
		
		lbEstadoDescripcion = new JLabel(ConstantesGUI.T_LABEL_ESTADO_GENERAL);
		cons.gridx = 2;
		cons.gridy = 1;
		add(lbEstadoDescripcion, cons);

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
		
		lbEstadoValor = new JLabel(ConstantesGUI.T_LABEL_ESTADO_GENERAL);
		cons.gridx = 2;
		cons.gridy = 2;
		add(lbEstadoValor, cons);

		lbNumeroCopias = new JLabel(ConstantesGUI.T_LABEL_NUMERO_COPIAS);
		cons.gridx = 0;
		cons.gridy = 3;
		add(lbNumeroCopias, cons);

		txtNumeroCopias = new JTextField(10);
		cons.gridx = 1;
		cons.gridy = 3;
		add(txtNumeroCopias, cons);
		
		lbEstadoNumeroCopias = new JLabel(ConstantesGUI.T_LABEL_ESTADO_GENERAL);
		cons.gridx = 2;
		cons.gridy = 3;
		add(lbEstadoNumeroCopias, cons);

		lbAutor = new JLabel(ConstantesGUI.T_LABEL_AUTOR);
		cons.gridx = 0;
		cons.gridy = 4;
		add(lbAutor, cons);

		listaAutor = new JComboBox<String>();
		cons.gridx = 1;
		cons.gridy = 4;
		add(listaAutor, cons);

		btnAgregarAutor = new JButton(ConstantesGUI.T_MENU_ITEM_AGREGAR_AUTOR);
		cons.gridx = 2;
		cons.gridy = 4;
		btnAgregarAutor.addActionListener(controlador);
		btnAgregarAutor.setActionCommand(Controlador.A_MOSTAR_AGREGAR_AUTOR);
		add(btnAgregarAutor, cons);

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
		txtRutaImagen.setEnabled(false);
		cons.gridx = 1;
		cons.gridy = 6;
		cons.insets = new Insets(0, 0, 0, 0);
		add(txtRutaImagen, cons);
		
		lbEstadoRuta= new JLabel(ConstantesGUI.T_LABEL_ESTADO_GENERAL);
		cons.gridx = 2;
		cons.gridy = 6;
		add(lbEstadoRuta, cons);

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
				Integer.parseInt(txtNumeroCopias.getText()), Double.parseDouble(txtValor.getText()), listaAutor.getSelectedItem().toString(),listaGenero.toString() );
		dispose();
		cancelar();
		return libro;
	}

	public void cancelar(){
		txtNombre.setText("");
		txtADescripcion.setText("");
		txtValor.setText("");
		txtRutaImagen.setText("");
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
	
	public void iniciarEstados(){
		lbEstadoNombre.setText(ConstantesGUI.T_LABEL_ESTADO_GENERAL);
		lbEstadoNombre.setIcon(new ImageIcon());
		
		lbEstadoDescripcion.setText(ConstantesGUI.T_LABEL_ESTADO_GENERAL);
		lbEstadoDescripcion.setIcon(new ImageIcon());
		
		lbEstadoValor.setText(ConstantesGUI.T_LABEL_ESTADO_GENERAL);
		lbEstadoValor.setIcon(new ImageIcon());
		
		lbEstadoNumeroCopias.setText(ConstantesGUI.T_LABEL_ESTADO_GENERAL);
		lbEstadoNumeroCopias.setIcon(new ImageIcon());
		
		lbEstadoRuta.setText(ConstantesGUI.T_LABEL_ESTADO_GENERAL);
		lbEstadoRuta.setIcon(new ImageIcon());
	}
	
	public boolean evaluarCampos(){
		
		if(txtNombre.getText().equalsIgnoreCase("")){
			cambiarEstado(lbEstadoNombre);
			cambiarFalso(peaje);
		}
	
		if(txtADescripcion.getText().equalsIgnoreCase("")){
			cambiarEstado(lbEstadoDescripcion);
			cambiarFalso(peaje);
		}
		
		 if(txtValor.getText().equalsIgnoreCase("")){
			cambiarEstado(lbEstadoValor);
			cambiarFalso(peaje);
		}
		
		 if(txtNumeroCopias.getText().equalsIgnoreCase("")){
			cambiarEstado(lbEstadoNumeroCopias);
			cambiarFalso(peaje);
		}
		 if(txtRutaImagen.getText().equalsIgnoreCase("")){
				cambiarEstado(lbEstadoRuta);
				cambiarFalso(peaje);
			}
		 return peaje;
	}
	
	public void cambiarFalso(boolean peaje){
		this.peaje = false;
	}
	
	public void cambiarEstado(JLabel labelEstado){
		labelEstado.setText(ConstantesGUI.T_LABEL_ESTADO_TEXTO_MAL );
		labelEstado.setIcon(new ImageIcon(ConstantesGUI.T_LABEL_ESTADO_MAL));
	}
	
	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	public JComboBox<String> getListaAutor() {
		return listaAutor;
	}

	public void setListaAutor(JComboBox<String> listaAutor) {
		this.listaAutor = listaAutor;
	}
	
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextArea getTxtADescripcion() {
		return txtADescripcion;
	}

	public void setTxtADescripcion(JTextArea txtADescripcion) {
		this.txtADescripcion = txtADescripcion;
	}

	public JTextField getTxtValor() {
		return txtValor;
	}

	public void setTxtValor(JTextField txtValor) {
		this.txtValor = txtValor;
	}

	public JTextField getTxtRutaImagen() {
		return txtRutaImagen;
	}

	public void setTxtRutaImagen(JTextField txtRutaImagen) {
		this.txtRutaImagen = txtRutaImagen;
	}

	public JTextField getTxtNumeroCopias() {
		return txtNumeroCopias;
	}

	public void setTxtNumeroCopias(JTextField txtNumeroCopias) {
		this.txtNumeroCopias = txtNumeroCopias;
	}

	public Boolean getPeaje() {
		return peaje;
	}

	public void setPeaje(Boolean peaje) {
		this.peaje = peaje;
	}
	
	
	
	
	
}
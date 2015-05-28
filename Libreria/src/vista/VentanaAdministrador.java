package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.entidades.Autor;
import modelo.entidades.Cliente;
import modelo.entidades.Libro;
import modelo.entidades.TipoGenero;
import modelo.util.Util;
import controlador.Controlador;

public class VentanaAdministrador extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BarraHerramientasAdm barraHerramientas;
	private BarraMenuAdm barraMenu;
	private JTable tablalibros;
	private DefaultTableModel modeloTablaLibros;
	private JTable tablaAutores;
	private DefaultTableModel modeloTablaAutores;
	private JTable tablaClientes;
	private DefaultTableModel modeloTablaClientes;
	private JPanel panelLibros;
	private JPanel panelCliente;
	private JPanel panelAutor;
	private JPanel panelClase;
	private PanelFotos panelFotos;
	private DialogoAgregarLibro dialogoAgregarLibro;
	private TableRowSorter<TableModel> trsfiltro;

	public VentanaAdministrador(Controlador controlador) {
		setTitle(ConstantesGUI.T_TITULO_VENTANA);
		setLayout(new BorderLayout());
		setExtendedState(VentanaAdministrador.MAXIMIZED_BOTH);
		setSize(ConstantesGUI.VENTANA_ALTO,ConstantesGUI.VENTANA_ANCHO);
		setLocationRelativeTo(null);
		setIconImage(createImageIcon(ConstantesGUI.IMG_ICONO_LIBRO).getImage());

		barraMenu = new BarraMenuAdm(controlador);
		setJMenuBar(barraMenu);	

		barraHerramientas = new BarraHerramientasAdm(controlador);
		add(barraHerramientas, BorderLayout.PAGE_START);

		panelClase = new JPanel(new GridLayout(1,3));

		panelLibros = new JPanel();

		modeloTablaLibros = new DefaultTableModel(new String[]{"N°Orden" , "Nombre", "Descripcion", "precio", "Numero Copias", "Autor", "Genero"}, 0);
		tablalibros = new JTable(modeloTablaLibros);
		tablalibros.getTableHeader().setReorderingAllowed(false);
		tablalibros.getSelectionModel().addListSelectionListener(new ListSelectionListener() {			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(modeloTablaLibros.getRowCount() > 0){
					//					try {
					//						panelFotos.setRutaImagen(controlador.buscarSitioTuristico(retornarIdSeleccion()).getImagen());
					//						panelFotos.repaint();
					//					} catch (ExcepcionSitioNoEncontrado e1) {
					//						e1.printStackTrace();
					//					}
				}
			}
		});
		panelLibros.setBorder(BorderFactory.createTitledBorder("Libros"));
		panelLibros.add(new JScrollPane(tablalibros));
		panelClase.add(panelLibros);

		panelAutor = new JPanel();
		modeloTablaAutores = new DefaultTableModel(new String[]{"N°Orden" , "Nombre"}, 0);
		tablaAutores = new JTable(modeloTablaAutores);
		tablaAutores.getTableHeader().setReorderingAllowed(false);
		tablaAutores.getSelectionModel().addListSelectionListener(new ListSelectionListener() {			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(modeloTablaAutores.getRowCount() > 0){
					//					try {
					//						panelFotos.setRutaImagen(controlador.buscarSitioTuristico(retornarIdSeleccion()).getImagen());
					//						panelFotos.repaint();
					//					} catch (ExcepcionSitioNoEncontrado e1) {
					//						e1.printStackTrace();
					//					}
				}
			}
		});
		panelAutor.setBorder(BorderFactory.createTitledBorder("Autor"));
		panelAutor.add(new JScrollPane(tablaAutores));
		panelClase.add(panelAutor);


		panelCliente = new JPanel();
		modeloTablaClientes = new DefaultTableModel(new String[]{"N°Orden" , "Nombre", "Dinero"}, 0);
		tablaClientes = new JTable(modeloTablaClientes);
		tablaClientes.getTableHeader().setReorderingAllowed(false);
		tablaClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(modeloTablaClientes.getRowCount() > 0){
					//					try {
					//						panelFotos.setRutaImagen(controlador.buscarSitioTuristico(retornarIdSeleccion()).getImagen());
					//						panelFotos.repaint();
					//					} catch (ExcepcionSitioNoEncontrado e1) {
					//						e1.printStackTrace();
					//					}
				}
			}
		});
		panelCliente.setBorder(BorderFactory.createTitledBorder("Cliente"));
		panelCliente.add(new JScrollPane(tablaClientes));
		panelClase.add(panelCliente);

		//		panelCliente = new JPanel();
		//		panelCliente.setBorder(BorderFactory.createTitledBorder("Clientes"));
		//		panelClase.add(panelCliente, cons);
		add(panelClase);

		dialogoAgregarLibro = new DialogoAgregarLibro(this, controlador);
		dialogoAgregarLibro.setVisible(false);
//		filtrarAutor();
//		filtrarClienteNombre();
//		filtrarLibroTitulo();
	}

	public void seleccionarLibro(int id){
		for (int i = 0; i < tablalibros.getRowCount(); i++) {
			int aux = Integer.parseInt((String) modeloTablaLibros.getValueAt(i, 0));
			if(id == aux){
				tablalibros.setRowSelectionInterval(i, i);
				break;
			}
		}
	}

	public void seleccionarLibro(String name){
		for (int i = 0; i < modeloTablaLibros.getRowCount(); i++) {
			String n = (String) modeloTablaLibros.getValueAt(i, 1);
			if(n.equalsIgnoreCase(name)){
				tablalibros.setRowSelectionInterval(i, i);
				break;
			}
		}
	}

	public void seleccionarAutor(int id){
		for (int i = 0; i < tablaAutores.getRowCount(); i++) {
			int aux = Integer.parseInt((String) modeloTablaAutores.getValueAt(i, 0));
			if(id == aux){
				tablaAutores.setRowSelectionInterval(i, i);
				break;
			}
		}
	}

	public void seleccionarAutor(String nombre){
		for (int i = 0; i < tablaAutores.getRowCount(); i++) {
			String aux = (String) modeloTablaAutores.getValueAt(i, 1);
			if(aux.equalsIgnoreCase(nombre)){
				tablaAutores.setRowSelectionInterval(i, i);
				break;
			}
		}
	}

	public void seleccionarCliente(int id){
		for (int i = 0; i < tablaClientes.getRowCount(); i++) {
			int aux = Integer.parseInt((String)modeloTablaClientes.getValueAt(i, 0));
			if(aux == id){
				tablaClientes.setRowSelectionInterval(i, i);
			}
		}
	}

	public void seleccionarCliente(String nombre){
		for (int i = 0; i < tablaClientes.getRowCount(); i++) {
			String aux = (String)modeloTablaClientes.getValueAt(i, 1);
			if(aux.equalsIgnoreCase(nombre)){
				tablaClientes.setRowSelectionInterval(i, i);
			}
		}
	}

	public void elimiarFilaLibro(){
		int pregunta = JOptionPane.showConfirmDialog(this, "Seguro quiere eliminar el Libro?.", "", 1, 0);
		if(pregunta == JOptionPane.YES_OPTION){
			modeloTablaLibros.removeRow(tablalibros.getSelectedRow());
		}
	}

	public void elimiarFilaAutor(){
		int pregunta = JOptionPane.showConfirmDialog(this, "Seguro quiere eliminar el Autor?.", "", 1, 0);
		if(pregunta == JOptionPane.YES_OPTION){
			modeloTablaAutores.removeRow(tablaAutores.getSelectedRow());
		}
	}

	public void elimiarFilaCliente(){
		int pregunta = JOptionPane.showConfirmDialog(this, "Seguro quiere eliminar el Cliente?.", "", 1, 0);
		if(pregunta == JOptionPane.YES_OPTION){
			modeloTablaClientes.removeRow(tablaClientes.getSelectedRow());
		}
	}

	public int retornarIdSeleccionLibro(){
		return Integer.parseInt((String) modeloTablaLibros.getValueAt(tablalibros.getSelectedRow(), 0));
	}

	public int retornarIdSeleccionAutor(){
		return Integer.parseInt((String) modeloTablaAutores.getValueAt(tablaAutores.getSelectedRow(), 0));
	}

	public int retornarIdSeleccionCliente(){
		return Integer.parseInt((String) modeloTablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0));
	}

	public void agregarLibroTabla(Libro libro, TipoGenero genero){
		modeloTablaLibros.addRow(Util.sitioAVector(libro, genero));
	}

	public void agregarAutorTabla(Autor autor){
		modeloTablaAutores.addRow(Util.sitioAVectorAutor(autor));
	}

	public void agregarClienteTabla(Cliente cliente){
		modeloTablaClientes.addRow(Util.sitioAVectorCliente(cliente));
	}

	public void mostrarDialogo(){
		dialogoAgregarLibro.setVisible(true);
	}

	public void actualizarTablaLibro(Libro s, int fila){
		modeloTablaLibros.setValueAt(s.getNombre(), fila, 1);
		modeloTablaLibros.setValueAt(s.getDescripcion(), fila, 2);
		modeloTablaLibros.setValueAt(s.getPrecio(), fila, 3);
		modeloTablaLibros.setValueAt(s.getNumeroCopias(), fila, 4);
		modeloTablaLibros.setValueAt(s.getNombreAutor(), fila, 5);		
		//		panelFotos.setRutaImagen(s.getImagen());
		modeloTablaLibros.fireTableDataChanged();
	}

	public void actualizarTablaAutor(Autor s, int fila){
		modeloTablaAutores.setValueAt(s.getNombre(), fila, 1);
		//		panelFotos.setRutaImagen(s.getImagen());
		modeloTablaAutores.fireTableDataChanged();
	}

	public void actualizarTablaCliente(Cliente s, int fila){
		modeloTablaClientes.setValueAt(s.getNombre(), fila, 1);
		modeloTablaClientes.setValueAt(s.getDinero(), fila, 2);
		modeloTablaClientes.fireTableDataChanged();
	}

	protected ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			return null;
		}
	}

	public BarraHerramientasAdm getBarraHerramientas() {
		return barraHerramientas;
	}

	public void setBarraHerramientas(BarraHerramientasAdm barraHerramientas) {
		this.barraHerramientas = barraHerramientas;
	}

	public BarraMenuAdm getBarraMenu() {
		return barraMenu;
	}

	public void setBarraMenu(BarraMenuAdm barraMenu) {
		this.barraMenu = barraMenu;
	}

	public void filtroAutor(){
		trsfiltro.setRowFilter(RowFilter.regexFilter(barraHerramientas.getTxBuscar().getText(), 1));
	}
	public void filtrarAutor() {
		barraHerramientas.getTxBuscar().addKeyListener(new KeyAdapter() {
			public void keyReleased(final KeyEvent e) {
				String cadena = (barraHerramientas.getTxBuscar().getText());
				barraHerramientas.getTxBuscar().setText(cadena);
				repaint();
				filtroAutor();
			}
		});
		trsfiltro = new TableRowSorter<TableModel>(tablaAutores.getModel());
		tablaAutores.setRowSorter(trsfiltro);
	}
	public void filtroAutorID(){
		trsfiltro.setRowFilter(RowFilter.regexFilter(barraHerramientas.getTxBuscar().getText(), 0));
	}
	public void filtrarAutorID() {
		barraHerramientas.getTxBuscar().addKeyListener(new KeyAdapter() {
			public void keyReleased(final KeyEvent e) {
				String cadena = (barraHerramientas.getTxBuscar().getText());
				barraHerramientas.getTxBuscar().setText(cadena);
				repaint();
				filtroAutorID();
			}
		});
		trsfiltro = new TableRowSorter<TableModel>(tablaAutores.getModel());
		tablaAutores.setRowSorter(trsfiltro);
	}
	public void filtroClienteID(){
		trsfiltro.setRowFilter(RowFilter.regexFilter(barraHerramientas.getTxBuscar().getText(), 0));
	}
	public void filtrarClienteID() {
		barraHerramientas.getTxBuscar().addKeyListener(new KeyAdapter() {
			public void keyReleased(final KeyEvent e) {
				String cadena = (barraHerramientas.getTxBuscar().getText());
				barraHerramientas.getTxBuscar().setText(cadena);
				repaint();
				filtroAutorID();
			}
		});
		trsfiltro = new TableRowSorter<TableModel>(tablaClientes.getModel());
		tablaClientes.setRowSorter(trsfiltro);
	}
	public void filtroClienteNombre(){
		trsfiltro.setRowFilter(RowFilter.regexFilter(barraHerramientas.getTxBuscar().getText(), 1));
	}
	public void filtrarClienteNombre() {
		barraHerramientas.getTxBuscar().addKeyListener(new KeyAdapter() {
			public void keyReleased(final KeyEvent e) {
				String cadena = (barraHerramientas.getTxBuscar().getText());
				barraHerramientas.getTxBuscar().setText(cadena);
				repaint();
				filtroAutorID();
			}
		});
		trsfiltro = new TableRowSorter<TableModel>(tablaClientes.getModel());
		tablaClientes.setRowSorter(trsfiltro);
	}
	public void filtroLibroTitulo(){
		trsfiltro.setRowFilter(RowFilter.regexFilter(barraHerramientas.getTxBuscar().getText(), 1));
	}
	public void filtrarLibroTitulo() {
		barraHerramientas.getTxBuscar().addKeyListener(new KeyAdapter() {
			public void keyReleased(final KeyEvent e) {
				String cadena = (barraHerramientas.getTxBuscar().getText());
				barraHerramientas.getTxBuscar().setText(cadena);
				repaint();
				filtroLibroTitulo();
			}
		});
		trsfiltro = new TableRowSorter<TableModel>(tablalibros.getModel());
		tablalibros.setRowSorter(trsfiltro);
	}
	public void filtroLibroID(){
		trsfiltro.setRowFilter(RowFilter.regexFilter(barraHerramientas.getTxBuscar().getText(), 0));
	}
	public void filtrarLibroID() {
		barraHerramientas.getTxBuscar().addKeyListener(new KeyAdapter() {
			public void keyReleased(final KeyEvent e) {
				String cadena = (barraHerramientas.getTxBuscar().getText());
				barraHerramientas.getTxBuscar().setText(cadena);
				repaint();
				filtroLibroTitulo();
			}
		});
		trsfiltro = new TableRowSorter<TableModel>(tablalibros.getModel());
		tablalibros.setRowSorter(trsfiltro);
	}

}

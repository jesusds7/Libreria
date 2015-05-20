package vista;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
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
	private DefaultTableModel modeloTabla;
	private JPanel panelCentro;
	private PanelFotos panelFotos;
	private DialogoAgregarLibro dialogoAgregarLibro;

	public VentanaAdministrador(Controlador controlador) {
		setTitle(ConstantesGUI.T_TITULO_VENTANA);
		setLayout(new BorderLayout());
		setSize(ConstantesGUI.VENTANA_ALTO,ConstantesGUI.VENTANA_ANCHO);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(createImageIcon(ConstantesGUI.IMG_ICONO_LIBRO).getImage());

		barraMenu = new BarraMenuAdm(controlador);
		setJMenuBar(barraMenu);	

		barraHerramientas = new BarraHerramientasAdm(controlador);
		add(barraHerramientas, BorderLayout.PAGE_START);

		panelCentro = new JPanel(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.BOTH;

		modeloTabla = new DefaultTableModel(new String[]{"N°Orden" , "Nombre", "Descripcion", "precio", "Numero Copias", "Autor", "Genero"}, 0);
		tablalibros = new JTable(modeloTabla);
		panelFotos = new PanelFotos();
		tablalibros.getTableHeader().setReorderingAllowed(false);
		tablalibros.getSelectionModel().addListSelectionListener(new ListSelectionListener() {			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(modeloTabla.getRowCount() > 0){
					//					try {
					//						panelFotos.setRutaImagen(controlador.buscarSitioTuristico(retornarIdSeleccion()).getImagen());
					//						panelFotos.repaint();
					//					} catch (ExcepcionSitioNoEncontrado e1) {
					//						e1.printStackTrace();
					//					}
				}
			}
		});
		cons.gridx = 0;
		cons.gridy = 0;
		cons.weightx = 1;
		cons.weighty = 1;
		panelCentro.add(new JScrollPane(tablalibros), cons);
		panelFotos.setBorder(BorderFactory.createTitledBorder("Imagen"));
		cons.gridx = 6;
		cons.gridy = 0;
		cons.weightx = 4;
		cons.weighty = 1;
		panelCentro.add(panelFotos, cons);
		add(panelCentro);

		dialogoAgregarLibro = new DialogoAgregarLibro(this, controlador);
		dialogoAgregarLibro.setVisible(false);
	}

	public void seleccionarLibro(int id){
		for (int i = 0; i < tablalibros.getRowCount(); i++) {
			int aux = Integer.parseInt((String) modeloTabla.getValueAt(i, 0));
			if(id == aux){
				tablalibros.setRowSelectionInterval(i, i);
				break;
			}
		}
	}

	public void seleccionarLibro(String name){
		for (int i = 0; i < modeloTabla.getRowCount(); i++) {
			String n = (String) modeloTabla.getValueAt(i, 1);
			if(n.equalsIgnoreCase(name)){
				tablalibros.setRowSelectionInterval(i, i);
				break;
			}
		}
	}

	public void elimiarFila(){
		int pregunta = JOptionPane.showConfirmDialog(this, "Seguro quiere eliminar el Libro?.", "", 1, 0);
		if(pregunta == JOptionPane.YES_OPTION){
			modeloTabla.removeRow(tablalibros.getSelectedRow());
		}
	}

	public int retornarIdSeleccion(){
		return Integer.parseInt((String) modeloTabla.getValueAt(tablalibros.getSelectedRow(), 0));
	}

	public void agregarLibroTabla(Libro libro, TipoGenero genero){
		modeloTabla.addRow(Util.sitioAVector(libro, genero));
	}

	public void mostrarDialogo(){
		dialogoAgregarLibro.setVisible(true);
	}
	
	public void actualizarTabla (Libro s, int fila){
		modeloTabla.setValueAt(s.getId(), fila, 0);
		modeloTabla.setValueAt(s.getNombre(), fila, 1);
		modeloTabla.setValueAt(s.getDescripcion(), fila, 2);
		modeloTabla.setValueAt(s.getPrecio(), fila, 3);
		modeloTabla.setValueAt(s.getNumeroCopias(), fila, 4);
		modeloTabla.setValueAt(s.getNombreAutor(), fila, 5);		
		panelFotos.setRutaImagen(s.getImagen());
		modeloTabla.fireTableDataChanged();
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

	public JTable getTablalibros() {
		return tablalibros;
	}

	public void setTablalibros(JTable tablalibros) {
		this.tablalibros = tablalibros;
	}

	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	public void setModeloTabla(DefaultTableModel modeloTabla) {
		this.modeloTabla = modeloTabla;
	}

	public JPanel getPanelCentro() {
		return panelCentro;
	}

	public void setPanelCentro(JPanel panelCentro) {
		this.panelCentro = panelCentro;
	}

	public PanelFotos getPanelFotos() {
		return panelFotos;
	}

	public void setPanelFotos(PanelFotos panelFotos) {
		this.panelFotos = panelFotos;
	}

	public DialogoAgregarLibro getDialogoAgregarLibro() {
		return dialogoAgregarLibro;
	}

	public void setDialogoAgregarLibro(DialogoAgregarLibro dialogoAgregarLibro) {
		this.dialogoAgregarLibro = dialogoAgregarLibro;
	}
}

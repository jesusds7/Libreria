package vista;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import controlador.Controlador;

public class VentanaUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private BarraHerramientasUs barraHerramientas;
	private BarraMenuUs barraMenu;
	private DefaultTableModel modelo;
	private JTable tablaLibros;
	private TableRowSorter<TableModel> trsfiltro;

	public VentanaUsuario(Controlador controlador) {

		this.setTitle(ConstantesGUI.T_VENTANA_USUARIO);
		this.setLayout(new BorderLayout());
		this.setSize(ConstantesGUI.VENTANA_USUARIO_ANCHO,ConstantesGUI.VENTANA_USUARIO_ALTO);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon(ConstantesGUI.IMG_ICONO_VENTANA_USUARIO).getImage());
		this.setExtendedState(VentanaUsuario.MAXIMIZED_BOTH);

		barraMenu = new BarraMenuUs(controlador);
		setJMenuBar(barraMenu);

		modelo = new DefaultTableModel() {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		modelo.setColumnIdentifiers(new String[] {
				ConstantesGUI.T_TABLA_NOMBRE, ConstantesGUI.T_TABLA_AUTOR,
				ConstantesGUI.T_TABLA_DESCRIPCION, ConstantesGUI.T_TABLA_VALOR });

		tablaLibros = new JTable(modelo);
		tablaLibros.getTableHeader().setReorderingAllowed(false);
		add(new JScrollPane(tablaLibros), BorderLayout.CENTER);

		barraHerramientas = new BarraHerramientasUs(controlador);
		add(barraHerramientas, BorderLayout.PAGE_START);

	}

	public void filtroTitulo() {
		trsfiltro.setRowFilter(RowFilter.regexFilter(barraHerramientas.getTxtBuscar().getText(), 0));
	}

	public void filtroAutor() {
		trsfiltro.setRowFilter(RowFilter.regexFilter(barraHerramientas.getTxtBuscar().getText(), 1));
	}

	public void filtrarTitulo() {
		barraHerramientas.getTxtBuscar().addKeyListener(new KeyAdapter() {
			public void keyReleased(final KeyEvent e) {
				String cadena = (barraHerramientas.getTxtBuscar().getText());
				barraHerramientas.getTxtBuscar().setText(cadena);
				repaint();
				filtroTitulo();
			}
		});
		trsfiltro = new TableRowSorter<TableModel>(tablaLibros.getModel());
		tablaLibros.setRowSorter(trsfiltro);
	}

	public void filtrarAutor() {
		barraHerramientas.getTxtBuscar().addKeyListener(new KeyAdapter() {
			public void keyReleased(final KeyEvent e) {
				String cadena = (barraHerramientas.getTxtBuscar().getText());
				barraHerramientas.getTxtBuscar().setText(cadena);
				repaint();
				filtroAutor();
			}
		});
		trsfiltro = new TableRowSorter<TableModel>(tablaLibros.getModel());
		tablaLibros.setRowSorter(trsfiltro);
	}

}

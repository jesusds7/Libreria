package vista;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;

public class VentanaUsuario extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private BarraHerramientasUs barraHerramientas;
	private BarraMenuUs barraMenu;
	
	private DefaultTableModel modelo;
	private JTable tablaSitios;
	
	public VentanaUsuario(Controlador controlador) {
		
		this.setTitle(ConstantesGUI.T_VENTANA_USUARIO);
		this.setLayout(new BorderLayout());
		this.setSize(ConstantesGUI.VENTANA_USUARIO_ANCHO, ConstantesGUI.VENTANA_USUARIO_ALTO);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon(ConstantesGUI.IMG_ICONO_LIBRO).getImage());

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
				ConstantesGUI.T_TABLA_ID,
				ConstantesGUI.T_TABLA_NOMBRE,
				ConstantesGUI.T_TABLA_DESCRIPCION,
				ConstantesGUI.T_TABLA_VALOR });
		
		tablaSitios = new JTable(modelo);
		tablaSitios.getTableHeader().setReorderingAllowed(false);
		add(new JScrollPane(tablaSitios), BorderLayout.CENTER);

		barraHerramientas = new BarraHerramientasUs(controlador);
		add(barraHerramientas, BorderLayout.PAGE_START);
	}

}

package vista;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controlador.Controlador;

public class BarraMenu extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenu menuArchivo;
	private JMenuItem itemAgregarLibro;
	private JMenuItem itemEditarLibro;
	private JMenuItem itemRemoverLibro;
	private JMenuItem itemComprarLibro;
	private JMenu menuImportar;
	private JMenu menuExportar;
	private JMenuItem itemSalir;
	private JMenu menuEstadisticas;
	private JMenu menuPreferencias;
	private JMenu menuAyuda;
	
	
	public BarraMenu(Controlador controlador) {
		menuArchivo = new JMenu(ConstantesGUI.T_MENU_ARCHIVO);
		itemComprarLibro = new JMenuItem(ConstantesGUI.T_MENU_ITEM_COMPRAR_LIBRO);
		menuArchivo.add(itemComprarLibro);
		itemAgregarLibro = new JMenuItem(ConstantesGUI.T_MENU_ITEM_AGREGAR_lIBRO);
		menuArchivo.add(itemAgregarLibro);
		itemRemoverLibro = new JMenuItem(ConstantesGUI.T_MENU_ITEM_REMOVER_LIBRO);
		menuArchivo.add(itemRemoverLibro);
		itemEditarLibro = new JMenuItem(ConstantesGUI.T_MENU_ITEM_EDITAR_LIBRO);
		menuArchivo.add(itemEditarLibro);
		menuImportar = new JMenu(ConstantesGUI.T_MENU_IMPORTAR);
		menuArchivo.add(menuImportar);
		menuExportar = new JMenu(ConstantesGUI.T_MENU_EXPORTAR);
		menuArchivo.add(menuExportar);
		itemSalir = new JMenuItem(ConstantesGUI.T_MENU_ITEM_SALIR);
		menuArchivo.add(itemSalir);
		add(menuArchivo);
		
		menuPreferencias = new JMenu(ConstantesGUI.T_MENU_PREFERENCIAS);
		add(menuPreferencias);
		
		menuEstadisticas = new JMenu(ConstantesGUI.T_MENU_ESTADISTICAS);
		add(menuEstadisticas);
		
		menuAyuda = new JMenu(ConstantesGUI.T_MENU_AYUDA);
		add(menuAyuda);
	}

}

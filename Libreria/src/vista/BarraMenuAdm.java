package vista;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controlador.Controlador;

public class BarraMenuAdm extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenu menuArchivo;
	private JMenuItem itemEditarLibro;
	private JMenuItem itemRemoverLibro;
	private JMenuItem itemAgregarLibro;
	private JMenu menuImportar;
	private JMenu menuExportar;
	private JMenuItem itemSalir;
	private JMenu menuEstadisticas;
	private JMenu menuPreferencias;
	private JMenu menuAyuda;


	public BarraMenuAdm(Controlador controlador) {
		menuArchivo = new JMenu(ConstantesGUI.T_MENU_ARCHIVO);
		itemAgregarLibro = new JMenuItem(ConstantesGUI.T_MENU_ITEM_AGREGAR_lIBRO);
		itemAgregarLibro.addActionListener(controlador);
		itemAgregarLibro.setActionCommand(Controlador.A_MOSTRAR_DIALOGO_AGREGAR_LIBRO);
		itemAgregarLibro.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_NUEVO_LIBRO));
		menuArchivo.add(itemAgregarLibro);		
		itemRemoverLibro = new JMenuItem(ConstantesGUI.T_MENU_ITEM_REMOVER_LIBRO);
		itemRemoverLibro.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_ELIMINAR_LIBRO));
		menuArchivo.add(itemRemoverLibro);
		itemEditarLibro = new JMenuItem(ConstantesGUI.T_MENU_ITEM_EDITAR_LIBRO);
		itemEditarLibro.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_EDITAR));
		menuArchivo.add(itemEditarLibro);
		menuImportar = new JMenu(ConstantesGUI.T_MENU_IMPORTAR);
		menuImportar.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_IMPORTAR));
		menuArchivo.add(menuImportar);
		menuExportar = new JMenu(ConstantesGUI.T_MENU_EXPORTAR);
		menuExportar.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_EXPORTAR));
		menuArchivo.add(menuExportar);
		itemSalir = new JMenuItem(ConstantesGUI.T_MENU_ITEM_SALIR);
		itemSalir.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_SALIR));
		itemSalir.addActionListener(controlador);
		itemSalir.setActionCommand(Controlador.A_SALIR);
		menuArchivo.add(itemSalir);
		add(menuArchivo);

		menuPreferencias = new JMenu(ConstantesGUI.T_MENU_PREFERENCIAS);
		add(menuPreferencias);

		menuEstadisticas = new JMenu(ConstantesGUI.T_MENU_ESTADISTICAS);
		add(menuEstadisticas);

		menuAyuda = new JMenu(ConstantesGUI.T_MENU_AYUDA);
		add(menuAyuda);
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

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
	private JMenuItem itemEditarAutor;
	private JMenuItem itemRemoverAutor;
	private JMenuItem itemAgregarAutor;
	private JMenuItem itemEditarCliente;
	private JMenuItem itemRemoverCliente;
	private JMenuItem itemAgregarCliente;
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
		itemRemoverLibro.addActionListener(controlador);
		itemRemoverLibro.setActionCommand(Controlador.A_REMOVER_LIBRO);
		menuArchivo.add(itemRemoverLibro);
		itemEditarLibro = new JMenuItem(ConstantesGUI.T_MENU_ITEM_EDITAR_LIBRO);
		itemEditarLibro.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_EDITAR));
		itemEditarLibro.setActionCommand(Controlador.A_MOSTAR_EDITAR_LIBRO);
		itemEditarLibro.addActionListener(controlador);
		menuArchivo.add(itemEditarLibro);

		itemAgregarAutor = new JMenuItem(ConstantesGUI.T_MENU_ITEM_AGREGAR_AUTOR);
		itemAgregarAutor.addActionListener(controlador);
		itemAgregarAutor.setActionCommand(Controlador.A_MOSTAR_AGREGAR_AUTOR);
		itemAgregarAutor.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_NUEVO_AUTOR));
		menuArchivo.add(itemAgregarAutor);		
		itemRemoverAutor = new JMenuItem(ConstantesGUI.T_MENU_ITEM_REMOVER_AUTOR);
		itemRemoverAutor.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_ELIMINAR_AUTOR));
		itemRemoverAutor.addActionListener(controlador);
		itemRemoverAutor.setActionCommand(Controlador.A_REMOVER_AUTOR);
		menuArchivo.add(itemRemoverAutor);
		itemEditarAutor = new JMenuItem(ConstantesGUI.T_MENU_ITEM_EDITAR_AUTOR);
		itemEditarAutor.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_EDITAR));
		itemEditarAutor.setActionCommand(Controlador.A_MOSTAR_EDITAR_AUTOR);
		itemEditarAutor.addActionListener(controlador);
		menuArchivo.add(itemEditarAutor);

		itemAgregarCliente= new JMenuItem(ConstantesGUI.T_MENU_ITEM_AGREGAR_CLIENTE);
		itemAgregarCliente.addActionListener(controlador);
		itemAgregarCliente.setActionCommand(Controlador.A_MOSTRAR_DIALOGO_AGREGAR_CLIENTE);
		itemAgregarCliente.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_NUEVO_CLIENTE));
		menuArchivo.add(itemAgregarCliente);		
		itemRemoverCliente = new JMenuItem(ConstantesGUI.T_MENU_ITEM_REMOVER_CLIENTE);
		itemRemoverCliente.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_ELIMINAR_CLIENTE));
		itemRemoverCliente.addActionListener(controlador);
		itemRemoverCliente.setActionCommand(Controlador.A_REMOVER_CLIENTE);
		menuArchivo.add(itemRemoverCliente);
		itemEditarCliente = new JMenuItem(ConstantesGUI.T_MENU_ITEM_EDITAR_CLIENTE);
		itemEditarCliente.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_EDITAR));
		itemEditarCliente.addActionListener(controlador);
		itemEditarCliente.setActionCommand(Controlador.A_MOSTAR_EDITAR_CLIENTE);
		menuArchivo.add(itemEditarCliente);

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

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
	private JMenu menuAgregar;
	private JMenu menuEditar;
	private JMenu menuEliminar;
	private JMenuItem itemEditarLibro;
	private JMenuItem itemRemoverLibro;
	private JMenuItem itemAgregarLibro;
	private JMenuItem itemEditarAutor;
	private JMenuItem itemRemoverAutor;
	private JMenuItem itemAgregarAutor;
	private JMenuItem itemEditarCliente;
	private JMenuItem itemRemoverCliente;
	private JMenuItem itemAgregarCliente;
	private JMenuItem itemSalir;
	private JMenu menuEstadisticas;
	private JMenu menuPreferencias;
	private JMenu menuAyuda;

	public BarraMenuAdm(Controlador controlador) {
		
		menuArchivo = new JMenu(ConstantesGUI.T_MENU_ARCHIVO);
		menuAgregar = new JMenu(ConstantesGUI.T_MENU_AGREGAR_DE_ARCHIVO);
		menuAgregar.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_NUEVO_LIBRO));
		itemAgregarLibro = new JMenuItem(ConstantesGUI.T_MENU_ITEM_AGREGAR_lIBRO);
		itemAgregarLibro.addActionListener(controlador);
		itemAgregarLibro.setActionCommand(Controlador.A_MOSTRAR_DIALOGO_AGREGAR_LIBRO);
		
		itemAgregarAutor = new JMenuItem(ConstantesGUI.T_MENU_ITEM_AGREGAR_AUTOR);
		itemAgregarAutor.addActionListener(controlador);
		itemAgregarAutor.setActionCommand(Controlador.A_MOSTAR_AGREGAR_AUTOR);
		
		itemAgregarCliente= new JMenuItem(ConstantesGUI.T_MENU_ITEM_AGREGAR_CLIENTE);
		itemAgregarCliente.addActionListener(controlador);
		itemAgregarCliente.setActionCommand(Controlador.A_MOSTRAR_DIALOGO_AGREGAR_CLIENTE);
	
		menuAgregar.add(itemAgregarCliente);		
		menuAgregar.add(itemAgregarAutor);		
		menuAgregar.add(itemAgregarLibro);	
		menuArchivo.add(menuAgregar);
		
		menuEditar = new JMenu(ConstantesGUI.T_MENU_EDITAR_DE_MENU);
		menuEditar.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_EDITAR));
		itemEditarAutor = new JMenuItem(ConstantesGUI.T_MENU_ITEM_EDITAR_AUTOR);
		itemEditarAutor.setActionCommand(Controlador.A_MOSTAR_EDITAR_AUTOR);
		itemEditarAutor.addActionListener(controlador);
	
		itemEditarLibro = new JMenuItem(ConstantesGUI.T_MENU_ITEM_EDITAR_LIBRO);
		itemEditarLibro.setActionCommand(Controlador.A_MOSTAR_EDITAR_LIBRO);
		itemEditarLibro.addActionListener(controlador);
		
		itemEditarCliente = new JMenuItem(ConstantesGUI.T_MENU_ITEM_EDITAR_CLIENTE);
		itemEditarCliente.addActionListener(controlador);
		itemEditarCliente.setActionCommand(Controlador.A_MOSTAR_EDITAR_CLIENTE);
		
		menuEditar.add(itemEditarCliente);
		menuEditar.add(itemEditarLibro);
		menuEditar.add(itemEditarAutor);
		menuArchivo.add(menuEditar);
		
		menuEliminar = new JMenu(ConstantesGUI.T_MENU_ELIMINAR_DE_MENU);
		menuEliminar.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_ELIMINAR_CLIENTE));
		itemRemoverLibro = new JMenuItem(ConstantesGUI.T_MENU_ITEM_REMOVER_LIBRO);
		itemRemoverLibro.addActionListener(controlador);
		itemRemoverLibro.setActionCommand(Controlador.A_REMOVER_LIBRO);
		
		itemRemoverAutor = new JMenuItem(ConstantesGUI.T_MENU_ITEM_REMOVER_AUTOR);
		itemRemoverAutor.addActionListener(controlador);
		itemRemoverAutor.setActionCommand(Controlador.A_REMOVER_AUTOR);
		
		itemRemoverCliente = new JMenuItem(ConstantesGUI.T_MENU_ITEM_REMOVER_CLIENTE);
		itemRemoverCliente.addActionListener(controlador);
		itemRemoverCliente.setActionCommand(Controlador.A_REMOVER_CLIENTE);

		menuEliminar.add(itemRemoverCliente);
		menuEliminar.add(itemRemoverAutor);
		menuEliminar.add(itemRemoverLibro);
		menuArchivo.add(menuEliminar);

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

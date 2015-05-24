package vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import modelo.entidades.TipoBusqueda;
import controlador.Controlador;

public class BarraHerramientasAdm extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnNuevoLibro;
	private JButton btnBuscarLibro;
	private JTextField txBuscarLibro;
	private JComboBox<String> listaBusqueda;
	private JButton btnEliminar;
	private JButton btnNuevoAutor;
	private JButton btnNuevoCliente;
	private JButton btnRemoverAutor;
	private JButton btnRemoverCliente;
	
	public BarraHerramientasAdm(Controlador controlador) {
		setEnabled(false);
		btnNuevoLibro = new JButton();
		btnNuevoLibro.setToolTipText(ConstantesGUI.T_MENU_ITEM_AGREGAR_lIBRO);
		btnNuevoLibro.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_NUEVO_LIBRO));
		btnNuevoLibro.addActionListener(controlador);
		btnNuevoLibro.setActionCommand(Controlador.A_MOSTRAR_DIALOGO_AGREGAR_LIBRO);
		add(btnNuevoLibro);

		btnEliminar = new JButton();
		btnEliminar.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_ELIMINAR_LIBRO));
		btnEliminar.setToolTipText(ConstantesGUI.T_MENU_ITEM_REMOVER_LIBRO);
		btnEliminar.addActionListener(controlador);
		btnEliminar.setActionCommand(Controlador.A_REMOVER_LIBRO);
		add(btnEliminar);

		
		btnNuevoAutor = new JButton();
		btnNuevoAutor.setToolTipText(ConstantesGUI.T_MENU_ITEM_AGREGAR_AUTOR);
		btnNuevoAutor.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_NUEVO_AUTOR));
		btnNuevoAutor.addActionListener(controlador);
		btnNuevoAutor.setActionCommand(Controlador.A_MOSTAR_AGREGAR_AUTOR);
		add(btnNuevoAutor);
		
		btnRemoverAutor = new JButton();
		btnRemoverAutor.setToolTipText(ConstantesGUI.T_MENU_ITEM_REMOVER_AUTOR);
		btnRemoverAutor.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_ELIMINAR_AUTOR));
		btnRemoverAutor.addActionListener(controlador);
		btnRemoverAutor.setActionCommand(Controlador.A_REMOVER_AUTOR);
		add(btnRemoverAutor);
		
		btnNuevoCliente = new JButton();
		btnNuevoCliente.setToolTipText(ConstantesGUI.T_MENU_ITEM_AGREGAR_CLIENTE);
		btnNuevoCliente.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_NUEVO_CLIENTE));
		btnNuevoCliente.addActionListener(controlador);
		btnNuevoCliente.setActionCommand(Controlador.A_MOSTRAR_DIALOGO_AGREGAR_CLIENTE);
		add(btnNuevoCliente);
		
		btnRemoverCliente = new JButton();
		btnRemoverCliente.setToolTipText(ConstantesGUI.T_MENU_ITEM_REMOVER_CLIENTE);
		btnRemoverCliente.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_ELIMINAR_CLIENTE));
		btnRemoverCliente.addActionListener(controlador);
		btnRemoverCliente.setActionCommand(Controlador.A_REMOVER_CLIENTE);
		add(btnRemoverCliente);
		
		btnBuscarLibro = new JButton();
		btnBuscarLibro.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_BUSCAR));
		btnBuscarLibro.setToolTipText(ConstantesGUI.T_MENU_ITEM_BUSCAR_LIBRO);
		btnBuscarLibro.addActionListener(controlador);
		btnBuscarLibro.setActionCommand(Controlador.A_BUSCAR_LIBRO);
		add(btnBuscarLibro);
		txBuscarLibro = new JTextField();
		add(txBuscarLibro);
		
		listaBusqueda = new JComboBox<String>();
		listaBusqueda.addItem(TipoBusqueda.SELLECION_OPCION.toString());
		listaBusqueda.addItem(TipoBusqueda.LIBRO_NOMBRE.toString());
		listaBusqueda.addItem(TipoBusqueda.LIBRO_ID.toString());
		listaBusqueda.addItem(TipoBusqueda.AUTHOR_NOMBRE.toString());
		listaBusqueda.addItem(TipoBusqueda.AUTHOR_ID.toString());
		listaBusqueda.addItem(TipoBusqueda.CLIENTE_NOMBRE.toString());
		listaBusqueda.addItem(TipoBusqueda.CLIENTE_ID.toString());
		add(listaBusqueda);
	}
	
	public String tipoSeleccionBuscar(){
		String tipoBusqueda = (String)listaBusqueda.getSelectedItem();
		return tipoBusqueda;
	}
	
	protected ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			return null;
		}
	}

	public JTextField getTxBuscarLibro() {
		return txBuscarLibro;
	}

	public void setTxBuscarLibro(JTextField txBuscarLibro) {
		this.txBuscarLibro = txBuscarLibro;
	}
}

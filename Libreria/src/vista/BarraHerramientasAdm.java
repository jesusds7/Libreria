package vista;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import controlador.Controlador;

public class BarraHerramientasAdm extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnNuevoLibro;
	private JButton btnBuscarLibro;
	private JTextField txBuscarLibro;
	private JRadioButton rBtnNombreLibro;
	private JRadioButton rBtnIdLibro;
	protected ButtonGroup grupoBuscarLibro;
	private JButton btnEliminar;
	private JButton btnEditar;
	
	public BarraHerramientasAdm(Controlador controlador) {
		setEnabled(false);
		btnNuevoLibro = new JButton();
		btnNuevoLibro.setToolTipText(ConstantesGUI.T_MENU_ITEM_AGREGAR_lIBRO);
		btnNuevoLibro.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_NUEVO_LIBRO));
		btnNuevoLibro.addActionListener(controlador);
		btnNuevoLibro.setActionCommand(Controlador.A_MOSTAR_AGREGAR_LIBRO);
		add(btnNuevoLibro);

		btnEliminar = new JButton();
		btnEliminar.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_ELIMINAR_LIBRO));
		btnEliminar.setToolTipText(ConstantesGUI.T_MENU_ITEM_REMOVER_LIBRO);
		btnEliminar.addActionListener(controlador);
		btnEliminar.setActionCommand(Controlador.A_REMOVER_LIBRO);
		add(btnEliminar);

		btnEditar = new JButton();
		btnEditar.addActionListener(controlador);
		btnEditar.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_EDITAR));
		btnEditar.setToolTipText(ConstantesGUI.T_MENU_ITEM_EDITAR_LIBRO);
		btnEditar.setActionCommand(Controlador.A_MOSTAR_EDITAR_LIBRO);
		add(btnEditar);
		
		btnBuscarLibro = new JButton();
		btnBuscarLibro.setIcon(createImageIcon(ConstantesGUI.I_ICONO_BTN_BUSCAR));
		btnBuscarLibro.setToolTipText(ConstantesGUI.T_MENU_ITEM_BUSCAR_LIBRO);
		btnBuscarLibro.addActionListener(controlador);
		btnBuscarLibro.setActionCommand(Controlador.A_BUSCAR_LIBRO);
		add(btnBuscarLibro);
		txBuscarLibro = new JTextField();
		add(txBuscarLibro);
		
		grupoBuscarLibro = new ButtonGroup();
		rBtnNombreLibro = new JRadioButton(ConstantesGUI.T_RADIO_BTN_NOMBRE_LIBRO);
		rBtnNombreLibro.addActionListener(controlador);
		rBtnNombreLibro.setActionCommand(Controlador.A_BUSCAR_NOMBRE_LIBRO);
		grupoBuscarLibro.add(rBtnNombreLibro);
		add(rBtnNombreLibro);
		rBtnIdLibro = new JRadioButton(ConstantesGUI.T_RADIO_BTN_ID_LIBRO);
		rBtnIdLibro.addActionListener(controlador);
		rBtnIdLibro.setActionCommand(Controlador.A_BUSCAR_ID_LIBRO);
		grupoBuscarLibro.add(rBtnIdLibro);
		add(rBtnIdLibro);		
		
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

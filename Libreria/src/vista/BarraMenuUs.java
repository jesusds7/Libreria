package vista;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import controlador.Controlador;

public class BarraMenuUs extends JMenuBar{

	private static final long serialVersionUID = 1L;

	private JMenu menuArchivo;

	private JMenuItem itemComprar;
	private JMenuItem itemBuscar;
	private JMenuItem itemMostrarLibros;

	public BarraMenuUs(Controlador controlador) {

		menuArchivo = new JMenu();
		menuArchivo.setText(ConstantesGUI.T_MENU_ARCHIVO_US);
		add(menuArchivo);

		itemMostrarLibros = new JMenuItem();
		itemMostrarLibros.setText(ConstantesGUI.T_MENU_ITEM_US_MOSTRAR_LIBROS);
		menuArchivo.add(itemMostrarLibros);

		itemComprar = new JMenuItem();
		itemComprar.setText(ConstantesGUI.T_MENU_ITEM_US_COMPRAR_LIBRO);
		menuArchivo.add(itemComprar);

		itemBuscar = new JMenuItem();
		itemBuscar.setText(ConstantesGUI.T_MENU_ITEM_US_BUSCAR_LIBRO);
		menuArchivo.add(itemBuscar);

	}

}

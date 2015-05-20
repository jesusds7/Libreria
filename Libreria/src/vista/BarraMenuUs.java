package vista;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.sun.jmx.mbeanserver.JmxMBeanServer;

import controlador.Controlador;

public class BarraMenuUs extends JMenuBar{

	private static final long serialVersionUID = 1L;
	
	private JMenu menuArchivo;
	
	private JMenuItem itemComprar;
	private JMenuItem itemBuscar;
	
	public BarraMenuUs(Controlador controlador) {
		
		menuArchivo = new JMenu();
		add(menuArchivo);
		
		itemComprar = new JMenuItem();
		menuArchivo.add(itemComprar);
		
		itemBuscar = new JMenuItem();
		menuArchivo.add(itemBuscar);
		
	}

}

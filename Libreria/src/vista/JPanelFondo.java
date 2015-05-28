package vista;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelFondo extends JPanel{

	private static final long serialVersionUID = 1L;
	
	ImageIcon imagen;
	String nombre;

	public JPanelFondo(String nombre) {
		this.nombre = nombre;
		imagen = new ImageIcon(nombre);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Dimension tamanio = getSize();
		g.drawImage(imagen.getImage(), 0, 0, tamanio.width, tamanio.height,
				null);
		setOpaque(false);
	}
}

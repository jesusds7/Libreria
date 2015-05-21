package vista;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelFotos extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rutaImagen;
	private String imagen;

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(rutaImagen != null){
			g.drawImage(new ImageIcon(rutaImagen).getImage() ,80, 150, this);
		}else {
			g.drawImage(new ImageIcon(imagen).getImage(), 200, 200, this);
		}
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
}

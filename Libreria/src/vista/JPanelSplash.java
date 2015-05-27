package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelSplash extends JPanel {

	private static final long serialVersionUID = 1L;

	private Image image;
   
    private JLabel jLabelVersion;

    public JPanelSplash() {
        super();
        this.setOpaque(false);
        this.setLayout(new GridLayout(5, 1));
        Font font = new Font("Alegrian", 25, 25);

        this.jLabelVersion = new JLabel();
        this.jLabelVersion.setForeground(Color.BLACK);
        this.jLabelVersion.setFont(new Font("Fixed Miriam Transparent", 25, 25));
       
        this.add(jLabelVersion);
    }

    public void setBackgroundImage(Image bgImage) {
        this.image = bgImage;
    }

    public ImageIcon createImage(String path) {
        URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("No se encuentra el archivo: " + path);
            return null;
        }
    }

    @Override
    public void paint(Graphics g) {
        Dimension tamanio = this.getSize();
        // Pintamos la imagen de fondo...
        if (image != null) {
            g.drawImage(image, 0, 0, tamanio.width, tamanio.height, null);
        }
        // Y pintamos el resto de cosas que pueda tener el panel
        super.paint(g);

    }
}


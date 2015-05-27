package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JProgressBar;
import javax.swing.JWindow;

import controlador.Controlador;

public class SplashLibrary extends JWindow implements Runnable{

	private static final long serialVersionUID = 1L;
	private Thread thread;
    private JProgressBar jProgressBarMain;
    private JPanelSplash jPanelInformation;
    private Controlador controlador = new Controlador();
	private int[] auxVariables;

    public SplashLibrary() {
        super();
	this.setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.3), (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.3));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setAlwaysOnTop(true);
        this.setBackground(Color.BLUE);
        this.jProgressBarMain = new JProgressBar();
        this.jProgressBarMain.setIndeterminate(true);
        this.jPanelInformation = new JPanelSplash();
        this.jPanelInformation.setBackgroundImage(jPanelInformation.createImage("/imagenes/lib.jpg").getImage());
        this.jPanelInformation.setBackground(Color.blue);
        this.add(jPanelInformation, BorderLayout.CENTER);
        this.add(jProgressBarMain, BorderLayout.SOUTH);
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        this.setVisible(true);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.dispose();
        setAuxVariables(new int[5]);
       DialogoInicio jFrameLibrary = new DialogoInicio(controlador);
        jFrameLibrary.setVisible(true);
    }

	public int[] getAuxVariables() {
		return auxVariables;
	}

	public void setAuxVariables(int[] auxVariables) {
		this.auxVariables = auxVariables;
	}
}

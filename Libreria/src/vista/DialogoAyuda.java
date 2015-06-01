package vista;


import javax.swing.JDialog;

import controlador.Controlador;

public class DialogoAyuda extends JDialog {
	
	private static final long serialVersionUID = 1L;

	public DialogoAyuda(Controlador controlador) {
		setTitle(ConstantesGUI.TITULO_DIAL_AYUD);
		setSize(ConstantesGUI.ANCH_DIAL_AYUD, ConstantesGUI.ALTO_DIA_ESTA);
		setLocationRelativeTo(null);
		setFocusable(true);
		setResizable(false);
		

	}

}

package vista;


import javax.swing.JDialog;
import java.awt.Toolkit;
import java.awt.Font;

public class DialogoEstadisticas extends JDialog {

	private static final long serialVersionUID = 1L;

	public DialogoEstadisticas() {
		setFont(new Font("Dialog", Font.PLAIN, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogoEstadisticas.class.getResource("/imagenes/iconoDialogoEstadisticas.png")));
		setLocationRelativeTo(null);
		setSize(ConstantesGUI.ANCHO_DIA_ESTA, ConstantesGUI.ALTO_DIA_ESTA);
		setFocusable(true);
		setTitle(ConstantesGUI.T_TITULO_DIA_ESTA);
	}
}
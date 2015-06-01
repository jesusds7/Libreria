package vista;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogoEstadisticas extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel pnlPrincipal;
	private JTextField txLibro1;
	private JTextField txLibro2;
	private JTextField txLibro3;
	private JLabel lblLibro1;
	private JLabel lblLibro2;
	private JLabel lblLibro3;
	private boolean bandera = false;

	public DialogoEstadisticas(Controlador controlador) {
		setFont(new Font("Dialog", Font.PLAIN, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogoEstadisticas.class.getResource("/imagenes/iconoDialogoEstadisticas.png")));
		setLocationRelativeTo(null);
		setSize(370, 400);
		setFocusable(true);
		setTitle(ConstantesGUI.T_TITULO_DIA_ESTA);
		setModal(true);

		pnlPrincipal = new JPanel();
		pnlPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlPrincipal);
		pnlPrincipal.setLayout(null);

		lblLibro1 = new JLabel("Libro 1:");
		lblLibro1.setBounds(46, 39, 61, 14);
		pnlPrincipal.add(lblLibro1);

		lblLibro2 = new JLabel("Libro 2:");
		lblLibro2.setBounds(46, 69, 61, 14);
		pnlPrincipal.add(lblLibro2);

		lblLibro3 = new JLabel("Libro 3:");
		lblLibro3.setBounds(46, 103, 61, 14);
		pnlPrincipal.add(lblLibro3);

		txLibro1 = new JTextField();
		txLibro1.setBounds(117, 36, 86, 20);
		pnlPrincipal.add(txLibro1);
		txLibro1.setColumns(10);

		txLibro2 = new JTextField();
		txLibro2.setBounds(117, 66, 86, 20);
		pnlPrincipal.add(txLibro2);
		txLibro2.setColumns(10);

		txLibro3 = new JTextField();
		txLibro3.setBounds(117, 97, 86, 20);
		pnlPrincipal.add(txLibro3);
		txLibro3.setColumns(10);

		JButton btnGraficar = new JButton(ConstantesGUI.BTN_GRAFICAR_DIALO_ESTADIS);
		btnGraficar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bandera = true;
				repaint();
			}
		});
		btnGraficar.setBounds(45, 138, 107, 37);
		pnlPrincipal.add(btnGraficar);
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (bandera == true) {
			String s1 = txLibro1.getText();
			String s2 = txLibro2.getText();
			String s3 = txLibro3.getText();
			int v1 = Integer.parseInt(s1);
			int v2 = Integer.parseInt(s2);
			int v3 = Integer.parseInt(s3);
			int suma = v1 + v2 + v3;
			int largo1 = v1 * 400 / suma;
			int largo2 = v2 * 400 / suma;
			int largo3 = v3 * 400 / suma;
			int porc1 = v1 * 100 / suma;
			int porc2 = v2 * 100 / suma;
			int porc3 = v3 * 100 / suma;

			g.setColor(new Color(255, 0, 0));
			g.fillRect(50, 250, largo1, 50);
			g.setColor(new Color(255, 255, 255));
			g.drawString(porc1 + "%", 55, 270);

			g.setColor(new Color(0, 128, 0));
			g.fillRect(50 + largo1, 250, largo2, 50);
			g.setColor(new Color(255, 255, 255));
			g.drawString(porc2 + "%", 55 + largo1, 270);

			g.setColor(new Color(0, 0, 255));
			g.fillRect(50 + largo1 + largo2, 250, largo3, 50);
			g.setColor(new Color(255, 255, 255));
			g.drawString(porc3 + "%", 55 + largo1 + largo2, 270);

		}
	}
}

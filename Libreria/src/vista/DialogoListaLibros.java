package vista;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.entidades.Libro;

public class DialogoListaLibros extends JDialog implements ListSelectionListener{

	private static final long serialVersionUID = 1L;
	private DefaultListModel<Libro> modeloLibro;
	private JList<Libro> listaLibros;
	private JButton btnComprar;
	
	public DialogoListaLibros() {
		setSize(500, 800);
		setTitle(ConstantesGUI.T_TITULO_DIAL_LISTA_LIBROS);
		setLocationRelativeTo(null);
		setModal(true);
		
		modeloLibro = new DefaultListModel<Libro>();
		listaLibros = new JList<>(modeloLibro);
		listaLibros.setBounds(50, 50, 200, 300);
		listaLibros.setBorder(BorderFactory.createTitledBorder("libros"));
		listaLibros.addListSelectionListener(this);
		add(listaLibros);
	}
	
	public void agregarLibroLista(Libro libro) {
		modeloLibro.addElement(libro);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		
	}
}

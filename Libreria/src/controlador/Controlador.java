package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.dao.GestorAutor;
import modelo.dao.GestorCliente;
import modelo.dao.GestorLibro;
import modelo.entidades.Autor;
import modelo.entidades.Cliente;
import modelo.entidades.Libro;
import modelo.entidades.TipoBusqueda;
import modelo.entidades.TipoGenero;
import modelo.excepcionLibroNoEncontrado.ExcepcionLibroNoEncontrado;
import vista.DialogoAgregarAutor;
import vista.DialogoAgregarCliente;
import vista.DialogoAgregarLibro;
import vista.DialogoInicio;
import vista.EditDialogoAgregarLibro;
import vista.VentanaAdministrador;
import vista.VentanaUsuario;

public class Controlador extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String A_BTN_DIALOGO_ADMINISTRADOR = "DIALOGO_ADMINISTRADOR";
	public static final String A_MOSTAR_AGREGAR_LIBRO = "A_MOSTRAR_AGREGAR_LIBRO";
	public static final String A_MOSTAR_AGREGAR_AUTOR = "A_MOSTRAR_AGREGAR_AUTOR";
	public static final String A_REMOVER_LIBRO = "REMOVER_LIBRO";
	public static final String A_MOSTAR_EDITAR_LIBRO = "MOSTAR_EDITAR_LIBRO";
	public static final String A_BUSCAR_LIBRO = "BUSCAR_LIBRO";
	public static final String A_BUSCAR_NOMBRE_LIBRO = "RADIO_LIBRO";
	public static final String A_BUSCAR_ID_LIBRO = "RADIO_ID_LIBRO";
	public static final String A_BUSCAR_NOMBRE_USUARIO = "RADIO_USUARIO";
	public static final String A_BUSCAR_ID_USUARIO = "RADIO_ID_USUARIO";
	public static final String A_COMPRAR_LIBRO = "COMPRAR_LIBRO";
	public static final String A_BTN_DIALOGO_USUARIO = "VENTANA USARIO";
	public static final String A_AGREGAR_IMAGEN = "Agregar_imagen";
	public static final String A_AGREGAR_IMAGEN_AUTOR = "Agregar_imagen_AUTOR";
	public static final String A_CANCELAR_LIBRO = "CANCELAR_LIBRO";
	public static final String A_CANCELAR_AUTOR = "CANCELAR_AUTOR";
	public static final String A_CANCELAR_CLIENTE = "CANCELAR_CLIENTE";
	public static final String A_AGREGAR_LIBRO = "ACCION_AGREGAR_LIBRO";
	public static final String A_AGREGAR_AUTOR = "ACCION_AGREGAR_AUTOR";
	public static final String A_AGREGAR_CLIENTE = "ACCION_AGREGAR_CLIENTE";
	public static final String A_MOSTRAR_DIALOGO_AGREGAR_LIBRO = "ACCION_MOSTAR_AGREGAR_LIBRO";
	public static final String A_MOSTRAR_DIALOGO_AGREGAR_CLIENTE = "ACCION_MOSTAR_AGREGAR_CLIENTE";
	public static final String A_SALIR = "SALIR";
	public static final String A_EDITAR_LIBRO = "EDITAR_LIBRO";
	private VentanaAdministrador ventanaAdministrador;
	private DialogoInicio dialogoPrimario;
	private DialogoAgregarLibro dialogoAgregarLibro;
	private VentanaUsuario ventanaUsuario;
	private GestorLibro gestorLibro;
	private EditDialogoAgregarLibro editDialogoAgregarLibro;
	private DialogoAgregarAutor dialogoAgregarAutor;
	private GestorAutor gestorAutor;
	private GestorCliente gestorCliente;
	private DialogoAgregarCliente dialogoAgregarCliente;
	public Controlador() {
		gestorCliente = new GestorCliente();
		gestorLibro = new GestorLibro();
		gestorAutor = new GestorAutor();
		dialogoPrimario = new DialogoInicio(this);
		dialogoAgregarCliente = new DialogoAgregarCliente(ventanaAdministrador, this);
		dialogoAgregarLibro = new DialogoAgregarLibro(ventanaAdministrador, this);
		dialogoAgregarAutor = new DialogoAgregarAutor(ventanaAdministrador, this);
		editDialogoAgregarLibro = new EditDialogoAgregarLibro(ventanaAdministrador, this);
		ventanaAdministrador = new VentanaAdministrador(this);
		ventanaUsuario = new VentanaUsuario(this);
		dialogoPrimario.setVisible(true);
	}
	
	public static void main(String[] args) {
		Controlador controlador = new Controlador();
		controlador.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case A_BTN_DIALOGO_ADMINISTRADOR:
			ventanaAdministrador.setVisible(true);
			break;
		case A_BTN_DIALOGO_USUARIO:
			ventanaUsuario.setVisible(true);
			break;
		case A_MOSTRAR_DIALOGO_AGREGAR_LIBRO:
			dialogoAgregarLibro.setVisible(true);
			break;
		case A_AGREGAR_IMAGEN:
			dialogoAgregarLibro.obtenerRutaImagen();
			break;
		case A_CANCELAR_LIBRO:
			dialogoAgregarLibro.cancelar();
			break;
		case A_CANCELAR_AUTOR:
			dialogoAgregarAutor.cancelar();
			break;
		case A_CANCELAR_CLIENTE:
			dialogoAgregarCliente.cancelar();
			break;
		case A_SALIR:
			ventanaAdministrador.setVisible(false);
			break;
		case A_AGREGAR_LIBRO:
			agregarLibro();
			break;
		case A_REMOVER_LIBRO:
			try {
				borrarLibro();
			} catch (ExcepcionLibroNoEncontrado e1) {
				e1.printStackTrace();
			}
			break;
		case A_BUSCAR_LIBRO:
			try {
				seleccionarOpcionBuscar();
			} catch (ExcepcionLibroNoEncontrado e3) {
				e3.printStackTrace();
			}
			break;
		case A_MOSTAR_EDITAR_LIBRO:
			try {
				mostartDialogoEditarLibro();
			} catch (ExcepcionLibroNoEncontrado e2) {
				e2.printStackTrace();
			}
			break;
		case A_EDITAR_LIBRO:
			try {
				editarLibro();
			} catch (ExcepcionLibroNoEncontrado e1) {
				e1.printStackTrace();
			}
		case A_MOSTAR_AGREGAR_AUTOR:
			dialogoAgregarAutor.setVisible(true);
			break;
		case A_AGREGAR_AUTOR:
			agregarAutor();
			break;
		case A_MOSTRAR_DIALOGO_AGREGAR_CLIENTE:
			dialogoAgregarCliente.setVisible(true);
			break;
		case A_AGREGAR_CLIENTE:
			agregarCliente();
			break;
		default:
			break;
		}
	}
	
	public void mostartDialogoEditarLibro() throws ExcepcionLibroNoEncontrado{		
		editDialogoAgregarLibro.cambiarValores(buscarLibro(ventanaAdministrador.retornarIdSeleccion()));
		editDialogoAgregarLibro.setVisible(true);
	}

	
	public void editarLibro() throws ExcepcionLibroNoEncontrado{
		editDialogoAgregarLibro.editarLibro(buscarLibro(ventanaAdministrador.retornarIdSeleccion()));
		try {
			ventanaAdministrador.actualizarTabla(buscarLibro(ventanaAdministrador.retornarIdSeleccion()), ventanaAdministrador.retornarIdSeleccion());
			
		} catch (Exception e) {
		}
	}
	
	public void seleccionarOpcionBuscar()throws ExcepcionLibroNoEncontrado{
		String aux = ventanaAdministrador.getBarraHerramientas().tipoSeleccionBuscar();
		if(aux.equals(TipoBusqueda.LIBRO_NOMBRE.toString())){
			buscarLibroNombre();
		}else if (aux.equals(TipoBusqueda.LIBRO_ID.toString())) {
			buscarLibroId();
		}else if (aux.equals(TipoBusqueda.AUTHOR_NOMBRE.toString())) {
			
		}else if (aux.equals(TipoBusqueda.AUTHOR_ID.toString())) {
			
		}else if (aux.equals(TipoBusqueda.CLIENTE_NOMBRE.toString())) {
			
		}else if (aux.equals(TipoBusqueda.CLIENTE_ID.toString())) {
			
		}else if (aux.equals(TipoBusqueda.SELLECION_OPCION.toString())) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar una opcion de busqueda", "Advertencia", 2);
		}
	}

	public void buscarLibroId() throws ExcepcionLibroNoEncontrado {
		gestorLibro.buscarLibro(Integer.parseInt(ventanaAdministrador.getBarraHerramientas().getTxBuscarLibro().getText()));
		ventanaAdministrador.seleccionarLibro(Integer.parseInt(ventanaAdministrador.getBarraHerramientas().getTxBuscarLibro().getText()));
		ventanaAdministrador.getBarraHerramientas().getTxBuscarLibro().setText("");
	}	

	public void buscarLibroNombre() throws ExcepcionLibroNoEncontrado{
		gestorLibro.buscarLibro(ventanaAdministrador.getBarraHerramientas().getTxBuscarLibro().getText());
		ventanaAdministrador.seleccionarLibro(ventanaAdministrador.getBarraHerramientas().getTxBuscarLibro().getText());
		ventanaAdministrador.getBarraHerramientas().getTxBuscarLibro().setText("");
	}
	
	public void borrarLibro() throws ExcepcionLibroNoEncontrado {
		gestorLibro.removerLibro(buscarLibro(ventanaAdministrador.retornarIdSeleccion()));
		ventanaAdministrador.elimiarFila();
	}
	
	public Libro buscarLibro(int id) throws ExcepcionLibroNoEncontrado{
		return gestorLibro.buscarLibro(id);
	}
	
	public void agregarAutor(){
		Autor autor = dialogoAgregarAutor.crearAutor();
		crearAutor(autor);
	}
	
	public void crearAutor(Autor autor){
		if(autor != null){
			gestorAutor.agregarAutor(autor);
			ventanaAdministrador.agregarAutorTabla(autor);
		}
	}
	
	public void agregarCliente(){
		Cliente cliente = dialogoAgregarCliente.crearCliente();
		crearCliente(cliente);
	}
	
	public void crearCliente(Cliente cliente){
		if(cliente != null){
			gestorCliente.agregarCliente(cliente);
			ventanaAdministrador.agregarClienteTabla(cliente);
		}
	}
	
	public void agregarLibro(){
		TipoGenero genero = dialogoAgregarLibro.seleccionBox();
		Libro libro = dialogoAgregarLibro.crearLibro();
		crearLibro(libro, genero);
	}
	
	private void crearLibro(Libro libro, TipoGenero genero){
		if(libro != null){
			gestorLibro.agregarLibro(libro);
			ventanaAdministrador.agregarLibroTabla(libro, genero);
		}
	}
}

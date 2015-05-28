package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import persistencia.GestorArchivoXMLCliente;
import modelo.dao.GestorAutor;
import modelo.dao.GestorCliente;
import modelo.dao.GestorLibro;
import modelo.entidades.Autor;
import modelo.entidades.Cliente;
import modelo.entidades.Libro;
import modelo.entidades.TipoBusqueda;
import modelo.entidades.TipoGenero;
import modelo.excepcionLibroNoEncontrado.ExcepcionAutorNoEncontrado;
import modelo.excepcionLibroNoEncontrado.ExcepcionClienteNoEncontrado;
import modelo.excepcionLibroNoEncontrado.ExcepcionLibroNoEncontrado;
import vista.DialogoAgregarAutor;
import vista.DialogoAgregarCliente;
import vista.DialogoAgregarLibro;
import vista.DialogoInicio;
import vista.DialogoLoginUsuario;
import vista.EditDialogoAgregarAutor;
import vista.EditDialogoAgregarCliente;
import vista.EditDialogoAgregarLibro;
import vista.SplashLibrary;
import vista.VentanaAdministrador;
import vista.VentanaUsuario;

public class Controlador extends JPanel implements ActionListener {
	/**
	 * Clase donde se van a manejar todos los eventos de los 
	 * botones y de las tablas
	 */
	private static final long serialVersionUID = 1L;
	public static final String A_BTN_DIALOGO_ADMINISTRADOR = "DIALOGO_ADMINISTRADOR";
	public static final String A_MOSTAR_AGREGAR_LIBRO = "A_MOSTRAR_AGREGAR_LIBRO";
	public static final String A_MOSTAR_AGREGAR_AUTOR = "A_MOSTRAR_AGREGAR_AUTOR";
	public static final String A_REMOVER_LIBRO = "REMOVER_LIBRO";
	public static final String A_REMOVER_AUTOR = "REMOVER_AUTOR";
	public static final String A_REMOVER_CLIENTE = "REMOVER_CLIENTE";
	public static final String A_MOSTAR_EDITAR_LIBRO = "MOSTAR_EDITAR_LIBRO";
	public static final String A_MOSTAR_EDITAR_AUTOR = "MOSTAR_EDITAR_AUTOR";
	public static final String A_MOSTAR_EDITAR_CLIENTE = "MOSTAR_EDITAR_CLIENTE";
	public static final String A_BUSCAR_LIBRO = "BUSCAR_LIBRO";
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
	public static final String A_EDITAR_AUTOR = "EDITAR_AUTOR";
	public static final String A_EDITAR_CLIENTE = "EDITAR_CLIENTE";
	public static final String A_RDBUTTON_FILTRAR_AUTOR = "FILTRAR AUTOR EN USUARIO";
	public static final String A_RDBUTTON_FILTRAR_TITULO = "FILTRAR TITULO EN USUARIO";
	public static final String AC_BTN_VERIFICAR_Y_ENTRAR_POR_USUARIO = "VERIFICAR Y ENTRAR LOGIN USUARIO";
	public static final String AC_BTN_CANCELAR_DIALOGO = "Cancelar";
	private VentanaAdministrador ventanaAdministrador;
	private DialogoInicio dialogoPrimario;
	private DialogoAgregarLibro dialogoAgregarLibro;
	private VentanaUsuario ventanaUsuario;
	private GestorLibro gestorLibro;
	private EditDialogoAgregarLibro editDialogoAgregarLibro;
	private EditDialogoAgregarAutor editDialogoAgregarAutor;
	private EditDialogoAgregarCliente editDialogoAgregarCliente;
	private DialogoAgregarAutor dialogoAgregarAutor;
	private GestorAutor gestorAutor;
	private GestorCliente gestorCliente;
	private DialogoAgregarCliente dialogoAgregarCliente;
	private DialogoLoginUsuario dialogoLoginUsuario;
	public Controlador() {
		gestorCliente = new GestorCliente();
		gestorLibro = new GestorLibro();
		gestorAutor = new GestorAutor();
		dialogoPrimario = new DialogoInicio(this);
		dialogoAgregarCliente = new DialogoAgregarCliente(ventanaAdministrador, this);
		dialogoAgregarLibro = new DialogoAgregarLibro(ventanaAdministrador, this);
		dialogoAgregarAutor = new DialogoAgregarAutor(ventanaAdministrador, this);
		editDialogoAgregarLibro = new EditDialogoAgregarLibro(ventanaAdministrador, this);
		editDialogoAgregarAutor = new EditDialogoAgregarAutor(ventanaAdministrador, this);
		editDialogoAgregarCliente = new EditDialogoAgregarCliente(ventanaAdministrador, this);
		ventanaAdministrador = new VentanaAdministrador(this);
		ventanaUsuario = new VentanaUsuario(this);
//		dialogoPrimario.setVisible(true); Se hace un comentario para que salga primero el Splash luego el panel Principal
		dialogoLoginUsuario = new DialogoLoginUsuario(this);
		dialogoAgregarLibro.setNombreAutor(dialogoAgregarAutor.getTxtNombre().getText());
	}
	
	public static void main(String[] args) {
		SplashLibrary controlador = new SplashLibrary();
//		controlador.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case A_BTN_DIALOGO_ADMINISTRADOR:
			ventanaAdministrador.setVisible(true);
			break;
		case A_BTN_DIALOGO_USUARIO:
			dialogoLoginUsuario.setVisible(true);
			break;
		case AC_BTN_VERIFICAR_Y_ENTRAR_POR_USUARIO:
			ventanaUsuario.setVisible(true);
			dialogoLoginUsuario.dispose();
			break;
		case A_MOSTRAR_DIALOGO_AGREGAR_LIBRO:
			dialogoAgregarLibro.setVisible(true);
			break;
		case A_AGREGAR_IMAGEN:
			dialogoAgregarLibro.obtenerRutaImagen();
			break;
		case A_CANCELAR_LIBRO:
			dialogoAgregarLibro.cancelar();
			dialogoAgregarLibro.setVisible(false);
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
			dialogoAgregarLibro.dispose();
			break;
		case A_REMOVER_LIBRO:
			try {
				borrarLibro();
			} catch (ExcepcionLibroNoEncontrado e1) {
				e1.printStackTrace();
			}
			break;
		case A_REMOVER_AUTOR:
			try {
				borrarAutor();
			} catch (ExcepcionAutorNoEncontrado e4) {
				e4.printStackTrace();
			}
			break;
		case A_REMOVER_CLIENTE:
			try {
				borrarCliente();
			} catch (ExcepcionClienteNoEncontrado e4) {
				e4.printStackTrace();
			}
			break;
		case A_BUSCAR_LIBRO:
			try {
				seleccionarOpcionBuscar();
			} catch (ExcepcionLibroNoEncontrado | ExcepcionAutorNoEncontrado
					| ExcepcionClienteNoEncontrado e3) {
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
			break;
		case A_MOSTAR_EDITAR_AUTOR:
			try {
				mostarDialogoEditarAutor();
			} catch (ExcepcionAutorNoEncontrado e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case A_EDITAR_AUTOR:
			try {
				editarAutor();
			} catch (ExcepcionAutorNoEncontrado e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case A_MOSTAR_EDITAR_CLIENTE:
			try {
				mostrarDialogoEditarCliente();
			} catch (ExcepcionClienteNoEncontrado e1) {
				e1.printStackTrace();
			}
			break;
		case A_EDITAR_CLIENTE:
			try {
				editarCliente();
			} catch (ExcepcionClienteNoEncontrado e1) {
				e1.printStackTrace();
			}
			break;
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
			GestorArchivoXMLCliente.exportarArchivoXML(dialogoAgregarCliente.crearCliente());
			break;
		default:
			break;
//		case A_RDBUTTON_FILTRAR_AUTOR:
//			ventanaUsuario.filtrarAutor();
//			break;
		case AC_BTN_CANCELAR_DIALOGO:
			dialogoLoginUsuario.setVisible(false);
		case A_AGREGAR_IMAGEN_AUTOR:
			dialogoAgregarAutor.importarImagenAutor();
		}
	}
	
	
	public void mostartDialogoEditarLibro() throws ExcepcionLibroNoEncontrado{		
		editDialogoAgregarLibro.cambiarValores(buscarLibro(ventanaAdministrador.retornarIdSeleccionLibro()));
		editDialogoAgregarLibro.setVisible(true);
	}
	
	public void mostarDialogoEditarAutor()throws ExcepcionAutorNoEncontrado{
		editDialogoAgregarAutor.cambiarValores(buscarAutor(ventanaAdministrador.retornarIdSeleccionAutor()));
		editDialogoAgregarAutor.setVisible(true);
	}
	
	public void mostrarDialogoEditarCliente()throws ExcepcionClienteNoEncontrado{
		editDialogoAgregarCliente.cambiarValores(buscarCliente(ventanaAdministrador.retornarIdSeleccionCliente()));
		editDialogoAgregarCliente.setVisible(true);
	}

	
	public void editarLibro() throws ExcepcionLibroNoEncontrado{
		editDialogoAgregarLibro.editarLibro(buscarLibro(ventanaAdministrador.retornarIdSeleccionLibro()));
			ventanaAdministrador.actualizarTablaLibro(buscarLibro(ventanaAdministrador.retornarIdSeleccionLibro()), ventanaAdministrador.retornarIdSeleccionLibro());
	}
	
	public void editarAutor()throws ExcepcionAutorNoEncontrado{
		editDialogoAgregarAutor.editarAutor(buscarAutor(ventanaAdministrador.retornarIdSeleccionAutor()));
		ventanaAdministrador.actualizarTablaAutor(buscarAutor(ventanaAdministrador.retornarIdSeleccionAutor()), ventanaAdministrador.retornarIdSeleccionAutor());
	}
	
	public void editarCliente()throws ExcepcionClienteNoEncontrado{
		editDialogoAgregarCliente.editarCliente(buscarCliente(ventanaAdministrador.retornarIdSeleccionCliente()));
		ventanaAdministrador.actualizarTablaCliente(buscarCliente(ventanaAdministrador.retornarIdSeleccionCliente()),ventanaAdministrador.retornarIdSeleccionCliente());
	}
	
	public void seleccionarOpcionBuscar()throws ExcepcionLibroNoEncontrado, ExcepcionAutorNoEncontrado, ExcepcionClienteNoEncontrado{
		String aux = ventanaAdministrador.getBarraHerramientas().tipoSeleccionBuscar();
		if(aux.equals(TipoBusqueda.LIBRO_NOMBRE.toString())){
			buscarLibroNombre();
		}else if (aux.equals(TipoBusqueda.LIBRO_ID.toString())) {
			buscarLibroId();
		}else if (aux.equals(TipoBusqueda.AUTHOR_NOMBRE.toString())) {
			buscarAutorNombre();
		}else if (aux.equals(TipoBusqueda.AUTHOR_ID.toString())) {
			buscarAutorId();
		}else if (aux.equals(TipoBusqueda.CLIENTE_NOMBRE.toString())) {
			buscarClienteNombre();
		}else if (aux.equals(TipoBusqueda.CLIENTE_ID.toString())) {
			buscarClienteId();
		}else if (aux.equals(TipoBusqueda.SELLECION_OPCION.toString())) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar una opcion de busqueda", "Advertencia", 2);
		}
	}
	
	public String selecionBarraHerraientas(){
		return ventanaAdministrador.getBarraHerramientas().getTxBuscar().getText();
	}
	
	public void limpiarCampoBuscar(){
		ventanaAdministrador.getBarraHerramientas().getTxBuscar().setText("");
	}

	public void buscarLibroId() throws ExcepcionLibroNoEncontrado {
		gestorLibro.buscarLibro(Integer.parseInt(selecionBarraHerraientas()));
		ventanaAdministrador.seleccionarLibro(Integer.parseInt(selecionBarraHerraientas()));
		limpiarCampoBuscar();
	}	

	public void buscarLibroNombre() throws ExcepcionLibroNoEncontrado{
		gestorLibro.buscarLibro(selecionBarraHerraientas());
		ventanaAdministrador.seleccionarLibro(selecionBarraHerraientas());
		limpiarCampoBuscar();
	}
	
	public void buscarAutorId()throws ExcepcionAutorNoEncontrado{
		gestorAutor.buscarAutor(Integer.parseInt(selecionBarraHerraientas()));
		ventanaAdministrador.seleccionarAutor(Integer.parseInt(selecionBarraHerraientas()));
		limpiarCampoBuscar();
	}
	
	public void buscarAutorNombre()throws ExcepcionAutorNoEncontrado{
		gestorAutor.buscarAutor(selecionBarraHerraientas());
		ventanaAdministrador.seleccionarAutor(selecionBarraHerraientas());
		limpiarCampoBuscar();
	}
	
	public void buscarClienteId()throws ExcepcionClienteNoEncontrado{
		gestorCliente.buscarCliente(Integer.parseInt(selecionBarraHerraientas()));
		ventanaAdministrador.seleccionarCliente(Integer.parseInt(selecionBarraHerraientas()));
		limpiarCampoBuscar();
	}
	
	public void buscarClienteNombre()throws ExcepcionClienteNoEncontrado{
		gestorCliente.buscarCliente(selecionBarraHerraientas());
		ventanaAdministrador.seleccionarCliente(selecionBarraHerraientas());
		limpiarCampoBuscar();
	}
	
	public void borrarLibro() throws ExcepcionLibroNoEncontrado {
		gestorLibro.removerLibro(buscarLibro(ventanaAdministrador.retornarIdSeleccionLibro()));
		ventanaAdministrador.elimiarFilaLibro();
	}
	
	public void borrarAutor()throws ExcepcionAutorNoEncontrado{
		gestorAutor.removerAutor(buscarAutor(ventanaAdministrador.retornarIdSeleccionAutor()));
		ventanaAdministrador.elimiarFilaAutor();
	}
	
	public void borrarCliente()throws ExcepcionClienteNoEncontrado{
		gestorCliente.removerCliente(buscarCliente(ventanaAdministrador.retornarIdSeleccionCliente()));
		ventanaAdministrador.elimiarFilaCliente();
	}
	
	public Libro buscarLibro(int id) throws ExcepcionLibroNoEncontrado{
		return gestorLibro.buscarLibro(id);
	}
	
	public Autor buscarAutor(int id)throws ExcepcionAutorNoEncontrado{
		return gestorAutor.buscarAutor(id);
	}
	
	public Cliente buscarCliente(int id)throws ExcepcionClienteNoEncontrado{
		return gestorCliente.buscarCliente(id);
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

package modelo.dao;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import vista.DialogoLoginUsuario;
import modelo.entidades.Cliente;
import modelo.util.Util;

/**
 * @author JESUS
 */


public class GestorCliente {

	private final ArrayList <Cliente> listaClientes;
	private final HashMap<String, String> listaUsuarios;
	
	private DialogoLoginUsuario dialogoLoginUsuario;
	

	public GestorCliente() {
		listaClientes = new ArrayList<Cliente>();
		listaUsuarios = new HashMap<String, String>();
	}

	public void agregarCliente(Cliente nuevoCliente){
		listaClientes.add(nuevoCliente);
		listaUsuarios.put(nuevoCliente.getNombre(), nuevoCliente.getContrasenia());
	}

	public void removerCliente(Cliente cliente){
		listaClientes.remove(cliente);
		listaUsuarios.remove(cliente);
	}

	public Cliente buscarCliente(int id){
		for (Cliente cliente: listaClientes) {
			if (cliente.getId() == id) {
				return cliente;
			}
		}
		return null;
	}

	public Cliente buscarCliente(String nombre){
		for (Cliente cliente: listaClientes) {
			if (cliente.getNombre().equals(nombre)) {
				return cliente;
			}
		}
		return null;
	}

	public static Cliente crearCliente(String nombre, String dinero, String usuario, String contrasenia) {
		if (Util.validarDinero(dinero)) {
			return new Cliente(nombre,Double.parseDouble(dinero), usuario, contrasenia);
		}
		return null;
	}
}

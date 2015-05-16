package modelo.dao;

import java.util.ArrayList;

/**
 * @author JESUS
 */

import modelo.entidades.Cliente;
import modelo.util.Util;

public class GestorCliente {
	
	private final ArrayList <Cliente> listaClientes;
	
	public GestorCliente() {
		
		listaClientes = new ArrayList<Cliente>();
		
	}
	
	public void agregarLibro(Cliente nuevoCliente){
		listaClientes.add(nuevoCliente);
	}
	
	public void removerCliente(Cliente cliente){
		listaClientes.remove(cliente);
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
	
	public static Cliente crearCliente(String nombre,String dinero) {
		if (Util.validarDinero(dinero)) {
			return new Cliente(nombre,Double.parseDouble(dinero));
		}
		return null;
	}

}

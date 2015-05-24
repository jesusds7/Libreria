package modelo.dao;

import java.util.ArrayList;
import modelo.entidades.Autor;
import modelo.excepcionLibroNoEncontrado.ExcepcionAutorNoEncontrado;

public class GestorAutor {
	private ArrayList<Autor> listaAutores;

	public GestorAutor() {
		listaAutores = new ArrayList<Autor>();
	}

	public void agregarAutor(Autor autor){
		listaAutores.add(autor);
	}

	public void removerAutor(Autor autor){
		listaAutores.remove(autor);
	}

	public Autor crearAutor(String nombre, String imagen){
		return new Autor(nombre, imagen);
	}

	public Autor buscarAutor(int id)throws ExcepcionAutorNoEncontrado {
		for (Autor autor : listaAutores) {
			if(autor.getId() == id){
				return autor;
			}
		}
		throw new ExcepcionAutorNoEncontrado(id);
	}

	public Autor buscarAutor(String nombre)throws ExcepcionAutorNoEncontrado {
		for (Autor autor : listaAutores) {
			if(autor.getNombre().equalsIgnoreCase(nombre)){
				return autor;
			}
		}
		throw new ExcepcionAutorNoEncontrado(nombre);
	}

	public ArrayList<Autor> getListaAutores() {
		return listaAutores;
	}

	public void setListaAutores(ArrayList<Autor> listaAutores) {
		this.listaAutores = listaAutores;
	}
}

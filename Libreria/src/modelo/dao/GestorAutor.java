package modelo.dao;

import java.util.ArrayList;

import modelo.entidades.Autor;

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

	public ArrayList<Autor> getListaAutores() {
		return listaAutores;
	}

	public void setListaAutores(ArrayList<Autor> listaAutores) {
		this.listaAutores = listaAutores;
	}


}

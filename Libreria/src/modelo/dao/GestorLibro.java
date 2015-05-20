package modelo.dao;

import java.util.ArrayList;

import modelo.entidades.Autor;
import modelo.entidades.Libro;
import modelo.entidades.TipoGenero;
import modelo.excepcionLibroNoEncontrado.ExcepcionLibroNoEncontrado;

public class GestorLibro {
	private ArrayList<Libro> listaLibros;

	public GestorLibro() {
		listaLibros = new ArrayList<Libro>();
	}

	public void agregarLibro(Libro libro){
		listaLibros.add(libro);
	}

	public static Libro crearLibro(String nombre, String descripcion, String imagen, int numeroCopias, double precio, String autor, TipoGenero tipoGenero){
		return new Libro(nombre, descripcion, imagen, numeroCopias, precio, autor, tipoGenero);
	}

	public void removerLibro(Libro libro){
		listaLibros.remove(libro);
	}

	public Libro buscarLibro(int id)throws ExcepcionLibroNoEncontrado {
		for (Libro libro : listaLibros) {
			if(libro.getId() == id){
				return libro;
			}
		}
		throw new ExcepcionLibroNoEncontrado(id);
	}

	public Libro buscarLibro(String nombre)throws ExcepcionLibroNoEncontrado{
		for (Libro libro : listaLibros) {
			if(libro.getNombre().equalsIgnoreCase(nombre)){
				return libro;
			}
		}
		throw new ExcepcionLibroNoEncontrado(nombre);
	}

	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(ArrayList<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}
}

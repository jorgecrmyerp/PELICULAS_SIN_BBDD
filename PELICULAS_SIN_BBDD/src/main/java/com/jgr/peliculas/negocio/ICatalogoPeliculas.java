package com.jgr.peliculas.negocio;

/**
 * @author DARTH_VADER
 *Interfaz para acceder al catalogo de peliculas
 */
public interface ICatalogoPeliculas {
	
	
	void agregarPelicula(String nombrePelicula, String nombreArchivo);
	void listaPeliculas(String nombreArchivo);
	void buscarPelicula(String nombreArchivo, String buscar);
	void iniciarArchivo(String nombreArchivo);

}

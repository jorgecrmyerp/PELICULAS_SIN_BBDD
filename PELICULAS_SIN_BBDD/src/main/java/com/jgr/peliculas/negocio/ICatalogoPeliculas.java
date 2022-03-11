package com.jgr.peliculas.negocio;

/**
 * @author DARTH_VADER
 *Interfaz para gestionar las peliculas,aqui se trataria el negocio en si mismo
 */
public interface ICatalogoPeliculas {
	

	public static final  String NOMBRE_RECURSO = "peliculas.txt";	
	/**
	 * añade pelicula
	 * @param nombre pelicula
	 * @return nada
	 */
	void agregaPelicula(String pelicula);
	/**
	 * lista peliculas
	 * @param nada
	 * @return nada
	 */
	void listaPeliculas();
	/**
	 * busca peliculas
	 * @param string nombre pelicula
	 * @return nada
	 */
	void buscaPelicula(String buscar);
	
	/**
	 * reinicia catalogo
	 * @param nada
	 * @return nada
	 */
	 void iniciaCatalogoPeliculas();
}

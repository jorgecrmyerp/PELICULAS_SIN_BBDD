package com.jgr.peliculas.negocio;

import com.jgr.peliculas.excepciones.AccesoDatosEx;

/**
 * @author DARTH_VADER
 *Interfaz para acceder al catalogo de peliculas,aqui se trataria el dispositivo fisico que lo guarda,fichero,bbdd....
 */
public interface ICatalogoPeliculas {
	
	
	void agregarPelicula(String nombrePelicula, String nombreRecurso)  throws AccesoDatosEx;
	void listaPeliculas(String nombreRecurso)  throws AccesoDatosEx;
	void buscarPelicula(String nombreRecurso, String buscar);
	void iniciarArchivo(String nombreRecurso)  throws AccesoDatosEx;

}

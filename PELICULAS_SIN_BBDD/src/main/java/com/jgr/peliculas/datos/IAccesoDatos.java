package com.jgr.peliculas.datos;

import java.util.List;

import com.jgr.peliculas.domain.Pelicula;


/**
 * @author DARTH_VADER
 *Interfaz para acceso datos, defino metodos 
 *existe-> busca si existe o no el archivo
 *listar->lista de peliculas con ese nombre
 *escribir->recibe pelicula,nombre archivo y si hay que añadir o no
 *buscar->a partir del nombre de archivo busca si existe esa pelicula
 *crear->alta de fichero para guardar peliculas
 *borrar->borra el fichero
 */
public interface IAccesoDatos {
	
	boolean existe(String nombreArchivo);
	List<Pelicula> listar(String nombre);
	void escribir(Pelicula pelicula,String nombreArchivo,boolean anexar);
	String buscar(String nombreArchivo,String buscar);
	void crear(String nombreArchivo);
	void borrar(String nombreArchivo);
	

}

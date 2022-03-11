package com.jgr.peliculas.datos;

import java.util.List;

import com.jgr.peliculas.domain.Pelicula;
import com.jgr.peliculas.excepciones.AccesoDatosEx;
import com.jgr.peliculas.excepciones.EscrituraDatosEx;
import com.jgr.peliculas.excepciones.LecturaDatosEx;


/**
 * @author DARTH_VADER
 *Interfaz para acceso fisico a datos (bbdd/fichero), defino metodos 
 *existe: busca si existe o no el archivo
 *listar:lista de peliculas con ese nombre
 *escribir:recibe pelicula,nombre archivo y si hay que a�adir o no
 *buscar:a partir del nombre de archivo busca si existe esa pelicula
 *crear:alta de fichero para guardar peliculas
 *borrar:borra el fichero
 */

public interface IAccesoDatos {
	
	
	/**
	 * devuelve si existe o no el recurso
	 * @param nombre recurso al que se accede(bbdd/fichero)
	 * @return boolean existe o no
	 */
    boolean existe(String nombreRecurso) throws AccesoDatosEx;
    
    /**
	 *lista las peliculas que coinciden con lo que se pasa por parametro
	 * @param nombre recurso al que se accede(bbdd/fichero)
	 * @return lista de peliculas
	 */
    List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;
    
    /**
	 *escribe pelicula 
	 * @param nombre pelicula,donde se guarda(fichero/bbdd) y si se añade o se sobreescribe 
	 * @return nada
	 */
    void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;
    
    /**
	 *busca pelicula 
	 * @param donde se guarda(fichero/bbdd),nombre pelicula string a buscar 
	 * @return string
	 */
    String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;
    
    /**
	 *crea recurso 
	 * @param donde se guarda(fichero/bbdd) 
	 * @return nada
	 */
    void crear(String nombreRecurso) throws AccesoDatosEx;
    
    /**
	 *borra recurso 
	 * @param nombre recurso a borrar(fichero/bbdd) 
	 * @return nada
	 */
    void borrar(String nombreRecurso) throws AccesoDatosEx;
}

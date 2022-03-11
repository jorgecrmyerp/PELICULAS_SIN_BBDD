package com.jgr.peliculas.datos;

import java.util.List;

import com.jgr.peliculas.domain.Pelicula;
import com.jgr.peliculas.excepciones.AccesoDatosEx;
import com.jgr.peliculas.excepciones.EscrituraDatosEx;
import com.jgr.peliculas.excepciones.LecturaDatosEx;


/**
 * @author DARTH_VADER
 *Interfaz para acceso datos, defino metodos 
 *existe: busca si existe o no el archivo
 *listar:lista de peliculas con ese nombre
 *escribir:recibe pelicula,nombre archivo y si hay que a�adir o no
 *buscar:a partir del nombre de archivo busca si existe esa pelicula
 *crear:alta de fichero para guardar peliculas
 *borrar:borra el fichero
 */

public interface IAccesoDatos {

    boolean existe(String nombreRecurso) throws AccesoDatosEx;

    List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;

    void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;

    String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;

    void crear(String nombreRecurso) throws AccesoDatosEx;

    void borrar(String nombreRecurso) throws AccesoDatosEx;
}

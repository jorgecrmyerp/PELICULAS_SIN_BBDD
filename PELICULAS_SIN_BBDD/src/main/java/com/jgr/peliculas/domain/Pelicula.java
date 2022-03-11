package com.jgr.peliculas.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author DARTH_VADER Clase Pelicula, definicion y metodos
 */

public class Pelicula /* implements Serializable */ {

	private static final long serialVersionUID = -5448203274869743192L;
	private String nombre;

	/**
	 * Constructor vacio
	 * 
	 * @param nada
	 */
	public Pelicula() {
	}

	/**
	 * Constructor con datos
	 * 
	 * @param String nombre
	 */
	public Pelicula(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el nombre de la pelicula
	 * 
	 * @param nada
	 * @return the nombre
	 */

	public String getNombre() {
		return nombre;
	}

	/**
	 * Devuelve el nombre de la pelicula
	 * 
	 * @param String nombre de pelicula
	 * @return nada
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Pelicula)) {
			return false;
		}
		Pelicula other = (Pelicula) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return this.nombre;
	}

}

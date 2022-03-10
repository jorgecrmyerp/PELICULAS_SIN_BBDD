package com.jgr.peliculas.domain;

import java.io.Serializable;
import java.util.Objects;

public class Pelicula implements Serializable {

	/**
	 * CLASE PRINCIPAL
	 */
	private static final long serialVersionUID = -5448203274869743192L;
	private String nombre;

	public Pelicula() {
	}

	public Pelicula(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
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
		return "Pelicula [nombre=" + nombre + ", getNombre()=" + getNombre() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

}

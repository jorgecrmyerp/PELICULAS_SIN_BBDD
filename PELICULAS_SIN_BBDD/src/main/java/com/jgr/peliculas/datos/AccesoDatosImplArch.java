package com.jgr.peliculas.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.jgr.peliculas.domain.Pelicula;
import com.jgr.peliculas.excepciones.AccesoDatosEx;
import com.jgr.peliculas.excepciones.EscrituraDatosEx;
import com.jgr.peliculas.excepciones.LecturaDatosEx;

/**
 * @author DARTH_VADER *
 */

/**
 * <h1>Esta clase realiza el acceso y tratamiento de datos cuando es un fichero<h1>.
 */
public class AccesoDatosImplArch implements IAccesoDatos {

	/**
	 * Este metodo verifica si existe o no el fichero.
	 * 
	 * @param String nombreRecurso nombre del fichero a verificar
	 * @return boolean existe o no.
	 * @throws error acceso a datos si hay problemas con el fichero
	 */

	@Override
	public boolean existe(String nombreRecurso) throws AccesoDatosEx {
		File archivo = new File(nombreRecurso);
		
		return archivo.exists();

	}

	/**
	 * Este metodo devuelve una lista de peliculas a partir del nombre del fichero.
	 * @param String nombreRecurso nombre del fichero a leer
	 * @return List<Pelicula> peliculas que hay en el fichero.
	 * @throws LecturaDatosEx       ,si no existe el fichero
	 * @throws AccesoDatosEx,existe el fichero pero hay problemas al leerlo
	 */

	@Override
	public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx, AccesoDatosEx {
		// var archivo = new File(nombreRecurso);

		List<Pelicula> peliculas = new ArrayList<Pelicula>();

		try {

			FileInputStream ficheroEntrada = new FileInputStream(nombreRecurso);
			ObjectInputStream objetoEntrada = new ObjectInputStream(ficheroEntrada);

			Object objeto = new Object();
			objeto = objetoEntrada.readObject();
			System.out.println("leo antes");
			while (objeto != null) {
				
				peliculas.add((Pelicula) objeto);
				objeto = objetoEntrada.readObject();
				System.out.println("leo dentro");
			}
			objetoEntrada.close();
			ficheroEntrada.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new LecturaDatosEx("no existe fichero listar peliculas :" + e.getMessage() + " " + e.getCause());
		} catch (IOException e) {
			e.printStackTrace();
			throw new AccesoDatosEx("error al leer listar peliculas :" + e.getMessage() + " " + e.getCause());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new AccesoDatosEx("la clase pelicula No EXISTE en listar:" + e.getMessage() + " " + e.getCause());
		}

		return peliculas;

	}

	/**
	 * Este metodo escribe en el fichero dque se pasa como parametro la pelicula
	 * añadiendo o inicializando el fichero. *
	 * 
	 * @param Pelicula      a escribir
	 * @param nombreRecurso fichero en el que se va a escribir
	 * @param anexar,       se añade al fichero o se inicializa con este registro
	 * @throws EscrituraDatosEx     si hay problemas al escribir
	 * @throws AccesoDatosEx,existe el fichero pero hay problemas al leerlo
	 * @return nada. OJO!!!!!
	 *         http://www.chuidiang.org/java/ficheros/ObjetosFichero.php
	 *         https://stackoverflow.com/questions/2393179/streamcorruptedexception-invalid-type-code-ac
	 */

	@Override
	public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar)
			throws EscrituraDatosEx, AccesoDatosEx {

		System.out.println("escrito ok en escribir:"+ pelicula.toString()+ "\n");
		try {
			FileOutputStream ficheroSalida = new FileOutputStream(nombreRecurso,anexar);
			ObjectOutputStream objetoSalida = new ObjectOutputStream(ficheroSalida);
			//objetoSalida.writeObject(pelicula);
			objetoSalida.writeUnshared(pelicula);
			//objetoSalida.reset();
			objetoSalida.close();
			ficheroSalida.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new EscrituraDatosEx("error escribir en archivo salida :" + e.getMessage() + " " + e.getCause());
		} catch (IOException e) {
			e.printStackTrace();
			throw new AccesoDatosEx("error IO escribir peliculas :" + e.getMessage() + " " + e.getCause());
		}

	}

	/**
	 * Este metodo busca en el fichero dque se pasa como parametro la pelicula *
	 * 
	 * @param nombreRecurso fichero en el que se va a escribir
	 * @param Pelicula      a buscar
	 * @param anexar,       se añade al fichero o se inicializa con este registro
	 * @throws EscrituraDatosEx     si hay problemas al escribir
	 * @throws AccesoDatosEx,existe el fichero pero hay problemas al leerlo
	 * @return Pelicula.
	 */

	@Override
	public Pelicula buscar(String nombreRecurso, Pelicula pelicula) throws AccesoDatosEx {

		Pelicula peli = null;

		try {

			FileInputStream ficheroEntrada = new FileInputStream(nombreRecurso);
			ObjectInputStream objetoEntrada = new ObjectInputStream(ficheroEntrada);
			Object objeto = new Object();
			objeto = objetoEntrada.readObject();
			boolean encontrado = false;

			while (objeto != null && !encontrado) {
				if (pelicula.equals((Pelicula) objeto)) {
					encontrado = true;
					peli = new Pelicula();
					peli = (Pelicula) objeto;
					break;
				} else {
					objeto = objetoEntrada.readObject();
				}
			}

			objetoEntrada.close();
			ficheroEntrada.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new LecturaDatosEx("no existe fichero buscar peliculas :" + e.getMessage() + " " + e.getCause());
		} catch (IOException e) {
			e.printStackTrace();
			throw new AccesoDatosEx("error al leer buscar peliculas :" + e.getMessage() + " " + e.getCause());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new AccesoDatosEx("la clase pelicula No EXISTE en buscar:" + e.getMessage() + " " + e.getCause());
		}

		return peli;
	}

	/**
	 * Este metodo crea el fichero dque se pasa como parametro la pelicula *
	 * 
	 * @param nombreRecurso fichero en el que se va a escribir *
	 * @return nada.
	 */

	@Override
	public void crear(String nombreRecurso) throws AccesoDatosEx {

		try {
			/*
			 * FileOutputStream ficheroSalida = new FileOutputStream(nombreRecurso);
			 * ObjectOutputStream objetoSalida = new ObjectOutputStream(ficheroSalida);
			 * objetoSalida.close(); ficheroSalida.close();
			 */
			new FileOutputStream(nombreRecurso, false).close();

			//File f = new File(nombreRecurso);
			//System.out.println("creado ok en crear" + f.exists());
			
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			//System.out.println("error crear archivo salida :" + e.getMessage() + " " + e.getCause());
			throw new EscrituraDatosEx("error crear archivo salida :" + e.getMessage() + " " + e.getCause());
		} catch (IOException e) {
			e.printStackTrace();
			throw new AccesoDatosEx("error IO escribir peliculas :" + e.getMessage() + " " + e.getCause());
		}

	}

	/**
	 * Este metodo borra el fichero dque se pasa como parametro la pelicula *
	 * 
	 * @param nombreRecurso fichero en el que se va a escribir *
	 * @return nada.
	 */

	@Override
	public void borrar(String nombreRecurso) throws AccesoDatosEx {
		File archivo = new File(nombreRecurso);
		if (archivo.exists()) {
			archivo.delete();
		}

	}

}

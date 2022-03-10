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
 * @author DARTH_VADER
 *
 */

/**
 * <h1>Esta clase realiza el acceso y tratamiento de datos cuando es un fichero
 * <h1>.
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
	 * Este metodo devuelve una lista de peliculas a partir del nombre del fichero.	 * 
	 * @param String nombreRecurso nombre del fichero a leer
	 * @return List<Pelicula> peliculas que hay en el fichero.
	 * @throws LecturaDatosEx ,si no existe el fichero
	 * @throws AccesoDatosEx,existe  el fichero pero hay problemas al leerlo	
	 */

	@Override
	public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx, AccesoDatosEx {
		var archivo = new File(nombreRecurso);

		List<Pelicula> peliculas = new ArrayList();

		try {
			
			FileInputStream ficheroEntrada = new FileInputStream(nombreRecurso);
			ObjectInputStream objetoEntrada = new ObjectInputStream(ficheroEntrada);					
			
			Object objeto= new Object();			
			objeto=objetoEntrada.readObject();
			
			while (objeto != null) {				
				peliculas.add((Pelicula) objeto);
				objeto = objetoEntrada.readObject();
			}
			objetoEntrada.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new LecturaDatosEx("no existe fichero listar peliculas :" + e.getMessage() + " " + e.getCause());
		} catch (IOException e) {
			e.printStackTrace();
			throw new AccesoDatosEx("error al leer listar peliculas :" + e.getMessage() + " " + e.getCause());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new AccesoDatosEx("la clase pelicula No EXISTE :" + e.getMessage() + " " + e.getCause());
		}

		return peliculas;

	}

	/**
	 * Este metodo escribe en el fichero dque se pasa como parametro la pelicula añadiendo o inicializando el fichero.	 * 
	 * @param Pelicula a escribir
	 * @param nombreRecurso fichero en el que se va a escribir
	 * @param anexar, se añade al fichero o se inicializa con este registro
	 * @throws EscrituraDatosEx si hay problemas al escribir
	 * @throws AccesoDatosEx,existe  el fichero pero hay problemas al leerlo	
	 */
	
	
	@Override
	public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx, AccesoDatosEx  {
		
		try {
			FileOutputStream ficheroSalida = new FileOutputStream(nombreRecurso);
			ObjectOutputStream objetoSalida = new	ObjectOutputStream(ficheroSalida);
			objetoSalida.writeObject(pelicula);
			objetoSalida.close();
			System.out.println("escrito ok en escribir");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new EscrituraDatosEx("error escribir en archivo salida :" + e.getMessage() + " " + e.getCause());		
		} catch (IOException e) {
			e.printStackTrace();
			throw new AccesoDatosEx("error IO escribir peliculas :" + e.getMessage() + " " + e.getCause());
		}		

	}

	@Override
	public Pelicula buscar(String nombreRecurso, Pelicula pelicula) throws LecturaDatosEx {
		return null;
	}

	@Override
	public void crear(String nombreRecurso) throws AccesoDatosEx {

	}

	@Override
	public void borrar(String nombreRecurso) throws AccesoDatosEx {

	}

}

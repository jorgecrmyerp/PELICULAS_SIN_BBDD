package com.jgr.peliculas.datos;

import com.jgr.peliculas.excepciones.AccesoDatosEx;
import com.jgr.peliculas.excepciones.EscrituraDatosEx;
import com.jgr.peliculas.excepciones.LecturaDatosEx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.jgr.peliculas.domain.Pelicula;

public class AccesoDatosImpl implements IAccesoDatos {


    @Override
    public boolean existe(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {
        var archivo = new File(nombreRecurso);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null) {
                var pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas:" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas:" + ex.getMessage());
        }
        peliculas.forEach(System.out::println);
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {
        var archivo = new File(nombreRecurso);
        try {
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha escrito informacion al archivo: " + pelicula);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("Excepcion al escribir peliculas:" + ex.getMessage());
        }
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
        var archivo = new File(nombreRecurso);
        String resultado = null;
        //System.out.println("busco"+buscar);
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            var indice = 1;
            while (linea != null) {
                if(buscar != null && buscar.equalsIgnoreCase(linea)){
                    resultado = "Pelicula " + linea + " encontrada en el indice " + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar pelicula:" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar pelicula:" + ex.getMessage());

        }

        return resultado;
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {

		try {
			/*
			 * FileOutputStream ficheroSalida = new FileOutputStream(nombreRecurso);
			 * ObjectOutputStream objetoSalida = new ObjectOutputStream(ficheroSalida);
			 * objetoSalida.close(); ficheroSalida.close();
			 */
			
			ObjectOutputStream objetoSalida = new ObjectOutputStream(new FileOutputStream(nombreRecurso));

			//File f = new File(nombreRecurso);
			
			
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			//System.out.println("error crear archivo salida :" + e.getMessage() + " " + e.getCause());
			throw new EscrituraDatosEx("error crear archivo salida :" + e.getMessage() + " " + e.getCause());
		} catch (IOException e) {
			e.printStackTrace();
			throw new AccesoDatosEx("error IO escribir peliculas :" + e.getMessage() + " " + e.getCause());
		}
    	
    }

    @Override
    public void borrar(String nombreRecurso) throws AccesoDatosEx {
    	try{

            File archivo = new File(nombreRecurso);

            boolean estatus = archivo.delete();

            if (!estatus) {

                System.out.println("Error no se ha podido eliminar el  archivo");

           }else{

                System.out.println("Se ha eliminado el archivo exitosamente");

           }

        }catch(Exception e){

           System.out.println(e);

        }
    	
    }
}

package com.jgr.peliculas.negocio;

import com.jgr.peliculas.datos.AccesoDatosImplArch;
import com.jgr.peliculas.datos.IAccesoDatos;
import com.jgr.peliculas.domain.Pelicula;
import com.jgr.peliculas.excepciones.AccesoDatosEx;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas{

    private final IAccesoDatos datos;
    
    
    /**
	 * creo un objeto AccesodatosImplArch que es donde se crea el fichero, o se accede a bbdd CAMBIAR INTERFACE CUANDO SEA BBDD
	 * @param nombre pelicula
	 * @return nada
	 */
    
    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImplArch();
    }
    
    @Override
    public void agregaPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listaPeliculas() {
    	try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            for(var pelicula: peliculas){
                System.out.println("pelicula = " + pelicula);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscaPelicula(String buscar) {
    	String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso datos");
            ex.printStackTrace(System.out);
        }
        System.out.println("resultado = " + resultado);
    }

    @Override
    public void iniciaCatalogoPeliculas() {
    	try {
            if(this.datos.existe(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }
            else{
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar catalogo de peliculas");
            ex.printStackTrace(System.out);
        }
    }
   


}
package com.jgr.peliculas.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.jgr.peliculas.datos.AccesoDatosImplArch;
import com.jgr.peliculas.datos.IAccesoDatos;
import com.jgr.peliculas.domain.Pelicula;
import com.jgr.peliculas.excepciones.AccesoDatosEx;
import com.jgr.peliculas.excepciones.EscrituraDatosEx;
import com.jgr.peliculas.excepciones.LecturaDatosEx;

/**
 * 
 * @author DARTH_VADER
 *OJO,CUIDADO CON EL ORDEN EN EL QUE SE EJECUTA, AL ESCRIBIR METE GUARRERIA Y DA ERROR
 */
class AccesoDatosImplTest {

	IAccesoDatos accesoDatos;
	private Pelicula peli;
	private List<Pelicula> peliculas;
	private final String nomFichero2 = "c:\\catalogoPeliculas\\peliculas.txt";//debe existir el directorio
	private final String nomFichero = "peliculas.txt";
	private static final int NUM_MAX_LISTA = 10;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	@DisplayName("estoy en BeforeEach")
	void setUp() throws Exception {
		// pongo primero la interfaz,pero lo que creo es la clase en si
		accesoDatos = new AccesoDatosImplArch();
		peliculas = new ArrayList<Pelicula>();
		for (int i = 0; i < NUM_MAX_LISTA; i++) {
			peli = new Pelicula("Peli" + i);
			peliculas.add(peli);
			// System.out.println(peliculas.get(i).toString());

		}

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("estoy en testExiste")
	void testExiste() throws AccesoDatosEx {
		//accesoDatos.crear(nomFichero);
		assertTrue(accesoDatos.existe(nomFichero2));

		// fail("Not yet implemented");
	}

	@Test
	@DisplayName("estoy en testListar")
	void testListar() throws Exception {		
		List<Pelicula> peliculas2 = new ArrayList<Pelicula>();
		peliculas2 = accesoDatos.listar(nomFichero2);				
		assertTrue(peliculas.equals(peliculas2),() -> "no son iguales:" + peliculas.toString() );		
		peliculas2.forEach(System.out::println);	

	}

	@Test
	@DisplayName("estoy en testEscribir")
	void testEscribir() throws AccesoDatosEx {
		//accesoDatos.borrar(nomFichero);
		//accesoDatos.crear(nomFichero);
		
		for (Pelicula peli:peliculas) {
			accesoDatos.escribir(peli, nomFichero2, true);
		}
		
		List<Pelicula> peliculas2 = new ArrayList<Pelicula>();

		peliculas2 = accesoDatos.listar(nomFichero2);

		System.out.println("peliculas2"+ peliculas2);
		System.out.println("peliculas"+ peliculas);
		assertTrue(peliculas.equals(peliculas2),() -> "no son iguales:" + peliculas);

	}

	@Test
	void testBuscar() throws Exception {

		System.out.println(accesoDatos.buscar(nomFichero, "Peli1"));
		String esperado = "Pelicula Peli1 encontrada en el indice 2";
		String actual = accesoDatos.buscar(nomFichero2, "Peli1");
		assertEquals(esperado,actual, () -> "no coincide la busqueda:" + esperado +" con:" + actual);
		
		// fail("Not yet implemented");
	}

	@Test
	@DisplayName("estoy en testCrear")
	void testCrear() throws Exception {
		//
		// ahora creo un fichero y verifico que existe
		accesoDatos.crear(nomFichero2);
		assertTrue(accesoDatos.existe(nomFichero2), () -> "no existe el fichero " + nomFichero2);
		accesoDatos.borrar(nomFichero2);// lo borro

	}

	@Test
	@DisplayName("estoy en testBorrar")
	void testBorrar() throws AccesoDatosEx {
		// fail("Not yet implemented");
		accesoDatos.crear(nomFichero2);
		assertTrue(accesoDatos.existe(nomFichero2), () -> "no existe el fichero " + nomFichero2);
		accesoDatos.borrar(nomFichero2);// lo borro
		assertFalse(accesoDatos.existe(nomFichero2), () -> "lo he borrado y existe " + nomFichero2);

	}

}

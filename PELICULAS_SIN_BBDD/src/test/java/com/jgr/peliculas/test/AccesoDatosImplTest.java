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

import com.jgr.peliculas.datos.AccesoDatosImpl;
import com.jgr.peliculas.datos.IAccesoDatos;
import com.jgr.peliculas.domain.Pelicula;
import com.jgr.peliculas.excepciones.AccesoDatosEx;
import com.jgr.peliculas.excepciones.EscrituraDatosEx;
import com.jgr.peliculas.excepciones.LecturaDatosEx;

class AccesoDatosImplTest {

	IAccesoDatos accesoDatos;
	private Pelicula peli;
	private List<Pelicula> peliculas;
	private final String nomFichero2 = "c:\\\\catalogoPeliculas\\\\peliculas.txt";
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
		accesoDatos = new AccesoDatosImpl();
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
		accesoDatos.crear(nomFichero);
		assertTrue(accesoDatos.existe(nomFichero), () -> "no existe el fichero y lo acabo de crear" + nomFichero);

		// fail("Not yet implemented");
	}

	@Test
	@DisplayName("estoy en testListar")
	void testListar() throws Exception {
		
		List<Pelicula> peliculas2 = new ArrayList<Pelicula>();

		peliculas2 = accesoDatos.listar(nomFichero);
		
		
		assertTrue(peliculas.equals(peliculas2),() -> "no son iguales:" + peliculas.toString() );
		
		peliculas2.forEach(System.out::println);
		

	}

	@Test
	@DisplayName("estoy en testEscribir")
	void testEscribir() throws AccesoDatosEx {
		accesoDatos.borrar(nomFichero);
		accesoDatos.crear(nomFichero);
		
		for (Pelicula peli:peliculas) {
			accesoDatos.escribir(peli, nomFichero, true);
		}
		
		List<Pelicula> peliculas2 = new ArrayList<Pelicula>();

		peliculas2 = accesoDatos.listar(nomFichero);

		System.out.println("peliculas2"+ peliculas2);
		System.out.println("peliculas"+ peliculas);
		assertTrue(peliculas.equals(peliculas2),() -> "no son iguales:" + peliculas);

	}

	@Test
	void testBuscar() throws Exception {

		//System.out.println(accesoDatos.buscar(nomFichero, "Peli1"));
		String esperado = "Pelicula Peli1 encontrada en el indice 2";
		String actual = accesoDatos.buscar(nomFichero, "Peli1");
		assertEquals(esperado,actual, () -> "no coincide la busqueda:" + esperado +" con:" + actual);
		
		// fail("Not yet implemented");
	}

	@Test
	@DisplayName("estoy en testCrear")
	void testCrear() throws Exception {
		//
		// ahora creo un fichero y verifico que existe
		accesoDatos.crear(nomFichero);
		assertTrue(accesoDatos.existe(nomFichero), () -> "no existe el fichero " + nomFichero);
		accesoDatos.borrar(nomFichero);// lo borro

	}

	@Test
	@DisplayName("estoy en testBorrar")
	void testBorrar() throws AccesoDatosEx {
		// fail("Not yet implemented");
		accesoDatos.crear(nomFichero);
		assertTrue(accesoDatos.existe(nomFichero), () -> "no existe el fichero " + nomFichero);
		accesoDatos.borrar(nomFichero);// lo borro
		assertTrue(accesoDatos.existe(nomFichero), () -> "lo he borrado y existe " + nomFichero);

	}

}

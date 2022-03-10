/**
 * 
 */
package com.jgr.peliculas.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jgr.peliculas.domain.Pelicula;

/**
 * @author DARTH_VADER
 *
 */
class AccesoDatosImplArchTest {
	
	private Pelicula peli = new Pelicula();;
	private List<Pelicula> peliculas = new ArrayList<Pelicula>();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		 
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.jgr.peliculas.datos.AccesoDatosImplArch#existe(java.lang.String)}.
	 */
	@Test
	void testExiste() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.jgr.peliculas.datos.AccesoDatosImplArch#listar(java.lang.String)}.
	 */
	@Test
	void testListar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.jgr.peliculas.datos.AccesoDatosImplArch#escribir(com.jgr.peliculas.domain.Pelicula, java.lang.String, boolean)}.
	 */
	@Test
	void testEscribir() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.jgr.peliculas.datos.AccesoDatosImplArch#buscar(java.lang.String, com.jgr.peliculas.domain.Pelicula)}.
	 */
	@Test
	void testBuscar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.jgr.peliculas.datos.AccesoDatosImplArch#crear(java.lang.String)}.
	 */
	@Test
	void testCrear() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.jgr.peliculas.datos.AccesoDatosImplArch#borrar(java.lang.String)}.
	 */
	@Test
	void testBorrar() {
		fail("Not yet implemented");
	}

}

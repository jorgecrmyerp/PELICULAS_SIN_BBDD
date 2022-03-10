package com.jgr.peliculas.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jgr.peliculas.domain.Pelicula;

class PeliculaTest {
	
	Pelicula peli;
	String nombrePeli;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		peli = new Pelicula("NombrePeli");	
		nombrePeli= peli.getNombre();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testHashCode() {
		Pelicula peli2;
		peli2= peli;		
		Assertions.assertEquals(peli2.hashCode(),peli.hashCode(),()->"no son iguales testHashCode original:" + peli.hashCode() + "el nuevo :" + peli2.hashCode());
		
		Pelicula peli3;
		peli3 = new Pelicula("NombrePeli2");
		Assertions.assertNotEquals(peli2.hashCode(), peli3.hashCode(),()->"deberian ser distintos pero no:" + peli2.hashCode() + " el nuevo :" + peli3.hashCode());
		
	}

	@Test
	void testPelicula() {
		
		
	}

	@Test
	void testGetNombre() {		
		String nombrePrueba= peli.getNombre();
		Assertions.assertEquals(peli.getNombre(),nombrePrueba,()->"nombre esperado:" + nombrePrueba + "pero es :" + peli.getNombre());
		
	}

	@Test
	void testSetNombre() {
		//fail("Not yet implemented"); // TODO
		peli.setNombre("nombrecito");
		String nombrePrueba = "nombrecito";
		
		Assertions.assertEquals(peli.getNombre(), nombrePrueba,()->"nombre esperado:" + nombrePrueba + "pero es :" + peli.getNombre());
		
	}

	@Test
	void testEqualsObject() {
		Pelicula peli2;
		peli2= peli;		
		Assertions.assertEquals(peli2,peli,()->"no son iguales testEqualsObject original:" + peli.hashCode() + "el nuevo :" + peli2.hashCode());
	}

	@Test
	void testToString() {
		//fail("Not yet implemented"); // TODO
		peli.toString();
		Assertions.assertEquals(peli.getNombre(),nombrePeli,()->"no son iguales testToString() original:" + peli.getNombre() + "el de variable :" + nombrePeli);
		
	}

}

/**
 * 
 */
package com.jgr.peliculas.excepciones;

/**
 * @author DARTH_VADER
 *
 */
public class AccesoDatosEx extends Exception {

	private static final long serialVersionUID = 5421677262148580560L;

	

	/**
	 * @param message
	 */
	public AccesoDatosEx(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public AccesoDatosEx(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}

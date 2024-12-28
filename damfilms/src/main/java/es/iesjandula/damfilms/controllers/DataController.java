package es.iesjandula.damfilms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataController
{
	
	
	// ----------------------- UTILIDADES FORMULARIOS. --------------------
	/**
	 * Endpoint - /data/suscripciones
	 * Metodo 	- getSuscripciones
	 * 
	 * Devuelve un listado de suscripciones almacenadas en BBDD.
	 * Este metodo alimentará un endpoint en el front.
	 * 
	 */
	
	// -----------------------  SERIES -------------------------------------
	
	/**
	 * Endpoint - /series/filter
	 * Metodo 	- getSeriesByFilter
	 * 
	 * Devuelve un listado filtrado por GENERO y TIPO, valores 
	 * nulos no se tendrán en cuenta para la busqueda.
	 */

	/**
	 * Endpoint - /series/popular 
	 * Metodo 	- getPopularSeries
	 * 
	 * Devuelve un listado de N series ordenado por su
	 * popularidad.
	 */
	
	/**
	 * Endpoint - /series/latest 
	 * Metodo 	- getLatestSeries
	 * 
	 * Devuelve una lista de N peliculas ordenadas de más
	 * reciente a menos reciente a partir de su fecha de subida.
	 */
	

	// -----------------------  PELICULAS -------------------------------------
	
	/**
	 * Endpoint - /series/filter
	 * Metodo 	- getMoviesByFilter	 
	 * 
	 * Devuelve un listado filtrado por GENERO y TIPO, valores 
	 * nulos no se tendrán en cuenta para la busqueda.
	 */

	/**
	 * Endpoint /movies/popular 
	 * Metodo 	- getPopularMovies
	 * 
	 * Devuelve un listado de N peliculas ordenado por su
	 * popularidad.
	 */

	/**
	 * Endpoint /movies/latest 
	 * Metodo 	- getLatestMovies
	 * 
	 * Devuelve una lista de N peliculas ordenadas de más
	 * reciente a menos reciente a partir de su fecha de subida.
	 */

	// -----------------------  DOCUMENTALES -------------------------------------
	
	/**
	 * Endpoint - /documentaries/filter 
	 * Metodo  	- getDocuentariesByFilter
	 * 
	 * Devuelve un listado filtrado por GENERO, un valor 
	 * nulo no se tendrán en cuenta para la busqueda.
	 */

	/**
	 * Endpoint - /documentaries/popular 
	 * Metodo 	- getPopularDocumentaries 
	 * 
	 * Devuelve un listado de N documentales ordenado por su
	 * popularidad.
	 */

	/**
	 * Endpoint - /documentaries/latest 
	 * Metodo 	- getLastestDocumentaries
	 * 
	 * Devuelve una lista de N documentales ordenados de más
	 * reciente a menos reciente a partir de su fecha de subida.
	 */
	
}



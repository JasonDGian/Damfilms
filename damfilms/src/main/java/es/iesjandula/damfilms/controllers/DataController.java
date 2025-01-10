package es.iesjandula.damfilms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.iesjandula.damfilms.models.Documental;
import es.iesjandula.damfilms.models.Pelicula;
import es.iesjandula.damfilms.models.Serie;
import es.iesjandula.damfilms.models.Suscripcion;
import es.iesjandula.damfilms.repositories.IDocumentalRepository;
import es.iesjandula.damfilms.repositories.IPeliculaRepository;
import es.iesjandula.damfilms.repositories.ISerieRepository;
import es.iesjandula.damfilms.repositories.ISuscripcionRepository;

@Controller
public class DataController
{
	
	@Autowired
	private ISuscripcionRepository iSuscripcionRepository;
	@Autowired
	private ISerieRepository iSerieRepository;
	@Autowired
	private IPeliculaRepository iPeliculaRepositoy;
	@Autowired
	private IDocumentalRepository iDocumentalRepository;
	// ----------------------- UTILIDADES FORMULARIOS. --------------------
	/**
	 * Endpoint - /data/suscripciones
	 * Metodo 	- getSuscripciones
	 * 
	 * Devuelve un listado de suscripciones almacenadas en BBDD.
	 * Este metodo alimentará un endpoint en el front.
	 * 
	 */
	
	@RequestMapping(method = RequestMethod.GET, value= "/data/suscripciones")
	 public ResponseEntity<?> getSuscripciones()
	 {
		 List<Suscripcion> suscripcionList = this.iSuscripcionRepository.findAll();
		 if(suscripcionList.isEmpty())
		 {
			 return ResponseEntity.status(404).body("No se han cargado suscripciones");
		 }
		 return ResponseEntity.ok().body(suscripcionList);
	 }
	
	// -----------------------  SERIES -------------------------------------
	
	/**
	 * Endpoint - /series/filter
	 * Metodo 	- getSeriesByFilter
	 * 
	 * Devuelve un listado filtrado por GENERO y TIPO, valores 
	 * nulos no se tendrán en cuenta para la busqueda.
	 */
	@RequestMapping(method = RequestMethod.GET, value= "/series/filter")
	 public ResponseEntity<?> getSeriesByFilter(
			 @RequestHeader(value = "genero") String genero,
			 @RequestHeader(value="tipo") String tipo
			 
			 )

			 
	 {
		if(genero == null && tipo == null)
		{
			 List<Serie> serieList = this.iSerieRepository.findAll();
			 if(serieList.isEmpty())
			 {
				 return ResponseEntity.status(404).body("No se han cargado series");
			 }
			 return ResponseEntity.ok().body(serieList);
		}
		if(genero != null && tipo == null)
		{
			List<Serie> serieList = this.iSerieRepository.encontrarSeriesPorTipoYGenero(tipo,genero);
			 if(serieList.isEmpty())
			 {
				 return ResponseEntity.status(404).body("No se han cargado series");
			 }
			 return ResponseEntity.ok().body(serieList);
		}
		
		if(genero == null && tipo != null)
		{
			List<Serie> serieList = this.iSerieRepository.encontrarSeriesPorTipoYGenero(tipo,genero);
			 if(serieList.isEmpty())
			 {
				 return ResponseEntity.status(404).body("No se han cargado series");
			 }
			 return ResponseEntity.ok().body(serieList);
		}
			
		List<Serie> serieList = this.iSerieRepository.findAll();
		 if(serieList.isEmpty())
		 {
			 return ResponseEntity.status(404).body("No se han cargado series");
		 }
		 return ResponseEntity.ok().body(serieList);
	 }
	/**
	 * Endpoint - /series/popular 
	 * Metodo 	- getPopularSeries
	 * 
	 * Devuelve un listado de N series ordenado por su
	 * popularidad.
	 */
	@RequestMapping(method = RequestMethod.GET, value= "/series/popular")
	 public ResponseEntity<?> getPopularSeries()
	{
		 List<Serie> serieList = this.iSerieRepository.encontrarSeriesOrdenadasPorPopularidad();
		 
		 if(serieList.isEmpty())
		 {
			 return ResponseEntity.status(404).body("No se han cargado series");
		 }
		 return ResponseEntity.ok().body(serieList);
	}
	
	
	/**
	 * Endpoint - /series/latest 
	 * Metodo 	- getLatestSeries
	 * 
	 * Devuelve una lista de N peliculas ordenadas de más
	 * reciente a menos reciente a partir de su fecha de subida.
	 */
	@RequestMapping(method = RequestMethod.GET, value= "/series/latest")
	 public ResponseEntity<?> getLatestSeries()
	{
		 List<Serie> serieList = this.iSerieRepository.encontrarSeriesOrdenadasPorFechaDeLlegada();
		 
		 if(serieList.isEmpty())
		 {
			 return ResponseEntity.status(404).body("No se han cargado series");
		 }
		 return ResponseEntity.ok().body(serieList);
	}
	
	// -----------------------  PELICULAS -------------------------------------
	
	/**
	 * Endpoint - /series/filter
	 * Metodo 	- getMoviesByFilter	 
	 * 
	 * Devuelve un listado filtrado por GENERO y TIPO, valores 
	 * nulos no se tendrán en cuenta para la busqueda.
	 */
	@RequestMapping(method = RequestMethod.GET, value= "/movies/filter")
	 public ResponseEntity<?> getMoviesByFilter(
			 @RequestHeader(value = "genero") String genero,
			 @RequestHeader(value="tipo") String tipo
			 
			 )
	 
	 {
		if(genero == null && tipo == null)
		{
			 List<Pelicula> peliculaList = this.iPeliculaRepositoy.findAll();
			 if(peliculaList.isEmpty())
			 {
				 return ResponseEntity.status(404).body("No se han cargado series");
			 }
			 return ResponseEntity.ok().body(peliculaList);
		}
		
		List<Pelicula> peliculaList= this.iPeliculaRepositoy.encontrarPeliculasPorTipoYGenero(tipo,genero);
		if(peliculaList.isEmpty())
		{
			 return ResponseEntity.status(404).body("No se han cargado series");
		}
		return ResponseEntity.ok().body(peliculaList);
		
		 
	 }

	/**
	 * Endpoint /movies/popular 
	 * Metodo 	- getPopularMovies
	 * 
	 * Devuelve un listado de N peliculas ordenado por su
	 * popularidad.
	 */
	@RequestMapping(method = RequestMethod.GET, value= "/movies/popular")
	 public ResponseEntity<?> getPopularMovies()
	 {
		List<Pelicula> peliculaList = this.iPeliculaRepositoy.encontrarPeliculasOrdenadasPorPopularidad();
		 if(peliculaList.isEmpty())
		 {
			 return ResponseEntity.status(404).body("No se han cargado series");
		 }
		 return ResponseEntity.ok().body(peliculaList);
	 }
	

	/**
	 * Endpoint /movies/latest 
	 * Metodo 	- getLatestMovies
	 * 
	 * Devuelve una lista de N peliculas ordenadas de más
	 * reciente a menos reciente a partir de su fecha de subida.
	 */
	@RequestMapping(method = RequestMethod.GET, value= "/movies/popular")
	 public ResponseEntity<?> getLatestMovies()
	 {
		List<Pelicula> peliculaList = this.iPeliculaRepositoy.encontrarPeliculasOrdenadasPorFechaDeLlegada();
		 if(peliculaList.isEmpty())
		 {
			 return ResponseEntity.status(404).body("No se han cargado series");
		 }
		 return ResponseEntity.ok().body(peliculaList);
	 }
	// -----------------------  DOCUMENTALES -------------------------------------
	
	/**
	 * Endpoint - /documentaries/filter 
	 * Metodo  	- getDocuentariesByFilter
	 * 
	 * Devuelve un listado filtrado por GENERO, un valor 
	 * nulo no se tendrán en cuenta para la busqueda.
	 */
	@RequestMapping(method = RequestMethod.GET, value= "/documentaries/filter")
	 public ResponseEntity<?> getDocumentariesByFilter(
			 @RequestHeader(value = "genero") String genero
			 
			 )
	 
	 {
		
		if(genero == null)
		{
			 List<Documental> documentalList = this.iDocumentalRepository.findAll();
			 if(documentalList.isEmpty())
			 {
				 return ResponseEntity.status(404).body("No se han cargado series");
			 }
			 return ResponseEntity.ok().body( documentalList);
		}
		
		List<Documental> documentalList = this.iDocumentalRepository.encontrarDocuemntalPorGenero(genero);
		 if(documentalList.isEmpty())
		 {
			 return ResponseEntity.status(404).body("No se han cargado series");
		 }
		 return ResponseEntity.ok().body( documentalList);
		
		 
	 }
	/**
	 * Endpoint - /documentaries/popular 
	 * Metodo 	- getPopularDocumentaries 
	 * 
	 * Devuelve un listado de N documentales ordenado por su
	 * popularidad.
	 */
	@RequestMapping(method = RequestMethod.GET, value= "/documentaries/popular")
	 public ResponseEntity<?>getPopularDocumentaries  ()
	 
	 {
		List<Documental> documentalList = this.iDocumentalRepository.encontrarDocumentalOrdenadasPorPopularidad();
		 if(documentalList.isEmpty())
		 {
			 return ResponseEntity.status(404).body("No se han cargado series");
		 }
		 return ResponseEntity.ok().body( documentalList);
	 }
	/**
	 * Endpoint - /documentaries/latest 
	 * Metodo 	- getLastestDocumentaries
	 * 
	 * Devuelve una lista de N documentales ordenados de más
	 * reciente a menos reciente a partir de su fecha de subida.
	 */
	@RequestMapping(method = RequestMethod.GET, value= "/documentaries/latest")
	 public ResponseEntity<?>getLatestDocumentaries()
	 
	 {
		List<Documental> documentalList = this.iDocumentalRepository.encontrarDocumentalOrdenadasPorFechaDeLlegada();
		 if(documentalList.isEmpty())
		 {
			 return ResponseEntity.status(404).body("No se han cargado series");
		 }
		 return ResponseEntity.ok().body( documentalList);
	 }
}






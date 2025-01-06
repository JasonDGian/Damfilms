package es.iesjandula.damfilms.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.iesjandula.damfilms.services.parsers.IParseoDocumental;
import es.iesjandula.damfilms.services.parsers.IParseoGenero;
import es.iesjandula.damfilms.services.parsers.IParseoPelicula;
import es.iesjandula.damfilms.services.parsers.IParseoSerie;
import es.iesjandula.damfilms.services.parsers.IParseoSuscripcion;
import es.iesjandula.damfilms.services.parsers.IParseoTipo;
import es.iesjandula.damfilms.services.parsers.iParseoGeneroPelicula;
import es.iesjandula.damfilms.services.parsers.iParseoGeneroSerie;
import es.iesjandula.damfilms.services.parsers.iParseoTemporada;
import es.iesjandula.damfilms.utils.Constants;
import es.iesjandula.damfilms.utils.DamfilmsServerError;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApplicationInitializer
{
	// Inyecta dependencia de repositorio de roles.
	@Autowired
	private IParseoPelicula iParseoPelicula;

	@Autowired
	private IParseoDocumental iParseoDocumental;

	@Autowired
	private IParseoGenero iParseoGenero;

	@Autowired
	private IParseoSerie iParseoSerie;

	@Autowired
	private IParseoTipo iParseoTipo;

	@Autowired
	private iParseoGeneroPelicula iParseoGeneroPelicula;

	@Autowired
	private iParseoGeneroSerie iParseoGeneroSerie;

	@Autowired
	private iParseoTemporada iParseoTemporada;

	@Autowired
	private IParseoSuscripcion iParseoSuscripcion;

	/**
     * Este método se ejecuta automáticamente tras la inicialización de la aplicacion.
     * Se encarga de cargar los datos iniciales desde archivos CSV.
     *  
     * @throws DamfilmsServerError Si ocurre un error en el servidor durante el proceso.
     * @throws FileNotFoundException Si alguno de los archivos CSV no se encuentra.
     */
	@PostConstruct
	@Transactional(readOnly = false)
	public void parsea()
	{
		
		try {
			// Define la ruta comun a todos los ficheros CSV.
			String ruta = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "static"
					+ File.separator + "csv" + File.separator;
	
			// Define los objetos de ficheros CSV.
			File fileGeneros = new File(ruta + "generos.csv");
			File fileTipos = new File(ruta + "tipos.csv");
			File fileSeries = new File(ruta + "series.csv");
			File fileTemporadas = new File(ruta + "temporadas.csv");
			File filePeliculas = new File(ruta + "peliculas.csv");
			File fileDocumentales = new File(ruta + "documentales.csv");
			File fileGeneroPeliculas = new File(ruta + "generoPeliculas.csv");
			File fileGeneroSeries = new File(ruta + "generoSeries.csv");
			File fileSuscripciones = new File(ruta + "suscripciones.csv");
	
			// Bloque de parseo.
			try (Scanner scannerGeneros = new Scanner(fileGeneros))
			{
				iParseoGenero.parseaFicheros(scannerGeneros);
			}
	
			try (Scanner scannerTipo = new Scanner(fileTipos))
			{
				iParseoTipo.parseaFicheros(scannerTipo);
			}
	
			try (Scanner scannerSeries = new Scanner(fileSeries))
			{
				iParseoSerie.parseaFicheros(scannerSeries);
			}
	
			try (Scanner scannerTemporadas = new Scanner(fileTemporadas))
			{
				iParseoTemporada.parseaFicheros(scannerTemporadas);
			}
	
			try (Scanner scannerPeliculas = new Scanner(filePeliculas))
			{
				iParseoPelicula.parseaFicheros(scannerPeliculas);
			}
	
			try (Scanner scannerDocumentales = new Scanner(fileDocumentales))
			{
				iParseoDocumental.parseaFicheros(scannerDocumentales);
			}
	
			try (Scanner scannerGeneroPeliculas = new Scanner(fileGeneroPeliculas))
			{
				iParseoGeneroPelicula.parseaFicheros(scannerGeneroPeliculas);
			}
	
			try (Scanner scannerGeneroSeries = new Scanner(fileGeneroSeries))
			{
				iParseoGeneroSerie.parseaFicheros(scannerGeneroSeries);
			}
	
			try (Scanner scannerSuscripciones = new Scanner(fileSuscripciones))
			{
				iParseoSuscripcion.parseaFicheros(scannerSuscripciones);
			}
		
		}
		catch ( Exception e ){
			log.error( "{} - ERROR EN MECANISMO DE PARSEO: {}", Constants.DEBUG_TAG, e.getMessage() );
		}

	}
}

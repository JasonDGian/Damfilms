package es.iesjandula.damfilms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import es.iesjandula.damfilms.services.parsers.IParseoDocumental;
import es.iesjandula.damfilms.services.parsers.IParseoGenero;
import es.iesjandula.damfilms.services.parsers.IParseoPelicula;
import es.iesjandula.damfilms.services.parsers.IParseoSerie;
import es.iesjandula.damfilms.services.parsers.IParseoTipo;
import es.iesjandula.damfilms.services.parsers.iParseoGeneroPelicula;
import es.iesjandula.damfilms.services.parsers.iParseoGeneroSerie;
import es.iesjandula.damfilms.services.parsers.iParseoTemporada;
import es.iesjandula.damfilms.utils.DamfilmsServerError;

@SpringBootApplication
public class DamfilmsApplication implements CommandLineRunner{
	
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

	public static void main(String[] args) throws DamfilmsServerError
	{
		SpringApplication.run(DamfilmsApplication.class, args);
	}
	
    @Transactional(readOnly = false)
    public void run(String... args) throws DamfilmsServerError, FileNotFoundException {
    	
        File fileGeneros = new File("src"+File.separator+"main"+File.separator+"resources"+File.separator+"static"+File.separator+"csv"+File.separator+"generos.csv");
        Scanner scannerGeneros = new Scanner(fileGeneros);
        iParseoGenero.parseaFicheros(scannerGeneros);
        
        File fileTipos = new File("src"+File.separator+"main"+File.separator+"resources"+File.separator+"static"+File.separator+"csv"+File.separator+"tipos.csv");
        Scanner scannerTipo = new Scanner(fileTipos);
        iParseoTipo.parseaFicheros(scannerTipo);
        
        File fileSeries = new File("src"+File.separator+"main"+File.separator+"resources"+File.separator+"static"+File.separator+"csv"+File.separator+"series.csv");
        Scanner scannerSeries = new Scanner(fileSeries);
        iParseoSerie.parseaFicheros(scannerSeries);
        
        File fileTemporadas = new File("src"+File.separator+"main"+File.separator+"resources"+File.separator+"static"+File.separator+"csv"+File.separator+"temporadas.csv");
        Scanner scannerTemporadas = new Scanner(fileTemporadas);
        iParseoTemporada.parseaFicheros(scannerTemporadas);

        File filePeliculas = new File("src"+File.separator+"main"+File.separator+"resources"+File.separator+"static"+File.separator+"csv"+File.separator+"peliculas.csv");
        Scanner scannerPeliculas = new Scanner(filePeliculas);
        iParseoPelicula.parseaFicheros(scannerPeliculas);

        File fileDocumentales = new File("src"+File.separator+"main"+File.separator+"resources"+File.separator+"static"+File.separator+"csv"+File.separator+"documentales.csv");
        Scanner scannerDocumentales = new Scanner(fileDocumentales);
        iParseoDocumental.parseaFicheros(scannerDocumentales);
        
        File fileGeneroPeliculas = new File("src"+File.separator+"main"+File.separator+"resources"+File.separator+"static"+File.separator+"csv"+File.separator+"generoPeliculas.csv");
        Scanner scannerGeneroPeliculas = new Scanner(fileGeneroPeliculas);
        iParseoGeneroPelicula.parseaFicheros(scannerGeneroPeliculas);
        
        File fileGeneroSeries = new File("src"+File.separator+"main"+File.separator+"resources"+File.separator+"static"+File.separator+"csv"+File.separator+"generoSeries.csv");
        Scanner scannerGeneroSeries = new Scanner(fileGeneroSeries);
        iParseoGeneroSerie.parseaFicheros(scannerGeneroSeries);

    }

}

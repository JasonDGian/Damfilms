package es.iesjandula.damfilms.services.parsers;

import java.util.Scanner;

import es.iesjandula.damfilms.utils.DamfilmsServerError;

/**
 * Interfaz que define el método para parsear ficheros relacionados con géneros de películas.
 * Esta interfaz establece un contrato para el análisis o parseo de ficheros utilizando 
 * un objeto Scanner.
 */
public interface iParseoGeneroPelicula {

    /**
     * Método que parsea un fichero relacionado con géneros de películas utilizando un objeto Scanner.
     * El parseo de los ficheros puede generar errores, los cuales serán 
     * capturados y gestionados mediante una excepción personalizada.
     * 
     * @param scanner El objeto {@link Scanner} que se utiliza para leer los datos del fichero.
     */
    void parseaFicheros(Scanner scanner) throws DamfilmsServerError;

}

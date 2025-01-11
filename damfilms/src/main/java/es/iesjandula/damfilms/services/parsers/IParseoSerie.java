package es.iesjandula.damfilms.services.parsers;

import java.util.Scanner;

import es.iesjandula.damfilms.utils.DamfilmsServerError;

/**
 * Interface que define el método para parsear ficheros de series.
 * Esta interfaz es utilizada para proporcionar un contrato que
 * permita el análisis o parseo de ficheros a partir de un objeto Scanner.
 */
public interface IParseoSerie {

    /**
     * Método que parsea un fichero de series utilizando un objeto Scanner.
     * El parseo de los ficheros puede generar errores, los cuales serán 
     * capturados y gestionados mediante una excepción personalizada.
     * 
     * @param scanner El objeto {@link Scanner} que lee los datos del fichero.
     */
    void parseaFicheros(Scanner scanner) throws DamfilmsServerError;

}

package es.iesjandula.damfilms.services.parsers;

import java.util.Scanner;

import es.iesjandula.damfilms.utils.DamfilmsServerError;

/**
 * Interfaz que define el método para parsear ficheros relacionados con géneros.
 * Esta interfaz establece un contrato que debe ser implementado por las clases
 * encargadas de procesar ficheros que contienen información de géneros.
 */
public interface IParseoGenero {

    /**
     * Método que parsea un fichero de generos utilizando un objeto Scanner.
     * El parseo de los ficheros puede generar errores, los cuales serán 
     * capturados y gestionados mediante una excepción personalizada.
     * 
     * @param scanner El objeto {@link Scanner} que lee los datos del fichero.
     */
    void parseaFicheros(Scanner scanner) throws DamfilmsServerError;
    
}

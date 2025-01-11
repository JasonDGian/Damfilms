package es.iesjandula.damfilms.services.parsers;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.damfilms.models.Genero;
import es.iesjandula.damfilms.repositories.IGeneroRepository;
import es.iesjandula.damfilms.utils.DamfilmsServerError;

/**
 * Servicio encargado de parsear los ficheros de datos y almacenar la información
 * de géneros en la base de datos.
 */
@Service
public class ParseoGeneroImpl implements IParseoGenero {

    @Autowired
    IGeneroRepository generoRepository;

    /**
     * Método que procesa las líneas de un fichero de entrada, crea objetos
     * Genero a partir de ellas y los guarda en la base de datos.
     * 
     * @param scanner Objeto Scanner que lee las líneas del fichero.
     * @throws DamfilmsServerError Si ocurre un error al procesar el fichero o
     *                              almacenar los géneros.
     */
    @Override
    public void parseaFicheros(Scanner scanner) throws DamfilmsServerError {

        scanner.nextLine();

        while (scanner.hasNextLine()) {

            String lineaDelFichero = scanner.nextLine();

            Genero genero = new Genero();

            genero.setNombre(lineaDelFichero);

            this.generoRepository.saveAndFlush(genero);
        }

    }

}

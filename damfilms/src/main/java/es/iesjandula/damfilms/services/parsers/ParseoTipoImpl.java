package es.iesjandula.damfilms.services.parsers;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.damfilms.models.Tipo;
import es.iesjandula.damfilms.repositories.ITipoRepository;
import es.iesjandula.damfilms.utils.DamfilmsServerError;

/**
 * Servicio encargado de parsear los ficheros de datos relacionados con los
 * tipos y almacenarlos en la base de datos.
 */
@Service
public class ParseoTipoImpl implements IParseoTipo {

    @Autowired
    ITipoRepository tipoRepository;
    
    /**
     * Método que procesa las líneas de un fichero de entrada, crea objetos de tipo
     * Tipo y los guarda en la base de datos.
     * 
     * @param scanner Objeto Scanner que lee las líneas del fichero.
     * @throws DamfilmsServerError Si ocurre un error al procesar el fichero o
     *                              almacenar los tipos en la base de datos.
     */
    @Override
    public void parseaFicheros(Scanner scanner) throws DamfilmsServerError {

        scanner.nextLine();

        while (scanner.hasNextLine()) {

            String lineaDelFichero = scanner.nextLine();

            Tipo tipo = new Tipo();

            tipo.setNombre(lineaDelFichero);

            this.tipoRepository.saveAndFlush(tipo);
        }
    }
}

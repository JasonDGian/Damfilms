package es.iesjandula.damfilms.services.parsers;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.damfilms.models.Suscripcion;
import es.iesjandula.damfilms.repositories.ISuscripcionRepository;
import es.iesjandula.damfilms.utils.DamfilmsServerError;

/**
 * Servicio encargado de parsear los ficheros de datos relacionados con las
 * suscripciones y almacenar esa información en la base de datos.
 */
@Service
public class ParseoSuscripcionImpl implements IParseoSuscripcion {

    @Autowired
    ISuscripcionRepository iSuscripcionRepository;
    
    /**
     * Método que procesa las líneas de un fichero de entrada, crea objetos de tipo
     * Suscripcion y los guarda en la base de datos.
     * 
     * @param scanner Objeto Scanner que lee las líneas del fichero.
     * @throws DamfilmsServerError Si ocurre un error al procesar el fichero o
     *                              almacenar las suscripciones en la base de datos.
     */
    @Override
    public void parseaFicheros(Scanner scanner) throws DamfilmsServerError {

        scanner.nextLine();

        while (scanner.hasNextLine()) {

            String lineaDelFichero = scanner.nextLine();
            
            String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");

            Suscripcion suscripcion = new Suscripcion();
            
            suscripcion.setRole(lineaDelFicheroTroceada[0]);
            suscripcion.setNombre(lineaDelFicheroTroceada[1]);
            suscripcion.setPrecioMensual(Double.valueOf(lineaDelFicheroTroceada[2]));
            
            this.iSuscripcionRepository.saveAndFlush(suscripcion);
        }
    }
}

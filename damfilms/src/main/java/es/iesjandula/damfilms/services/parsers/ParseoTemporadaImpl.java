package es.iesjandula.damfilms.services.parsers;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.damfilms.models.Serie;
import es.iesjandula.damfilms.models.Temporada;
import es.iesjandula.damfilms.models.ids.TemporadaId;
import es.iesjandula.damfilms.repositories.ISerieRepository;
import es.iesjandula.damfilms.repositories.ITemporadaRepository;
import es.iesjandula.damfilms.utils.DamfilmsServerError;
import es.iesjandula.damfilms.utils.DatesUtil;

/**
 * Servicio encargado de parsear los ficheros de datos relacionados con las
 * temporadas y almacenarlas en la base de datos, vinculándolas con las series
 * correspondientes.
 */
@Service
public class ParseoTemporadaImpl implements iParseoTemporada {
    
    @Autowired
    ITemporadaRepository iTemporadaRepository;
    
    @Autowired
    ISerieRepository iSerieRepository;
    
    /**
     * Método que procesa las líneas de un fichero de entrada, crea objetos de tipo
     * Temporada y los guarda en la base de datos, asociándolos con las series
     * correspondientes.
     * 
     * @param scanner Objeto Scanner que lee las líneas del fichero.
     * @throws DamfilmsServerError Si ocurre un error al procesar el fichero o
     *                              almacenar las temporadas en la base de datos.
     */
    @Override
    public void parseaFicheros(Scanner scanner) throws DamfilmsServerError {

        scanner.nextLine();

        while (scanner.hasNextLine()) {

            String lineaDelFichero = scanner.nextLine();

            String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");

            Temporada temporada = new Temporada();
            TemporadaId temporadaId = new TemporadaId();

            temporadaId.setNumeroTemporada(Integer.valueOf(lineaDelFicheroTroceada[0]));
            temporada.setNombre(lineaDelFicheroTroceada[2]);
            temporada.setFechaLanzamiento(DatesUtil.crearFechaDesdeString((lineaDelFicheroTroceada[3])));
            temporada.setNumeroCapitulos(Integer.valueOf((lineaDelFicheroTroceada[4])));

            Optional<Serie> optionalSerie = this.iSerieRepository.findById(Long.valueOf((lineaDelFicheroTroceada[1])));
            if (!optionalSerie.isEmpty()) {
            	
                temporadaId.setId(optionalSerie.get().getId());
                temporada.setTemporadaId(temporadaId);
                temporada.setSerie(optionalSerie.get());

                iTemporadaRepository.saveAndFlush(temporada);

                optionalSerie.get().getTemporadas().add(temporada);

                iSerieRepository.saveAndFlush(optionalSerie.get());
            }
        }
    }
}

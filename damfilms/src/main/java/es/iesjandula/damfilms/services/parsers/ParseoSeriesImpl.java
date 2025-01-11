package es.iesjandula.damfilms.services.parsers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.damfilms.models.Serie;
import es.iesjandula.damfilms.models.Temporada;
import es.iesjandula.damfilms.models.Tipo;
import es.iesjandula.damfilms.repositories.ISerieRepository;
import es.iesjandula.damfilms.repositories.ITemporadaRepository;
import es.iesjandula.damfilms.repositories.ITipoRepository;
import es.iesjandula.damfilms.utils.DamfilmsServerError;

/**
 * Servicio encargado de parsear los ficheros de datos relacionados con las series
 * y almacenar esa información en la base de datos.
 */
@Service
public class ParseoSeriesImpl implements IParseoSerie {

    @Autowired
    ISerieRepository serieRepository;

    @Autowired
    ITipoRepository tipoRepository;
    
    @Autowired
    ITemporadaRepository iTemporadaRepository;
    
    /**
     * Método que procesa las líneas de un fichero de entrada, crea objetos de tipo
     * Serie y los guarda en la base de datos.
     * 
     * @param scanner Objeto Scanner que lee las líneas del fichero.
     * @throws DamfilmsServerError Si ocurre un error al procesar el fichero o
     *                              almacenar las series en la base de datos.
     */
    @Override
    public void parseaFicheros(Scanner scanner) throws DamfilmsServerError {

        LocalDateTime now = LocalDateTime.now();
        Date date = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        
        scanner.nextLine();

        while (scanner.hasNextLine()) {

            String lineaDelFichero = scanner.nextLine();

            String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");

            Serie serie = new Serie();
            List<Temporada> listaTemporadas = new ArrayList<Temporada>();

            serie.setTitulo(lineaDelFicheroTroceada[1]);
            serie.setDuracion(lineaDelFicheroTroceada[2]);
            serie.setFechaLlegada(date);
            serie.setPoster(lineaDelFicheroTroceada[3]);

            Optional<Tipo> optionalTipo = this.tipoRepository.findById(lineaDelFicheroTroceada[4]);
            if (!optionalTipo.isEmpty()) {
                serie.setTipo(optionalTipo.get());
            }

            serie.setPopindex(Integer.valueOf(lineaDelFicheroTroceada[5]));
            
            serie.setTemporadas(listaTemporadas);

            serieRepository.saveAndFlush(serie);
        }

    }
}

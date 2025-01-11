package es.iesjandula.damfilms.services.parsers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.damfilms.models.Pelicula;
import es.iesjandula.damfilms.models.Tipo;
import es.iesjandula.damfilms.models.ids.PeliculaId;
import es.iesjandula.damfilms.repositories.IPeliculaRepository;
import es.iesjandula.damfilms.repositories.ITipoRepository;
import es.iesjandula.damfilms.utils.DamfilmsServerError;
import es.iesjandula.damfilms.utils.DatesUtil;

/**
 * Servicio encargado de parsear los ficheros de datos relacionados con las películas
 * y almacenar esa información en la base de datos.
 */
@Service
public class ParseoPeliculasImpl implements IParseoPelicula {

    @Autowired
    IPeliculaRepository peliculaRepository;

    @Autowired
    ITipoRepository tipoRepository;
    
    /**
     * Método que procesa las líneas de un fichero de entrada, crea objetos de tipo
     * Pelicula y los guarda en la base de datos.
     * 
     * @param scanner Objeto Scanner que lee las líneas del fichero.
     * @throws DamfilmsServerError Si ocurre un error al procesar el fichero o
     *                              almacenar las películas en la base de datos.
     */
    @Override
    public void parseaFicheros(Scanner scanner) throws DamfilmsServerError {

        LocalDateTime now = LocalDateTime.now();
        Date date = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());

        scanner.nextLine();

        while (scanner.hasNextLine()) {

            String lineaDelFichero = scanner.nextLine();

            String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");

            Pelicula pelicula = new Pelicula();
            PeliculaId peliculaId = new PeliculaId();

            peliculaId.setTitulo(lineaDelFicheroTroceada[1]);
            pelicula.setDuracion(lineaDelFicheroTroceada[2]);
            peliculaId.setFechaLanzamiento(DatesUtil.crearFechaDesdeString(lineaDelFicheroTroceada[3]));
            pelicula.setPeliculaId(peliculaId);
            pelicula.setFechaLlegada(date);
            pelicula.setPoster(lineaDelFicheroTroceada[4]);

            Optional<Tipo> optionalTipo = this.tipoRepository.findById(lineaDelFicheroTroceada[5]);
            if (!optionalTipo.isEmpty()) {
                pelicula.setTipo(optionalTipo.get());
            }

            pelicula.setPopindex(Integer.valueOf(lineaDelFicheroTroceada[6]));
            pelicula.setSinopsis(lineaDelFicheroTroceada[7]);

            peliculaRepository.saveAndFlush(pelicula);
        }

    }

}

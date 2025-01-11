package es.iesjandula.damfilms.services.parsers;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.damfilms.models.Genero;
import es.iesjandula.damfilms.models.GeneroPelicula;
import es.iesjandula.damfilms.models.Pelicula;
import es.iesjandula.damfilms.models.ids.GeneroPeliculaId;
import es.iesjandula.damfilms.models.ids.PeliculaId;
import es.iesjandula.damfilms.repositories.IGeneroPeliculaRepository;
import es.iesjandula.damfilms.repositories.IGeneroRepository;
import es.iesjandula.damfilms.repositories.IPeliculaRepository;
import es.iesjandula.damfilms.utils.DamfilmsServerError;
import es.iesjandula.damfilms.utils.DatesUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Servicio encargado de parsear los ficheros de datos que asocian géneros a películas
 * y almacenar esa información en la base de datos.
 */
@Slf4j
@Service
public class ParseoGeneroPeliculaImpl implements iParseoGeneroPelicula {

    @Autowired
    IPeliculaRepository iPeliculaRepository;

    @Autowired
    IGeneroRepository iGeneroRepository;

    @Autowired
    IGeneroPeliculaRepository iGeneroPeliculaRepository;

    /**
     * Método que procesa las líneas de un fichero de entrada, crea asociaciones
     * entre películas y géneros y las guarda en la base de datos.
     * 
     * @param scanner Objeto Scanner que lee las líneas del fichero.
     * @throws DamfilmsServerError Si ocurre un error al procesar el fichero o
     *                              almacenar las asociaciones entre géneros y películas.
     */
    @Override
    public void parseaFicheros(Scanner scanner) throws DamfilmsServerError {

        scanner.nextLine();

        while (scanner.hasNextLine()) {

            String lineaDelFichero = scanner.nextLine();

            String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");

            GeneroPelicula generoPelicula = new GeneroPelicula();
            GeneroPeliculaId generoPeliculaId = new GeneroPeliculaId();

            PeliculaId peliculaId = new PeliculaId();
            peliculaId.setTitulo(lineaDelFicheroTroceada[1]);
            peliculaId.setFechaLanzamiento(DatesUtil.crearFechaDesdeString(lineaDelFicheroTroceada[2]));

            log.debug("parsea fecha correctamente" + peliculaId.getFechaLanzamiento());

            Optional<Pelicula> optionalPelicula = this.iPeliculaRepository.findById(peliculaId);
            if (!optionalPelicula.isEmpty()) {
                generoPeliculaId.setPeliculaId(optionalPelicula.get().getPeliculaId());
                log.debug("aaaae" + optionalPelicula.get().getPeliculaId());
                generoPelicula.setPelicula(optionalPelicula.get());
            }

            Optional<Genero> optionalGenero = this.iGeneroRepository.findById(lineaDelFicheroTroceada[0]);
            if (!optionalGenero.isEmpty()) {
                generoPeliculaId.setNombre(optionalGenero.get().getNombre());
                generoPelicula.setGenero(optionalGenero.get());
            }

            generoPelicula.setGeneroPeliculaId(generoPeliculaId);

            this.iGeneroPeliculaRepository.saveAndFlush(generoPelicula);
        }

    }

}

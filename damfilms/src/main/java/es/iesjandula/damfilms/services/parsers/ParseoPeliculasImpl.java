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

@Service
public class ParseoPeliculasImpl implements IParseoPelicula {

	@Autowired
	IPeliculaRepository peliculaRepository;

	@Autowired
	ITipoRepository tipoRepository;
	
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
			Optional<Tipo>optionalTipo = this.tipoRepository.findById(lineaDelFicheroTroceada[5]);
			if(!optionalTipo.isEmpty()){
			pelicula.setTipo(optionalTipo.get());
			}
			pelicula.setPopindex(Integer.valueOf(lineaDelFicheroTroceada[6]));
			pelicula.setSinopsis(lineaDelFicheroTroceada[7]);
			peliculaRepository.saveAndFlush(pelicula);
			
		}

	}
}

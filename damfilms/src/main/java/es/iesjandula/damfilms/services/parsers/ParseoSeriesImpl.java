package es.iesjandula.damfilms.services.parsers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.damfilms.models.Serie;
import es.iesjandula.damfilms.models.Tipo;
import es.iesjandula.damfilms.repositories.ISerieRepository;
import es.iesjandula.damfilms.repositories.ITipoRepository;
import es.iesjandula.damfilms.utils.DamfilmsServerError;

@Service
public class ParseoSeriesImpl implements IParseoSerie {

	@Autowired
	ISerieRepository serieRepository;

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

			Serie serie = new Serie();

			serie.setTitulo(lineaDelFicheroTroceada[1]);
			serie.setDuracion(lineaDelFicheroTroceada[2]);
			serie.setFechaLlegada(date);
			serie.setPoster(lineaDelFicheroTroceada[5]);
			Optional<Tipo>optionalTipo = this.tipoRepository.findById(lineaDelFicheroTroceada[4]);
			if(!optionalTipo.isEmpty()){
			serie.setTipo(optionalTipo.get());
			}
			serie.setPopindex(Integer.valueOf(lineaDelFicheroTroceada[7]));
			serieRepository.saveAndFlush(serie);
			
		}

	}
}

package es.iesjandula.damfilms.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.damfilms.models.Documental;
import es.iesjandula.damfilms.models.Genero;
import es.iesjandula.damfilms.models.Ids.DocumentalId;
import es.iesjandula.damfilms.repositories.IDocumentalRepository;
import es.iesjandula.damfilms.repositories.IGeneroRepository;
import es.iesjandula.damfilms.utils.DamfilmsServerError;
import es.iesjandula.damfilms.utils.DatesUtil;

@Service
public class ParseoDocumentalImpl implements IParseoDocumental {

	@Autowired
	IDocumentalRepository documentalRepository;

	@Autowired
	IGeneroRepository generoRepository;
	
	@Override
	public void parseaFicheros(Scanner scanner) throws DamfilmsServerError {

		scanner.nextLine();

		while (scanner.hasNextLine()) {

			LocalDateTime now = LocalDateTime.now();

	        Date date = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
			
			String lineaDelFichero = scanner.nextLine();

			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");

			Documental documental = new Documental();

			DocumentalId documentalId = new DocumentalId();
			
			documentalId.setTitulo(lineaDelFicheroTroceada[1]);
			documentalId.setFechaLanzamiento(DatesUtil.crearFechaDesdeString(lineaDelFicheroTroceada[3]));
			documental.setDocumentalId(documentalId);
			documental.setDuracion(lineaDelFicheroTroceada[2]);
			documental.setFechaLlegada(date);
			Optional<Genero>optionalGenero = this.generoRepository.findById(lineaDelFicheroTroceada[4]);
			if(!optionalGenero.isEmpty()){
			documental.setGenero(optionalGenero.get());
			}
			documental.setPoster(lineaDelFicheroTroceada[5]);
			documental.setPopindex(Integer.valueOf(lineaDelFicheroTroceada[6]));
			documentalRepository.saveAndFlush(documental);
		}

	}
}

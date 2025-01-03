package es.iesjandula.damfilms.services.parsers;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.damfilms.models.Genero;
import es.iesjandula.damfilms.models.GeneroSerie;
import es.iesjandula.damfilms.models.Serie;
import es.iesjandula.damfilms.models.ids.GeneroSerieId;
import es.iesjandula.damfilms.repositories.IGeneroRepository;
import es.iesjandula.damfilms.repositories.IGeneroSerieRepository;
import es.iesjandula.damfilms.repositories.ISerieRepository;
import es.iesjandula.damfilms.utils.DamfilmsServerError;

@Service
public class ParseoGeneroSerieImpl implements iParseoGeneroSerie{
	
	@Autowired
	ISerieRepository iSerieRepository;
	
	@Autowired
	IGeneroRepository iGeneroRepository;
	
	@Autowired
	IGeneroSerieRepository iGeneroSerieRepository;
	
	@Override
	public void parseaFicheros(Scanner scanner) throws DamfilmsServerError 
	{
		scanner.nextLine();

		while (scanner.hasNextLine()) {

			String lineaDelFichero = scanner.nextLine();

			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");

			GeneroSerie generoSerie = new GeneroSerie();
			GeneroSerieId generoSerieId = new GeneroSerieId();
			
			Optional<Serie>optionalSerie = this.iSerieRepository.findById(Long.valueOf(lineaDelFicheroTroceada[1]));
			if(!optionalSerie.isEmpty()){
			generoSerieId.setId(optionalSerie.get().getId());
			
			generoSerie.setSerie(optionalSerie.get());
			}
			
			Optional<Genero>optionalGenero = this.iGeneroRepository.findById(lineaDelFicheroTroceada[0]);
			if(!optionalGenero.isEmpty()){
			generoSerieId.setNombre(optionalGenero.get().getNombre());
			
			generoSerie.setGenero(optionalGenero.get());
			}
			
			generoSerie.setGeneroSerieId(generoSerieId);
			
			this.iGeneroSerieRepository.saveAndFlush(generoSerie);
		}
	}

}

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
import es.iesjandula.damfilms.models.ids.TemporadaId;
import es.iesjandula.damfilms.repositories.ISerieRepository;
import es.iesjandula.damfilms.repositories.ITemporadaRepository;
import es.iesjandula.damfilms.repositories.ITipoRepository;
import es.iesjandula.damfilms.utils.DamfilmsServerError;

@Service
public class ParseoSeriesImpl implements IParseoSerie {

	@Autowired
	ISerieRepository serieRepository;

	@Autowired
	ITipoRepository tipoRepository;
	
	@Autowired
	ITemporadaRepository iTemporadaRepository;
	
	@Override
	public void parseaFicheros(Scanner scanner) throws DamfilmsServerError {

		LocalDateTime now = LocalDateTime.now();

        Date date = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
		
		scanner.nextLine();

		while (scanner.hasNextLine()) {

			String lineaDelFichero = scanner.nextLine();

			String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");
			
			//String[] lineaDelFicheroTroceadaTemporadas = lineaDelFicheroTroceada[7].split(" ");

			Serie serie = new Serie();
			
			List<Temporada> listaTemporadas = new ArrayList<Temporada>();

			serie.setTitulo(lineaDelFicheroTroceada[1]);
			serie.setDuracion(lineaDelFicheroTroceada[2]);
			serie.setFechaLlegada(date);
			serie.setPoster(lineaDelFicheroTroceada[3]);
			Optional<Tipo>optionalTipo = this.tipoRepository.findById(lineaDelFicheroTroceada[4]);
			if(!optionalTipo.isEmpty()){
			serie.setTipo(optionalTipo.get());
			}
			serie.setPopindex(Integer.valueOf(lineaDelFicheroTroceada[5]));
			
			serie.setTemporadas(listaTemporadas);
			
			/*
			List<Temporada> listaTemporadasId = new ArrayList<Temporada>(); 
			
			for (String temporada : lineaDelFicheroTroceadaTemporadas)
			{
				String[] lineaDelFicheroTroceadaElementos = temporada.split(":");
				
				TemporadaId temporadaId = new TemporadaId(Integer.valueOf(lineaDelFicheroTroceadaElementos[0]),Long.valueOf(lineaDelFicheroTroceadaElementos[1]));
				
				
				
				Optional<Temporada>optionalTemporada = this.iTemporadaRepository.findById(temporadaId);
				if(!optionalTemporada.isEmpty()){
					listaTemporadasId.add(optionalTemporada.get());
				}	
				
				
			}
			
			serie.setTemporadas(listaTemporadasId);
			*/
			
			serieRepository.saveAndFlush(serie);
			
		}

	}
}

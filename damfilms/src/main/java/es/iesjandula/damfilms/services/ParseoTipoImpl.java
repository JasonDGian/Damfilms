package es.iesjandula.damfilms.services;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.damfilms.models.Tipo;
import es.iesjandula.damfilms.repositories.ITipoRepository;
import es.iesjandula.damfilms.utils.DamfilmsServerError;

@Service
public class ParseoTipoImpl implements IParseoTipo
{

	@Autowired
	ITipoRepository tipoRepository;
	
	@Override
	public void parseaFicheros(Scanner scanner) throws DamfilmsServerError 
	{

		scanner.nextLine();

		while(scanner.hasNextLine()) 
		{

		String lineaDelFichero = scanner.nextLine();

		Tipo tipo = new Tipo();

		tipo.setNombre(lineaDelFichero);
		
		this.tipoRepository.saveAndFlush(tipo);
		}

	}
	
}

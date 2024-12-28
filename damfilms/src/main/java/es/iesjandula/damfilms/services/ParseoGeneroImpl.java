package es.iesjandula.damfilms.services;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.damfilms.models.Genero;
import es.iesjandula.damfilms.repositories.IGeneroRepository;
import es.iesjandula.damfilms.utils.DamfilmsServerError;

@Service
public class ParseoGeneroImpl implements IParseoGenero
{

	@Autowired
	IGeneroRepository generoRepository;
		
	@Override
	public void parseaFicheros(Scanner scanner) throws DamfilmsServerError 
	{

		scanner.nextLine();

		while(scanner.hasNextLine()) 
		{

		String lineaDelFichero = scanner.nextLine();

		Genero genero = new Genero();
			
		genero.setNombre(lineaDelFichero);
				
		this.generoRepository.saveAndFlush(genero);
		}

	}
	
}

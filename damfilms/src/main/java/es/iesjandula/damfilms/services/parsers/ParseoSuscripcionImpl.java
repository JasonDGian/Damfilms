package es.iesjandula.damfilms.services.parsers;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.damfilms.models.Suscripcion;
import es.iesjandula.damfilms.repositories.ISuscripcionRepository;
import es.iesjandula.damfilms.utils.DamfilmsServerError;

@Service
public class ParseoSuscripcionImpl implements IParseoSuscripcion
{

	@Autowired
	ISuscripcionRepository iSuscripcionRepository;
		
	@Override
	public void parseaFicheros(Scanner scanner) throws DamfilmsServerError 
	{

		scanner.nextLine();

		while(scanner.hasNextLine()) 
		{

		String lineaDelFichero = scanner.nextLine();
		
		String[] lineaDelFicheroTroceada = lineaDelFichero.split(",");

		Suscripcion suscripcion = new Suscripcion();
			
		suscripcion.setRole(lineaDelFicheroTroceada[0]);
		
		suscripcion.setNombre(lineaDelFicheroTroceada[1]);
		
		suscripcion.setPrecioMensual(Double.valueOf(lineaDelFicheroTroceada[2]));
				
		this.iSuscripcionRepository.saveAndFlush(suscripcion);
		}

	}
	
}

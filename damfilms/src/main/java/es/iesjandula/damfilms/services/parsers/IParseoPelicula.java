package es.iesjandula.damfilms.services.parsers;

import java.util.Scanner;

import es.iesjandula.damfilms.utils.DamfilmsServerError;

public interface IParseoPelicula {

	void parseaFicheros(Scanner scanner) throws DamfilmsServerError;
	
}

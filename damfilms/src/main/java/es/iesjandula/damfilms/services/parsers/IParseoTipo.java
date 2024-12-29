package es.iesjandula.damfilms.services.parsers;

import java.util.Scanner;

import es.iesjandula.damfilms.utils.DamfilmsServerError;

public interface IParseoTipo {

	void parseaFicheros(Scanner scanner) throws DamfilmsServerError;
	
}

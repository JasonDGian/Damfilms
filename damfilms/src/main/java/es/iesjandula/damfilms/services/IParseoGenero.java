package es.iesjandula.damfilms.services;

import java.util.Scanner;

import es.iesjandula.damfilms.utils.DamfilmsServerError;

public interface IParseoGenero {

	void parseaFicheros(Scanner scanner) throws DamfilmsServerError;
	
}

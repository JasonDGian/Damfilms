package es.iesjandula.damfilms.services.parsers;

import java.util.Scanner;

import es.iesjandula.damfilms.utils.DamfilmsServerError;

public interface iParseoTemporada {
	
	void parseaFicheros(Scanner scanner) throws DamfilmsServerError;

}

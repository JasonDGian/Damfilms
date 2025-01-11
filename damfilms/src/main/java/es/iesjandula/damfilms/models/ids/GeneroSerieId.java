package es.iesjandula.damfilms.models.ids;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa el identificador compuesto para la relación entre un género y una serie.
 * 
 * Esta clase se utiliza como identificador único compuesto para la relación entre un género y una serie.
 * El identificador está compuesto por el nombre del género y el identificador de la serie.
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class GeneroSerieId implements Serializable{
	
	/**
	 * Serial Version UID.
	 * Se utiliza para asegurar que los objetos serializados sean compatibles entre diferentes versiones.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Nombre del género.
	 * Representa el nombre único del género asociado a una serie, utilizado como parte del identificador compuesto.
	 */
	private String nombre;
	
	/**
	 * Identificador de la serie.
	 * Representa el identificador único de la serie en la base de datos, utilizado junto con el nombre del género 
	 * para formar el identificador compuesto.
	 */
	private Long id;
}

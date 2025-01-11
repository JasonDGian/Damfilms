package es.iesjandula.damfilms.models.ids;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa el identificador compuesto para una temporada de una serie.
 * 
 * Esta clase se utiliza como identificador único compuesto para una temporada en una serie.
 * El identificador está compuesto por el número de temporada y el identificador de la serie.
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class TemporadaId implements Serializable{
	
	/**
	 * Serial Version UID.
	 * Se utiliza para asegurar que los objetos serializados sean compatibles entre diferentes versiones.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Número de la temporada.
	 * Representa el número único de la temporada dentro de una serie.
	 */
	private int numeroTemporada;
	
	/**
	 * Identificador de la serie.
	 * Representa el identificador único de la serie asociada a esta temporada.
	 */
	private Long id;
}

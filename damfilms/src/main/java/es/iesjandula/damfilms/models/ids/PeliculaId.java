package es.iesjandula.damfilms.models.ids;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa el identificador compuesto para una película.
 * 
 * Esta clase se utiliza como un identificador único compuesto para un objeto `Pelicula` en la base de datos.
 * El identificador está compuesto por el título de la película y la fecha de lanzamiento.
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PeliculaId implements Serializable{
	
	/**
	 * Serial Version UID.
	 * Se utiliza para asegurar que los objetos serializados sean compatibles entre diferentes versiones.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Título de la película.
	 * Representa el título único de la película utilizado como parte del identificador compuesto.
	 */
	private String titulo;
	
	/**
	 * Fecha de lanzamiento de la película.
	 * Representa la fecha en que la película fue lanzada, utilizada junto con el título para formar el identificador.
	 */
	private Date fechaLanzamiento;
}

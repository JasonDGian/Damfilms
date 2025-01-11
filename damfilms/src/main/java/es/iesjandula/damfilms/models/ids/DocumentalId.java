package es.iesjandula.damfilms.models.ids;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa el identificador compuesto para un documental.
 * 
 * Esta clase se utiliza como un identificador único compuesto para un objeto `Documental` en la base de datos.
 * El identificador está compuesto por el título y la fecha de lanzamiento del documental.
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class DocumentalId implements Serializable{
	
	/**
	 * Serial Version UID.
	 * Se utiliza para asegurar que los objetos serializados sean compatibles entre diferentes versiones.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Título del documental.
	 * Representa el título único del documental utilizado como parte del identificador compuesto.
	 */
	private String titulo;
	
	/**
	 * Fecha de lanzamiento del documental.
	 * Representa la fecha en que el documental fue lanzado, utilizada junto con el título para formar el identificador.
	 */
	private Date fechaLanzamiento;
}

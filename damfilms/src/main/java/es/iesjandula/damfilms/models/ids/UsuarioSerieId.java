package es.iesjandula.damfilms.models.ids;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa el identificador compuesto para la relación entre un usuario y una serie.
 * 
 * Esta clase se utiliza como identificador único compuesto para la relación entre un usuario y una serie.
 * El identificador está compuesto por el correo electrónico del usuario y el identificador de la serie.
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UsuarioSerieId implements Serializable{
	
	/**
	 * Serial Version UID.
	 * Se utiliza para asegurar que los objetos serializados sean compatibles entre diferentes versiones.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Correo electrónico del usuario.
	 * Representa el correo electrónico único del usuario asociado a la serie.
	 */
	private String email;
	
	/**
	 * Identificador de la serie.
	 * Representa el identificador único de la serie asociada a este usuario.
	 */
	private Long id;
}

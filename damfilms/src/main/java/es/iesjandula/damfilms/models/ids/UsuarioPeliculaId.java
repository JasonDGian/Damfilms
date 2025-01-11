package es.iesjandula.damfilms.models.ids;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa el identificador compuesto para la relación entre un usuario y una película.
 * 
 * Esta clase se utiliza como identificador único compuesto para la relación entre un usuario y una película.
 * El identificador está compuesto por el correo electrónico del usuario y el identificador de la película.
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UsuarioPeliculaId implements Serializable{
	
	/**
	 * Serial Version UID.
	 * Se utiliza para asegurar que los objetos serializados sean compatibles entre diferentes versiones.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Correo electrónico del usuario.
	 * Representa el correo electrónico único del usuario asociado a la película.
	 */
	private String email;
	
	/**
	 * Identificador de la película.
	 * Representa el identificador único de la película asociada a este usuario.
	 */
	private PeliculaId peliculaId;
}

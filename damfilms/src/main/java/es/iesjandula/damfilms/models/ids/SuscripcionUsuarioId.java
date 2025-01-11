package es.iesjandula.damfilms.models.ids;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa el identificador compuesto para la relación entre una suscripción y un usuario.
 * 
 * Esta clase se utiliza como identificador único compuesto para la relación entre una suscripción y un usuario.
 * El identificador está compuesto por el rol de la suscripción, el correo electrónico del usuario, 
 * la fecha de inicio y la fecha de finalización de la suscripción.
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SuscripcionUsuarioId implements Serializable {
	
	/**
	 * Serial Version UID.
	 * Se utiliza para asegurar que los objetos serializados sean compatibles entre diferentes versiones.
	 */
	private static final long serialVersionUID = -1130256513559577542L;

	/**
	 * Rol de la suscripción.
	 * Representa el tipo o rol asociado a la suscripción de un usuario (por ejemplo, "Premium", "Básico", etc.).
	 */
	private String role;
	
	/**
	 * Correo electrónico del usuario.
	 * Representa el correo electrónico único del usuario asociado a la suscripción.
	 */
	private String email;
	
	/**
	 * Fecha de inicio de la suscripción.
	 * Representa la fecha en que la suscripción del usuario comienza a ser válida.
	 */
	private Date fechaInicio;

	/**
	 * Fecha de finalización de la suscripción.
	 * Representa la fecha en que la suscripción del usuario expira o termina.
	 */
	private Date fechaFin;
}

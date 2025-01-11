package es.iesjandula.damfilms.dtos;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) que representa una suscripción asociada a un usuario.
 * 
 * Esta clase es utilizada para transferir la información sobre una suscripción de un usuario,
 * incluyendo detalles sobre el rol, las fechas de inicio y fin, el usuario asociado, 
 * la suscripción específica y el precio total de la suscripción.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuscripcionUsuarioDto {

	/**
	 * Rol del usuario en la suscripción.
	 * Representa el tipo de acceso o nivel de suscripción que tiene el usuario (por ejemplo, "Básico", "Premium").
	 */
	private String role;
	
	/**
	 * Correo electrónico del usuario asociado a la suscripción.
	 * Representa el identificador único del usuario que tiene esta suscripción.
	 */
	private String email;
	
	/**
	 * Fecha de inicio de la suscripción.
	 * Representa la fecha en la que la suscripción del usuario comienza.
	 */
	private Date fechaInicio;

	/**
	 * Fecha de finalización de la suscripción.
	 * Representa la fecha en la que la suscripción del usuario finaliza o expira.
	 */
	private Date fechaFin;
	
	/**
	 * Objeto `UsuarioDto` que representa al usuario asociado con esta suscripción.
	 * Proporciona información detallada sobre el usuario que ha adquirido la suscripción.
	 */
	private UsuarioDto usuario;
	
	/**
	 * Objeto `SuscripcionDto` que representa la suscripción adquirida por el usuario.
	 * Contiene detalles como el rol, el precio mensual y otros datos relacionados con la suscripción.
	 */
	private SuscripcionDto suscripcion;
	
	/**
	 * Precio total de la suscripción para el usuario.
	 * Representa el costo total que el usuario ha pagado por la suscripción durante el período seleccionado.
	 */
	private Double totalPrecio;
}

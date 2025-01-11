package es.iesjandula.damfilms.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) que representa a un usuario.
 * 
 * Esta clase es utilizada para transferir la información de un usuario en el sistema,
 * incluyendo detalles como el correo electrónico, el nombre de usuario, la contraseña 
 * y el nombre de la suscripción asociada al usuario.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
	
	/**
	 * Correo electrónico del usuario.
	 * Representa el identificador único del usuario en el sistema.
	 */
	private String email;
	
	/**
	 * Nombre de usuario.
	 * Representa el nombre de usuario elegido por el usuario para iniciar sesión o identificarse.
	 */
	private String nombreUsuario;
	
	/**
	 * Contraseña del usuario.
	 * Representa la contraseña del usuario asociada a su cuenta para la autenticación.
	 */
	private String password;
	
	/**
	 * Nombre de la suscripción del usuario.
	 * Representa el nombre del plan o suscripción adquirida por el usuario, como "Básico", "Premium", etc.
	 */
	private String nombreSuscripcion;
}

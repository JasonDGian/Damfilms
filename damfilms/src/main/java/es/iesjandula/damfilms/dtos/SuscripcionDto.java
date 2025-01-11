package es.iesjandula.damfilms.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) que representa una suscripción.
 * 
 * Esta clase es utilizada para transferir la información de una suscripción entre capas de la aplicación,
 * incluyendo detalles como el rol, el nombre y el precio mensual de la suscripción, 
 * así como los usuarios que están asociados a ella.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuscripcionDto {
	
	/**
	 * Rol de la suscripción.
	 * Representa el tipo o nivel de la suscripción, como "Básico", "Premium", etc.
	 */
	private String role;
	
	/**
	 * Nombre de la suscripción.
	 * Representa el nombre o descripción de la suscripción.
	 */
	private String nombre;
	
	/**
	 * Precio mensual de la suscripción.
	 * Representa el costo de la suscripción por mes.
	 */
	private Double precioMensual;
	
	/**
	 * Lista de usuarios asociados a la suscripción.
	 * Representa los usuarios que han adquirido esta suscripción.
	 */
	private List<UsuarioDto> Usuarios;
}

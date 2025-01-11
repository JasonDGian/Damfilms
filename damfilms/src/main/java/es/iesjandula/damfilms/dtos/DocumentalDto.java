package es.iesjandula.damfilms.dtos;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) que representa un documental.
 * 
 * Esta clase es utilizada para transferir la información de un documental entre capas de la aplicación,
 * incluyendo detalles como su título, fecha de lanzamiento, duración, sinopsis, y el género al que pertenece.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentalDto {
	
	/**
	 * Título del documental.
	 * Representa el nombre del documental.
	 */
	private String titulo;
	
	/**
	 * Fecha de lanzamiento del documental.
	 * Esta fecha indica el momento en que el documental fue lanzado o estrenado.
	 */
	private Date fechaLanzamiento;
	
	/**
	 * Duración del documental en formato de texto.
	 * Representa el tiempo total del documental, por ejemplo, "90 minutos".
	 */
	private String duracion;
	
	/**
	 * URL del póster del documental.
	 * Este campo almacena la dirección de la imagen de la portada del documental.
	 */
	private String poster;
	
	/**
	 * Índice de popularidad del documental.
	 * Un valor entero que representa la popularidad del documental basado en ciertos factores, como visualizaciones.
	 */
	private int popindex;
	
	/**
	 * Fecha de llegada del documental.
	 * Esta fecha representa cuándo el documental estuvo disponible para los usuarios.
	 */
	private Date fechaLlegada;
	
	/**
	 * Sinopsis del documental.
	 * Una breve descripción del contenido y tema del documental.
	 */
	private String sinopsis;
	
	/**
	 * Género del documental.
	 * Relaciona el documental con su género, como drama, historia, ciencia, etc.
	 */
	private GeneroDto genero;
	
	/**
	 * Lista de usuarios asociados al documental.
	 * Representa los usuarios que han visto o tienen algún tipo de relación con este documental.
	 */
	private List<UsuarioDto> usuarios;
}

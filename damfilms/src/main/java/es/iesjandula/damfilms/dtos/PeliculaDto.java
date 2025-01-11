package es.iesjandula.damfilms.dtos;

import java.util.Date;
import java.util.List;

import es.iesjandula.damfilms.models.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) que representa una película.
 * 
 * Esta clase es utilizada para transferir la información de una película entre capas de la aplicación,
 * incluyendo detalles como su título, fecha de lanzamiento, duración, sinopsis, tipo y géneros asociados.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeliculaDto {
	
	/**
	 * Título de la película.
	 * Representa el nombre de la película.
	 */
	private String titulo;
	
	/**
	 * Fecha de lanzamiento de la película.
	 * Esta fecha indica cuándo la película fue lanzada o estrenada.
	 */
	private Date fechaLanzamiento;
		
	/**
	 * Duración de la película.
	 * Representa el tiempo total de la película en formato de texto, por ejemplo, "120 minutos".
	 */
	private String duracion;
	
	/**
	 * URL del póster de la película.
	 * Este campo almacena la dirección de la imagen de la portada de la película.
	 */
	private String poster;

	/**
	 * Índice de popularidad de la película.
	 * Un valor entero que representa la popularidad de la película basado en ciertos factores, como visualizaciones.
	 */
	private int popindex;

	/**
	 * Fecha de llegada de la película.
	 * Esta fecha representa cuándo la película estuvo disponible para los usuarios en la plataforma.
	 */
	private Date fechaLlegada;
	
	/**
	 * Sinopsis de la película.
	 * Una breve descripción del contenido y la trama de la película.
	 */
	private String sinopsis;
	
	/**
	 * Tipo de la película.
	 * Representa el tipo de contenido al que pertenece la película (por ejemplo, "Comedia", "Acción").
	 */
	private Tipo tipo;
	
	/**
	 * Lista de géneros de la película.
	 * Representa los géneros a los que pertenece la película, como "Drama", "Ciencia ficción", etc.
	 */
	private List<GeneroDto> generos;
	
	/**
	 * Lista de usuarios asociados a la película.
	 * Representa los usuarios que han visto o tienen algún tipo de relación con esta película.
	 */
	private List<UsuarioDto> usuarios;

}

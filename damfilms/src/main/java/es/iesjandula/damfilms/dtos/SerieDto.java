package es.iesjandula.damfilms.dtos;

import java.util.Date;
import java.util.List;

import es.iesjandula.damfilms.models.Serie;
import es.iesjandula.damfilms.models.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) que representa una serie.
 * 
 * Esta clase es utilizada para transferir la información de una serie entre capas de la aplicación,
 * incluyendo detalles como su título, duración, sinopsis, tipo y géneros asociados.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SerieDto {
		
	/**
	 * Título de la serie.
	 * Representa el nombre de la serie.
	 */
	private String titulo;
	
	/**
	 * Duración de la serie.
	 * Representa el tiempo total de la serie en formato de texto, por ejemplo, "45 minutos por episodio".
	 */
	private String duracion;
	
	/**
	 * URL del póster de la serie.
	 * Este campo almacena la dirección de la imagen de la portada de la serie.
	 */
	private String poster;
	
	/**
	 * Índice de popularidad de la serie.
	 * Un valor entero que representa la popularidad de la serie basado en ciertos factores, como visualizaciones.
	 */
	private int popindex;
	
	/**
	 * Fecha de llegada de la serie.
	 * Esta fecha representa cuándo la serie estuvo disponible para los usuarios en la plataforma.
	 */
	private Date fechaLlegada;
	
	/**
	 * Sinopsis de la serie.
	 * Una breve descripción del contenido y la trama de la serie.
	 */
	private String sinopsis;
	
	/**
	 * Lista de temporadas de la serie.
	 * Representa las temporadas que componen la serie, con cada temporada incluida en un objeto `TemporadaDto`.
	 */
	private List<TemporadaDto> temporadas;
	
	/**
	 * Tipo de la serie.
	 * Representa el tipo de contenido al que pertenece la serie (por ejemplo, "Comedia", "Drama", "Acción").
	 */
	private Tipo tipo;

	/**
	 * Lista de géneros de la serie.
	 * Representa los géneros a los que pertenece la serie, como "Drama", "Ciencia ficción", etc.
	 */
	private List<GeneroDto> generos;
	
	/**
	 * Lista de usuarios asociados a la serie.
	 * Representa los usuarios que han visto o tienen algún tipo de relación con esta serie.
	 */
	private List<UsuarioDto> usuarios;
	
	/**
	 * Constructor que inicializa un `SerieDto` a partir de una entidad `Serie`.
	 * Este constructor permite crear un DTO de serie a partir de una instancia de la entidad `Serie` en la base de datos.
	 *
	 * @param serie la instancia de la entidad `Serie` que se utiliza para poblar los atributos del DTO.
	 */
	public SerieDto(Serie serie){
		this.setTitulo(serie.getTitulo());
		this.setDuracion(serie.getDuracion());
		this.setPoster(serie.getPoster());
		this.setPopindex(serie.getPopindex());
		this.setFechaLlegada(serie.getFechaLlegada());
		this.setSinopsis(serie.getSinopsis());
		// falta por poner cosas
	}
}

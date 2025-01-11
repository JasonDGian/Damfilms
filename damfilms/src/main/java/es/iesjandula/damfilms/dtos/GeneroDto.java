package es.iesjandula.damfilms.dtos;

import java.util.List;

import es.iesjandula.damfilms.models.Documental;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) que representa un género de contenido.
 * 
 * Esta clase es utilizada para transferir información sobre un género,
 * incluyendo el nombre del género y las listas de documentales, películas y series
 * que pertenecen a ese género.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneroDto {
	
	/**
	 * Nombre del género.
	 * Representa el nombre o tipo de género, como "Acción", "Drama", "Comedia", etc.
	 */
	private String nombre;
	
	/**
	 * Lista de documentales que pertenecen a este género.
	 * Representa los documentales que están clasificados bajo este género.
	 */
	private List<Documental> documentales;
	
	/**
	 * Lista de películas que pertenecen a este género.
	 * Representa las películas que están clasificadas dentro de este género.
	 */
	private List<PeliculaDto> peliculas;
	
	/**
	 * Lista de series que pertenecen a este género.
	 * Representa las series que están clasificadas bajo este género.
	 */
	private List<SerieDto> series;
}

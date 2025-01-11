package es.iesjandula.damfilms.dtos;

import java.util.List;

import es.iesjandula.damfilms.models.Pelicula;
import es.iesjandula.damfilms.models.Serie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) que representa un tipo de contenido.
 * 
 * Esta clase es utilizada para transferir la información relacionada con un tipo de contenido,
 * que puede ser asociado tanto a películas como a series. Incluye detalles como el nombre del tipo
 * y las listas de películas y series que pertenecen a ese tipo.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoDto {
	
	/**
	 * Nombre del tipo.
	 * Representa el nombre del tipo de contenido.
	 */
	private String nombre;
	
	/**
	 * Lista de películas asociadas al tipo.
	 * Representa las películas que pertenecen a este tipo de contenido.
	 */
	private List<Pelicula> peliculas;
	
	/**
	 * Lista de series asociadas al tipo.
	 * Representa las series que pertenecen a este tipo de contenido.
	 */
	private List<Serie> series;
}

package es.iesjandula.damfilms.dtos;

import java.sql.Date;

import es.iesjandula.damfilms.models.Serie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) que representa una temporada de una serie.
 * 
 * Esta clase es utilizada para transferir la información de una temporada de una serie entre capas de la aplicación,
 * incluyendo detalles como el número de temporada, la serie asociada, la fecha de lanzamiento, 
 * el nombre de la temporada y el número de capítulos que la componen.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemporadaDto {
	
	/**
	 * Número de la temporada.
	 * Representa el orden de la temporada dentro de la serie (por ejemplo, temporada 1, temporada 2, etc.).
	 */
	private int numeroTemporada;
	
	/**
	 * Identificador único de la temporada.
	 * Representa el identificador único de la temporada en la base de datos.
	 */
	private Long id;
	
	/**
	 * Objeto `Serie` asociado a esta temporada.
	 * Representa la serie a la que pertenece esta temporada, proporcionando acceso a sus detalles.
	 */
	private Serie serie;
	
	/**
	 * Nombre de la temporada.
	 * Representa el título o nombre asignado a la temporada (por ejemplo, "Temporada 1: El regreso").
	 */
	private String nombre;
	
	/**
	 * Fecha de lanzamiento de la temporada.
	 * Representa la fecha en la que la temporada fue lanzada o estrenada.
	 */
	private Date fechaLanzamiento;
	
	/**
	 * Número de capítulos en la temporada.
	 * Representa la cantidad de episodios que componen esta temporada.
	 */
	private int numeroCapitulos;
}

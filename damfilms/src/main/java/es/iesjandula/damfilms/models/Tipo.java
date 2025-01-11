package es.iesjandula.damfilms.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa un tipo de contenido en el sistema.
 * 
 * Esta clase permite clasificar las películas y series en base a su tipo,
 *
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Tipo {
	
	/**
	 * Nombre del tipo, que sirve como identificador único.
	 * Este campo es la clave primaria de la entidad.
	 */
	@Id
	@Column
	private String nombre;
	
	/**
	 * Lista de películas asociadas a este tipo.
	 * La relación se establece mediante el campo "tipo" en la entidad Pelicula.
	 */
	@OneToMany(mappedBy = "tipo")
	private List<Pelicula> peliculas;
	
	/**
	 * Lista de series asociadas a este tipo.
	 * La relación se establece mediante el campo "tipo" en la entidad Serie.
	 */
	@OneToMany(mappedBy = "tipo")
	private List<Serie> series;

}

package es.iesjandula.damfilms.models;

import es.iesjandula.damfilms.models.ids.UsuarioPeliculaId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa la relación entre un usuario y una película que ha visto.
 * 
 * Esta clase gestiona las películas que un usuario ha visualizado,
 * incluyendo el minuto exacto en el que el usuario ha dejado de ver la película.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPelicula {
	
	/**
	 * Identificador compuesto que representa la relación entre un usuario y una película.
	 * Este campo incluye el email del usuario y el identificador de la película.
	 */
	@EmbeddedId
	private UsuarioPeliculaId usuarioPeliculaId;
	
	/**
	 * Usuario asociado a esta relación de visualización de película.
	 * Este campo utiliza el email del usuario para hacer la relación.
	 */
	@ManyToOne
	@MapsId("email")
	@JoinColumn(referencedColumnName = "email")
	private Usuario usuario;
	
	/**
	 * Película asociada a esta relación de visualización por parte del usuario.
	 * Este campo utiliza el identificador de la película para hacer la relación.
	 */
	@ManyToOne
	@MapsId("peliculaId")
	private Pelicula pelicula;
	
	/**
	 * Minuto en el que el usuario se encuentra en la película.
	 * Este campo guarda el progreso de visualización de la película.
	 */
	@Column
	private int minutoEnProgeso;

}

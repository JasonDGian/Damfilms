package es.iesjandula.damfilms.models;

import es.iesjandula.damfilms.models.ids.UsuarioSerieId;
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
 * Representa la relación entre un usuario y una serie que ha visto.
 * 
 * Esta clase gestiona las series que un usuario ha visualizado,
 * incluyendo el capítulo exacto en el que el usuario ha dejado de ver la serie.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioSerie {
	
	/**
	 * Identificador compuesto que representa la relación entre un usuario y una serie.
	 * Este campo incluye el email del usuario y el identificador de la serie.
	 */
	@EmbeddedId
	private UsuarioSerieId usuarioSerieId;
	
	/**
	 * Usuario asociado a esta relación de visualización de serie.
	 * Este campo utiliza el email del usuario para hacer la relación.
	 */
	@ManyToOne
	@MapsId("email")
	@JoinColumn(referencedColumnName = "email")
	private Usuario usuario;
	
	/**
	 * Serie asociada a esta relación de visualización por parte del usuario.
	 * Este campo utiliza el identificador de la serie para hacer la relación.
	 */
	@ManyToOne
	@MapsId("id")
	@JoinColumn(referencedColumnName = "id")
	private Serie serie;
	
	/**
	 * Capítulo en el que el usuario se encuentra en la serie.
	 * Este campo guarda el progreso de visualización de la serie.
	 */
	@Column
	private int capituloEnProgeso;

}

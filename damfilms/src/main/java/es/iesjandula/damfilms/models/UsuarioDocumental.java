package es.iesjandula.damfilms.models;

import es.iesjandula.damfilms.models.ids.UsuarioDocumentalId;
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
 * Representa la relación entre un usuario y un documental que ha visto.
 * 
 * Esta clase gestiona los documentales que un usuario ha visualizado,
 * incluyendo el minuto exacto en el que el usuario ha dejado de ver el documental.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDocumental {
	
	/**
	 * Identificador compuesto que representa la relación entre un usuario y un documental.
	 * Este campo incluye el email del usuario y el identificador del documental.
	 */
	@EmbeddedId
	private UsuarioDocumentalId usuarioDocumentalId;
	
	/**
	 * Usuario asociado a esta relación de visualización de documental.
	 * Este campo utiliza el email del usuario para hacer la relación.
	 */
	@ManyToOne
	@MapsId("email")
	@JoinColumn(referencedColumnName = "email")
	private Usuario usuario;
	
	/**
	 * Documental asociado a esta relación de visualización por parte del usuario.
	 * Este campo utiliza el identificador del documental para hacer la relación.
	 */
	@ManyToOne
	@MapsId("documentalId")
	private Documental documental;
	
	/**
	 * Minuto en el que el usuario se encuentra en el documental.
	 * Este campo guarda el progreso de visualización del documental.
	 */
	@Column
	private int minutoEnProgeso;

}

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

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDocumental {
	
	@EmbeddedId
	private UsuarioDocumentalId usuarioDocumentalId;
	
	@ManyToOne
	@MapsId("email")
	@JoinColumn(referencedColumnName = "email")
	private Usuario usuario;
	
	@ManyToOne
	@MapsId("documentalId")
	private Documental documental;
	
	@Column
	private int minutoEnProgeso;

}

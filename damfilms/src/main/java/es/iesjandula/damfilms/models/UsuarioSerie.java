package es.iesjandula.damfilms.models;

import es.iesjandula.damfilms.models.Ids.UsuarioSerieId;
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
public class UsuarioSerie {
	
	@EmbeddedId
	private UsuarioSerieId usuarioSerieId;
	
	@ManyToOne
	@MapsId("email")
	@JoinColumn(referencedColumnName = "email")
	private Usuario usuario;
	
	@ManyToOne
	@MapsId("id")
	@JoinColumn(referencedColumnName = "id")
	private Serie serie;
	
	@Column
	private int capituloEnProgeso;

}

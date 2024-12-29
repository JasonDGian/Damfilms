package es.iesjandula.damfilms.models;

import es.iesjandula.damfilms.models.ids.GeneroSerieId;
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
public class GeneroSerie {
	
	@EmbeddedId
	private GeneroSerieId generoSerieId;
	
	@ManyToOne
	@MapsId("nombre")
	@JoinColumn(referencedColumnName = "nombre")
	private Genero genero;
	
	@ManyToOne
	@MapsId("id")
	@JoinColumn(referencedColumnName = "id")
	private Serie serie;

}

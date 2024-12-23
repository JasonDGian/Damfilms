package es.iesjandula.damfilms.models;

import es.iesjandula.damfilms.models.Ids.GeneroPeliculaId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class GeneroPelicula {
	
	@EmbeddedId
	private GeneroPeliculaId generoPeliculaId;
	
	@ManyToOne
	@MapsId("nombre")
	@JoinColumn(referencedColumnName = "nombre")
	private Genero genero;
	
	@ManyToOne
	@MapsId("peliculaId")
	private Pelicula pelicula;

}

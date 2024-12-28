package es.iesjandula.damfilms.models;

import java.util.Date;
import java.util.List;

import es.iesjandula.damfilms.models.Ids.PeliculaId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pelicula {
	
	@EmbeddedId
	private PeliculaId peliculaId;
	
	@Column(nullable = false)
	private String duracion;
	
	@Column
	private String poster;
	
	@Column(unique = true)
	private int popindex;
	
	@Column(nullable = false)
	private Date fechaLlegada;
	
	@Column
	private String sinopsis;
	
	@ManyToOne
	private Tipo tipo;
	
	@OneToMany(mappedBy = "pelicula")
	private List<GeneroPelicula> generos;
	
	@OneToMany(mappedBy = "pelicula")
	private List<UsuarioPelicula> usuarios;
	

}

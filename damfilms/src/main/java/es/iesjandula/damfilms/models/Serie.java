package es.iesjandula.damfilms.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Serie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column(nullable = false)
	private String titulo;
	
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
	
	@OneToMany(mappedBy = "serie")
	private List<Temporada> temporadas;
	
	@OneToMany(mappedBy = "serie")
	private List<GeneroSerie> generos;
	
	@OneToMany(mappedBy = "serie")
	private List<UsuarioSerie> usuarios;
	

}

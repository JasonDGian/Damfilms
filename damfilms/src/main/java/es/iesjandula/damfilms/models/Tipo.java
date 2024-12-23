package es.iesjandula.damfilms.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Tipo {
	
	@Id
	@Column
	private String nombre;
	
	@OneToMany(mappedBy = "tipo")
	private List<Pelicula> peliculas;
	
	@OneToMany(mappedBy = "tipo")
	private List<Serie> series;

}

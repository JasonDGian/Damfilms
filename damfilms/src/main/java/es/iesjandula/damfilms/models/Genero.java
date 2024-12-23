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
public class Genero {
	
	@Id
	@Column
	private String nombre;
	
	@OneToMany(mappedBy = "genero")
	private List<Documental> documentales;
	
}

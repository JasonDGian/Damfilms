package es.iesjandula.damfilms.models;

import java.util.Date;

import es.iesjandula.damfilms.models.ids.TemporadaId;
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
public class Temporada {
	
	@EmbeddedId
	private TemporadaId temporadaId;
	
	@ManyToOne
	@MapsId("id")
	private Serie serie;
	
	@Column
	private String nombre;
	
	@Column(nullable = false)
	private Date fechaLanzamiento;
	
	@Column(nullable = false)
	private int numeroCapitulos;

}

package es.iesjandula.damfilms.models;

import java.sql.Date;
import java.util.List;

import es.iesjandula.damfilms.models.Ids.DocumentalId;
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
public class Documental {
	
	@EmbeddedId
	private DocumentalId documentalId;
	
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
	private Genero genero;
	
	@OneToMany(mappedBy = "documental")
	private List<UsuarioDocumental> usuarios;
}

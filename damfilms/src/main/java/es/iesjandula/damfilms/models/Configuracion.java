package es.iesjandula.damfilms.models;

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
public class Configuracion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	private String fotoPerfil;
	
	@Column
	private Boolean tema;
	
	@Column
	private Boolean accesibilidad;
	
	@ManyToOne
	private Modo modo;
	
	@OneToMany(mappedBy = "configuracion")
	private List<Usuario> usuarios;

}

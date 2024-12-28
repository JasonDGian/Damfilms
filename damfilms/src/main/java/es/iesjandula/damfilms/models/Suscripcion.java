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
public class Suscripcion {
	
	@Id
	@Column
	private String role;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private Double precioMensual;
	
	@OneToMany(mappedBy = "suscripcion")
	private List<SuscripcionUsuario> suscripcionUsuarios;

}

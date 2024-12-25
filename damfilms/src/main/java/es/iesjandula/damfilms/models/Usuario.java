package es.iesjandula.damfilms.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@Column
	private String email;
	
	@Column(nullable = false, unique = true)
	private String nombreUsuario;
	
	@Column(nullable = false)
	private String password;
	
	@ManyToOne
	private Suscripcion suscripcion;
	
	@ManyToOne
	private Configuracion configuracion;
	
	@ManyToOne
	private Direccion direccion;

}

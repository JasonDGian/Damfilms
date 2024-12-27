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
	
	@Column
	private Boolean usuarioActivo;
	
	@ManyToOne
	private Suscripcion suscripcion;
		
	@Column
	private String fotoPerfil;
	
	@Column
	private Boolean temaOscuro;
	
	@Column
	private Boolean modoNoOyentes;
	
	@Column
	private Boolean contenidoAdultos;
	
	@ManyToOne
	private Role role;
	

}

package es.iesjandula.damfilms.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
			
	@Column
	private String fotoPerfil;
	
	@Column
	private Boolean temaOscuro;
	
	@Column
	private Boolean modoNoOyentes;
	
	@Column
	private Boolean contenidoAdultos;
	
	@OneToMany(mappedBy = "usuario")
	private List<SuscripcionUsuario> suscripcionUsuarios;
	
	@OneToMany(mappedBy = "usuario")
	private List<UsuarioDocumental> documentales;

	@OneToMany(mappedBy = "usuario")
	private List<UsuarioSerie> series;

	@OneToMany(mappedBy = "usuario")
	private List<UsuarioPelicula> peliculas;


}

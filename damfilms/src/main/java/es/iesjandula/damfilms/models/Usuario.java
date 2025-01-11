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

/**
 * Representa un usuario en el sistema.
 * 
 * Esta clase contiene la información personal y de configuración de cada usuario,
 * como su email, nombre de usuario, contraseña, y preferencias de visualización.
 * También establece las relaciones con las suscripciones y el contenido que el usuario ha visto.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class Usuario {
	
	/**
	 * Correo electrónico del usuario, que actúa como identificador único.
	 * Este campo es la clave primaria de la entidad.
	 */
	@Id
	@Column
	private String email;
	
	/**
	 * Nombre de usuario que se muestra en el sistema.
	 * Este campo es único y no puede ser nulo.
	 */
	@Column(nullable = false, unique = true)
	private String nombreUsuario;
	
	/**
	 * Contraseña del usuario para la autenticación.
	 * Este campo no puede ser nulo.
	 */
	@Column(nullable = false)
	private String password;
	
	/**
	 * Indica si el usuario está activo en el sistema.
	 * Un valor booleano que puede ser verdadero o falso.
	 */
	@Column
	private Boolean usuarioActivo;
			
	/**
	 * URL de la foto de perfil del usuario.
	 * Este campo almacena la dirección de la imagen del perfil.
	 */
	@Column
	private String fotoPerfil;
	
	/**
	 * Indica si el usuario ha activado el tema oscuro en su interfaz.
	 * Un valor booleano que puede ser verdadero o falso.
	 */
	@Column
	private Boolean temaOscuro;
	
	/**
	 * Indica si el usuario está en modo "No oyentes" (sin sonido).
	 * Un valor booleano que puede ser verdadero o falso.
	 */
	@Column
	private Boolean modoNoOyentes;
	
	/**
	 * Indica si el usuario ha habilitado la visualización de contenido para adultos.
	 * Un valor booleano que puede ser verdadero o falso.
	 */
	@Column
	private Boolean contenidoAdultos;
	
	/**
	 * Lista de suscripciones del usuario.
	 * Cada suscripción está asociada a un tipo específico de suscripción.
	 */
	@OneToMany(mappedBy = "usuario")
	private List<SuscripcionUsuario> suscripcionUsuarios;
	
	/**
	 * Lista de documentales que el usuario ha visto.
	 * Cada documental está asociado a un usuario en particular.
	 */
	@OneToMany(mappedBy = "usuario")
	private List<UsuarioDocumental> documentales;

	/**
	 * Lista de series que el usuario ha visto.
	 * Cada serie está asociada a un usuario en particular.
	 */
	@OneToMany(mappedBy = "usuario")
	private List<UsuarioSerie> series;

	/**
	 * Lista de películas que el usuario ha visto.
	 * Cada película está asociada a un usuario en particular.
	 */
	@OneToMany(mappedBy = "usuario")
	private List<UsuarioPelicula> peliculas;
}

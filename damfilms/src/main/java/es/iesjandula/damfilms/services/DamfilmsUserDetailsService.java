package es.iesjandula.damfilms.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import es.iesjandula.damfilms.dtos.UsuarioDto;
import es.iesjandula.damfilms.models.Role;
import es.iesjandula.damfilms.models.Suscripcion;
import es.iesjandula.damfilms.models.Usuario;
import es.iesjandula.damfilms.repositories.IRoleRepository;
import es.iesjandula.damfilms.repositories.ISuscripcionRepository;
import es.iesjandula.damfilms.repositories.IUsuarioRepository;
import es.iesjandula.damfilms.utils.Constants;
import es.iesjandula.damfilms.utils.DamfilmsServerError;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

/**
 * interfaz de spring security que se implementa para que podamos
 * consultar qué usuarios tienen autoridad o no para acceder a recursos y ver si existen o no
 *
 */
@Service
@Slf4j
public class DamfilmsUserDetailsService implements UserDetailsService
{
	@Autowired
	private IUsuarioRepository iUsuarioRepository ;
	
	@Autowired
	private ISuscripcionRepository iSuscripcionRepository;
	
	@Autowired
	private IRoleRepository iRoleRepository ;
	

	// Metodo que comprueba si un usuario existe.
    public boolean existsByUsername(String email)
    {
    	Optional<Usuario> userOpt = this.iUsuarioRepository.findById( email );
    	return userOpt.isPresent();
    }

    /**
     * Este método sirve para almacenar un nuevo usuario en BBDD asignandole
     * la suscripcion elegida y el rol pertinente.
     */
    public void saveUser(UsuarioDto usuarioDto, String encodedPassword) throws DamfilmsServerError
    {
    	
    	//String idSuscripcion = usuarioDto.getSuscripcion().toString();
    	
//    	// Busca la suscripción que el usuario ha elegido.
//    	Optional<Suscripcion> suscripcionOpt = this.iSuscripcionRepository.findById(idSuscripcion);
//    	
//    	// Si no encuentra una suscripcion lanza error.
//    	if ( suscripcionOpt.isEmpty() ){
//    		log.error("ERROR EN OPERACION DE REGISTRO USUARIO: Suscripcion en registro vacia.");
//    		throw new DamfilmsServerError(491, "La suscripcion introducida no existee.");
//    	}
//    	Suscripcion suscripcionUsuario = suscripcionOpt.get();
    	
    	// Creamos y asignamos valores al nuevo usuario.
    	Usuario usuario = new Usuario();
    	usuario.setEmail(usuarioDto.getEmail());
    	usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
    	usuario.setPassword(encodedPassword);
    	//usuario.setSuscripcion(suscripcionUsuario);
    	// Elementos de configuración de perfil de usuario por defecto.
    	usuario.setFotoPerfil(Constants.DEFAULT_USER_ICON);  
    	usuario.setTemaOscuro(true);
    	usuario.setModoNoOyentes(false);
    	usuario.setContenidoAdultos(false);
    	
    	// Bloque que asigna el rol pertinente a la suscripcion.    	
    	// linea provisional que asigna el rol estandar.
    	//usuario.setSuscripcion("");
    	usuario.setRole( this.iRoleRepository.findById(Constants.ROLE_STANDARD_USER).get());  // ------------------------------- INSTRUCCION PARA TESTS
    	
    	log.debug("Almacenando usuario");
    	this.iUsuarioRepository.saveAndFlush(usuario);
    	log.debug("Usuario almacenado.");
    }
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
	{
		// Recupera un usuario por su correo.
		Optional<Usuario> usuarioOpt = this.iUsuarioRepository.findById(email);
		
		// Si no encuentra el usuario buscado lanza error y loguea.
		if ( usuarioOpt.isEmpty() ){
			String mensaje = "No se han encontrado usuarios con el correo " + email;
			log.error(mensaje);
			throw new UsernameNotFoundException(mensaje) ;
		}
				
		// 'Abre' el objeto usuario.
		Usuario usuario = usuarioOpt.get();
		
		// Recuperas el role del usuario.
		Role roleDelUsuario = usuario.getRole();
		
		List<Role> userRoles = new ArrayList<>();
		
		userRoles.add(roleDelUsuario);

		// Llamamos a este método para que en base a los roles (entendidos por nuestra aplicación),
		// los convierta en GrantedAuthority, que es lo que entiende Spring Security en cuanto a roles
		List<GrantedAuthority> authorities = this.getUserAuthority(userRoles) ;

		// Con el usuario y sus lista de authorities, obtenemos los detalles del usuario
		// Es una especie de usuario, pero entendida por Spring Security
		return this.getUserDetails(usuario, authorities) ;
	}

	/**
	 * Convierte nuestra lista de roles en una lista de GrantedAutority 
	 * que es el mismo concepto pero entendido por Spring Security 
	 * 
	 * @param  userRoles lista de roles del usuario
	 * @return lista de GrantedAuthority
	 */
	private List<GrantedAuthority> getUserAuthority(List<Role> userRoles)
	{
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>() ;

		for (Role userRole : userRoles)
		{
			roles.add(new SimpleGrantedAuthority(userRole.getRole())) ;
		}
		
		return roles ;
	}

	/**
	 * Con el usuario y sus lista de authorities, obtenemos los detalles del usuario
	 * Es una especie de usuario, pero entendida por Spring Security
	 * 
	 * @param user usuario de nuestro modelo de datos
	 * @param authorities lista de GrantedAuthority
	 * @return una instancia de UserDetails
	 */
	private UserDetails getUserDetails(Usuario user, List<GrantedAuthority> authorities)
	{
		boolean accountNonExpired 	  = true ;
		boolean credentialsNonExpired = true ;
		boolean accountNonLocked	  = true ;
		
		// Aqui se crea un objeto USER de spring a parti de un objeto usuario nuestro.
		return new org.springframework.security.core.userdetails.User(user.getEmail(),
																	  user.getPassword(),
																	  user.getUsuarioActivo(),
																	  accountNonExpired, 
																	  credentialsNonExpired,
																	  accountNonLocked, 
																	  authorities) ;

	}
}

package es.iesjandula.damfilms.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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
import es.iesjandula.damfilms.models.Suscripcion;
import es.iesjandula.damfilms.models.SuscripcionUsuario;
import es.iesjandula.damfilms.models.Usuario;
import es.iesjandula.damfilms.models.ids.SuscripcionUsuarioId;
import es.iesjandula.damfilms.repositories.ISuscripcionRepository;
import es.iesjandula.damfilms.repositories.ISuscripcionUsuarioRepository;
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
	private ISuscripcionUsuarioRepository iSuscripcionUsuarioRepository;
	
	
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
    	
    	// Este metodo debe de almacenar un usuario en BBDD junto con la relacion que obtiene entre suscripcion y usuario.
    	// Vamos recuperando los valores para el usuario.
    	// Primero se recupera la suscripcion que ha elegido.
    	// Luego se genera el usuario.
    	// Luego se genera la relacion.
    	// Luego se introduce el estado de activo.
    	// (En algun momento se debe de configurar las autoridades del usuario -> En loadUserData?)
    	
     	// Creamos y asignamos valores al nuevo usuario.
    	log.debug("{} - Generando nuevo usuario", Constants.DEBUG_TAG);
    	Usuario usuario = new Usuario();
    	usuario.setEmail(usuarioDto.getEmail());
    	usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
    	usuario.setPassword(encodedPassword);
    	usuario.setUsuarioActivo(true);
    	usuario.setFotoPerfil(Constants.DEFAULT_USER_ICON);  
    	usuario.setTemaOscuro(true);
    	usuario.setModoNoOyentes(false);
    	usuario.setContenidoAdultos(false);
    	log.debug("{} - Nuevo usuario generado.", Constants.DEBUG_TAG);
    	
    	log.debug("{} - Almacenando usuario en BBDD.", Constants.DEBUG_TAG);
    	this.iUsuarioRepository.saveAndFlush(usuario);
    	log.debug("{} - Usuario almacenado en BBDD.", Constants.DEBUG_TAG);
    	
    	log.debug("{} - Invocando metodo guradado relacion.", Constants.DEBUG_TAG);	
    	this.saveUserSuscriptionRelationship(usuario, usuarioDto.getNombreSuscripcion());
    	


    }
    
    public void saveUserSuscriptionRelationship( Usuario user, String nombreSuscripcion ) throws DamfilmsServerError{
    	
    	log.debug("{} - Generando nueva suscripcion de usuario.", Constants.DEBUG_TAG);
    	
    	// buscar la suscripcion a la que hace referencia
    	Optional<Suscripcion> suscripcionOpt = this.iSuscripcionRepository.findByNombre(nombreSuscripcion);
    	
    	if ( suscripcionOpt.isEmpty() ){
    		log.debug("{} - Suscripcion no encontrada.", Constants.DEBUG_TAG);
    		throw new DamfilmsServerError(595 , "suscripcion no encontrada.");
    	}
    	
    	Suscripcion suscripcion = suscripcionOpt.get();
    	log.debug("{} - Suscripcion encontrada.", Constants.DEBUG_TAG);
    	
    	// Fecha actual del servidor.
    	LocalDate fechaHoy = LocalDate.now();
    	log.debug("{} - Fecha de registro: {} ", Constants.DEBUG_TAG, fechaHoy.toString());
        // Sumar 1 mes a la fecha actual
        LocalDate fechaHoyMasUnMes = fechaHoy.plusMonths(1);  // aqui la idea seria ahcer un parametro que decide cuantos meses se le añaden.
        log.debug("{} - Fecha de final de suscripcion: {} ", Constants.DEBUG_TAG, fechaHoyMasUnMes.toString());
        // Convertir LocalDate a java.util.Date (sin la parte de la hora)
        Date fechaHoyBBDD = Date.from(fechaHoy.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        Date fechaHoyMasUnMesBBDD = Date.from(fechaHoyMasUnMes.atStartOfDay(ZoneId.systemDefault()).toInstant()); 
    	    	
    	// configurar el ID de la relacion
        log.debug("{} - Generando nuevo ID suscripcion.", Constants.DEBUG_TAG);
    	SuscripcionUsuarioId susid = new SuscripcionUsuarioId();
    	susid.setEmail(user.getEmail());
    	susid.setRole(suscripcion.getRole());
    	susid.setFechaInicio(fechaHoyBBDD);
    	susid.setFechaFin(fechaHoyMasUnMesBBDD);
    	log.debug("{} - Nuevo ID suscripcion generado.", Constants.DEBUG_TAG);
    	log.debug("{} - Generando nueva suscripcion.", Constants.DEBUG_TAG);
    	SuscripcionUsuario susrel = new SuscripcionUsuario();
    	susrel.setSuscripcionUsuarioId(susid);
    	susrel.setUsuario(user);
    	susrel.setSuscripcion(suscripcion);
    	// la idea es multiplicar el precio mensual por la cantidad de meses añadidos a la fecha inicial.
    	susrel.setTotalPrecio(suscripcion.getPrecioMensual());  
    	log.debug("{} - Nueva suscripcion generada.", Constants.DEBUG_TAG);

    	this.iSuscripcionUsuarioRepository.saveAndFlush(susrel);
    }

    //TODO: Javadoc
    private boolean userIsActive(Usuario usuario) {
    	
    	// Desde el usuario recueprar la fecha de fin de su ultima suscripcion.
        Optional<SuscripcionUsuario> suscripcionMasRecienteOpt = this.iSuscripcionUsuarioRepository.buscaSuscripcionUltimaFechaCierre( usuario.getEmail() );
        
        // Controla si el obejto recibido es nulo o no.
        if (suscripcionMasRecienteOpt.isEmpty()) {
            log.debug("{} - El usuario no tiene suscripciones ergo se considera inactivo.", Constants.DEBUG_TAG);
            return false;
        }
        
        // De no ser nulo "abre" el objeto opcional.
        SuscripcionUsuario suscripcionMasReciente = suscripcionMasRecienteOpt.get();
                
        // Recoger la fecha de vencimiento de la suscripción más reciente del usuario.
        LocalDate fechaVencimiento = suscripcionMasReciente.getSuscripcionUsuarioId().getFechaFin()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        // Obtener la fecha actual en España
        LocalDate fechaActualEspana = LocalDate.now(ZoneId.of("Europe/Madrid"));

        // Comparar si la fecha actual está antes de la fecha de vencimiento (o si coincide)
        // Al hacer que la coincidencia también devuelva TRUE haremos que el ultimo dia de suscripción sea inclusivo.
        return fechaActualEspana.isBefore(fechaVencimiento) || fechaActualEspana.isEqual(fechaVencimiento);
    }

    
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
	{
		// Recupera un usuario por su correo.
		Optional<Usuario> usuarioOpt = this.iUsuarioRepository.findById(email);
		
		// Si no encuentra el usuario buscado lanza error y loguea.
		if ( usuarioOpt.isEmpty() ){
			String mensaje = Constants.DEBUG_TAG + "No se han encontrado usuarios con el correo " + email;
			log.error( mensaje );
			throw new UsernameNotFoundException(mensaje) ;
		}
				
		// 'Abre' el objeto usuario.
		Usuario usuario = usuarioOpt.get();

		Optional<SuscripcionUsuario> susus = this.iSuscripcionUsuarioRepository.buscaSuscripcionUltimaFechaCierre(email);	
		
		if( susus.isEmpty() ){
			throw new UsernameNotFoundException("Usuario no encontrado");
		}// con el email, 
		
		String rolDeUsuario = susus.get().getSuscripcionUsuarioId().getRole();

		List<GrantedAuthority> authorities = new ArrayList<>();
		
		authorities.add(new SimpleGrantedAuthority(rolDeUsuario));

		// Con el usuario y sus lista de authorities, obtenemos los detalles del usuario
		// Es una especie de usuario, pero entendida por Spring Security
		return this.getUserDetails(usuario, authorities) ;
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
		// TODO: 
		// añadir llamada a metodo de control de usuario activo
		boolean accountNonExpired 	  = true ;
		boolean credentialsNonExpired = true ;
		boolean accountNonLocked	  = true ;
		
		// Aqui se crea un objeto USER de spring a parti de un objeto usuario nuestro.
		return new org.springframework.security.core.userdetails.User(user.getEmail(),
																	  user.getPassword(),
																	  this.userIsActive(user),
																	  accountNonExpired, 
																	  credentialsNonExpired,
																	  accountNonLocked, 
																	  authorities) ;

	}
}

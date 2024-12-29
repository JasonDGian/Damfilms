package es.iesjandula.damfilms.config;

// Importación de clases necesarias para configurar seguridad y personalización
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import es.iesjandula.damfilms.services.DamfilmsUserDetailsService;
import es.iesjandula.damfilms.utils.Constants;

// Anotación para indicar que esta clase contiene configuraciones
@Configuration
// Habilita la seguridad web de Spring Security
@EnableWebSecurity
public class SpringSecurityConfig
{
	// Inyección del servicio que gestiona los detalles de usuario
	@Autowired
	private DamfilmsUserDetailsService damfilmsUserDetailsService;


	
	/**
	 * Configura las opciones de autenticación y cierre de sesión para la aplicación.
	 * 
	 * <p>Este método personaliza la página de inicio de sesión, la redirección tras un login
	 * exitoso o fallido, y la página a la que se redirige el usuario después de cerrar sesión.</p>
	 * 
	 * @return el objeto {@code SecurityFilterChain} configurado con las opciones especificadas.
	 * 
	 * @author David J. Gianmoena
	 * @see <a href="https://github.com/tu-usuario">GitHub - David J. Gianmoena</a>
	 */
	@Bean
	public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception
	{

		// Configuración de las peticiones HTTP interceptadas por el filtro de seguridad
		http
				// Desactiva la protección contra ataques CSRF (Cross-Site Request Forgery).
				.csrf(csrf -> csrf.disable())
				// Configura la autorización para las peticiones HTTP definidas.
				.authorizeHttpRequests(httpAuthorization -> httpAuthorization

						// ---------------- BLOQUE DE ACCESO PÚBLICO ------------------

						// Configura el acceso público a recursos estáticos.
						.requestMatchers
						(
							"/config/**", 
							"/css/**", 
							"/img/**", 
							"/js/**", 
							"/posters/**", 
							"/res/**"
						)
						.permitAll()

						// Configura el acceso público a rutas que no requieren autenticación.
						.requestMatchers
						(
							"/", 
							"/index", 
							"/login", 
							"/forbidden", 
							"/eula", 
							"/signup",
							"/register",
							"/not-found"
						)
						.permitAll()

						// ---------------- BLOQUE DE ACCESO RESTRINGIDO ------------------

						// Configura el acceso basado en las 'Authorities' de los usuarios.
						// Spring Security gestionará estas authorities mediante el servicio de datos de
						// usuario.

						// Permite el acceso a /home y /config-main según las authorities especificadas.
						.requestMatchers("/home", "/config-main")
						.hasAnyAuthority
						(
							Constants.ROLE_GUEST_USER, 
							Constants.ROLE_BASIC_USER,
							Constants.ROLE_STANDARD_USER, 
							Constants.ROLE_PREMIUM_USER
						)

						// Permite el acceso a /catalog-documentaries para las authorities definidas.
						.requestMatchers("/catalog-documentaries")
						.hasAnyAuthority
						(
							Constants.ROLE_BASIC_USER, 
							Constants.ROLE_STANDARD_USER,
							Constants.ROLE_PREMIUM_USER
						)

						// Permite el acceso a /catalog-series para las authorities especificadas.
						.requestMatchers("/catalog-series")
						.hasAnyAuthority(Constants.ROLE_STANDARD_USER, Constants.ROLE_PREMIUM_USER)

						// Permite el acceso a /catalog-movies solo para usuarios con autoridad PREMIUM.
						.requestMatchers("/catalog-movies").hasAnyAuthority(Constants.ROLE_PREMIUM_USER)

						// Requiere autenticación para cualquier otra solicitud.
						.anyRequest().authenticated())

				// ---------------- BLOQUE DE CONFIGURACION DE FORMULARIO DE LOGIN ------------------
				// Configura una página de inicio de sesión personalizada.
				.formLogin(customLogin -> customLogin
						// Página de autenticación de usuario.
						.loginPage("/login")
						// Página a la que se redirige en caso de fallo en el inicio de sesión.
						.failureUrl("/index")
					    // Página a la que se redirige tras un inicio de sesión exitoso.
					    // El parámetro booleano indica si se fuerza la redirección a /home o no,
					    // incluso si el usuario intentaba acceder a otra página antes.
						.defaultSuccessUrl("/home", false))
				
				// -------------- BLOQUE DE CONFIGURACION DE FUNCION DE CIERRE DE SESION  -------------
				.logout(customLogout -> customLogout
						// Pagina a la que se redirigirá el usuario si cierra sesión.
						.logoutSuccessUrl("/index.html"));

		// Devuelve un objeto de configuración del filtro construido
		// a partir de las instrucciones anteriores.
		return http.build();
	}

	/**
	 * Configura el codificador de contraseñas utilizado en la aplicación.
	 * 
	 * <p>Este método define un {@code BCryptPasswordEncoder} como el mecanismo de cifrado
	 * para las contraseñas de los usuarios. BCrypt es un algoritmo de cifrado seguro 
	 * resistente a ataques de fuerza bruta.</p>
	 * 
	 * Este objeto se emplea a la hora de cifrar contraseñas para almacenarlas en BBDD
	 * o compararlas durante el proceso de login.
	 * 
	 * @return una instancia de {@code BCryptPasswordEncoder} para cifrar contraseñas.
	 * 
	 * @author David J. Gianmoena
	 * @see <a href="https://github.com/tu-usuario">GitHub - David J. Gianmoena</a>
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		 // Este objeto se emplea a la hora de cifrar contraseñas para almacenarlas en BBDD
		 // o compararlas durante el proceso de login.
		return new BCryptPasswordEncoder();
	}


	/**
	 * Configura un proveedor de autenticación basado en datos de usuario y codificación de contraseñas.
	 * 
	 * <p>Este método define un {@code DaoAuthenticationProvider}, que utiliza un servicio personalizado
	 * de detalles de usuario y un codificador de contraseñas para autenticar usuarios en la aplicación.</p>
	 * 
	 * <p>El proveedor se configura con los siguientes elementos:</p>
	 * <ul>
	 *   <li>Un servicio de detalles de usuario definido en {@code myUserDetailsService}, que proporciona 
	 *   la lógica para cargar información de los usuarios.</li>
	 *   <li>Un codificador de contraseñas obtenido mediante {@code passwordEncoder()}, que asegura que 
	 *   las contraseñas almacenadas y proporcionadas se comparen de forma segura.</li>
	 * </ul>
	 * 
	 * @return una instancia configurada de {@code DaoAuthenticationProvider}.
	 * 
	 * @see DamfilmsUserDetailService
	 * 
	 * @author David J. Gianmoena
	 * @see <a href="https://github.com/tu-usuario">GitHub - David J. Gianmoena</a>
	 */
	@Bean
	public DaoAuthenticationProvider authenticationProvider()
	{
		// Instancia un proveedor de autenticación basado en datos de usuario.
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

		// Configura el servicio de detalles de usuario que carga la información de los usuarios.
		authenticationProvider.setUserDetailsService(this.damfilmsUserDetailsService);

		// Configura el codificador de contraseñas para validar de manera segura las credenciales.
		authenticationProvider.setPasswordEncoder(this.passwordEncoder());

		// Retorna el proveedor de autenticación completamente configurado.
		return authenticationProvider;

	}

	/**
	 * Configura páginas de error personalizadas para el servidor web.
	 * 
	 * <p>Método que define un personalizador de servidor web que asigna rutas específicas
	 * a los códigos de error HTTP comunes. Muestra páginas personalizadas
	 * para errores como "404 No encontrado" y "403 Prohibido".</p>
	 * 
	 * @return un personalizador del servidor web con las páginas de error configuradas.
	 * 
	 * @author David J. Gianmoena
	 * @see <a href="https://github.com/tu-usuario">GitHub - David J. Gianmoena</a>
	 */
	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
	    return factory -> {
	        // Asigna la página personalizada para el error 404 (No encontrado).
	        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/not-found"));

	        // Asigna la página personalizada para el error 403 (Prohibido).
	        factory.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/forbidden"));
	    };
	}

}
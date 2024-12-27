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
    private DamfilmsUserDetailsService myUserDetailsService;

    /**
     * Configuración del comportamiento del filtro de seguridad de spring
     */
    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception
    {
    	
        // ---------- Bloque que configura las peticiones HTTP. ---------- 
        http
	        // Desactiva la protección contra ataques CSRF (Cross-Site Request Forgery).
	        .csrf(csrf -> csrf.disable())
	        // Configuración para las peticiones HTTP.
	        .authorizeHttpRequests
	        ( 
	        		// Objeto de personalización de acceso.
	        		httpAuthorization -> httpAuthorization
	        		
	        			// ---------------- BLOQUE DE ACCESO PUBLICO ------------------
	        			.requestMatchers("/config/**", "/css/**", "/img/**","/js/**","/posters/**","/res/**").permitAll()
	        			.requestMatchers("/", "/index", "/login", "/forbidden", "/eula", "/signup", "/not-found").permitAll()
	        			
	        			// ---------------- BLOQUE DE ACCESO GESTIONADO ------------------	      
	            		
	            		.requestMatchers("/home")
	            		.hasAnyAuthority(
	            				Constants.ROLE_GUEST_USER, 
	            				Constants.ROLE_BASIC_USER,
	            				Constants.ROLE_STANDARD_USER,
	            				Constants.ROLE_PREMIUM_USER)
	            		
	            		.requestMatchers("/config-main")
	            		.hasAnyAuthority(
	            				Constants.ROLE_GUEST_USER, 
	            				Constants.ROLE_BASIC_USER,
	            				Constants.ROLE_STANDARD_USER,
	            				Constants.ROLE_PREMIUM_USER)
	            		
	            		.requestMatchers("/catalog-documentaries")
	            		.hasAnyAuthority(
	            				Constants.ROLE_BASIC_USER,
	            				Constants.ROLE_STANDARD_USER,
	            				Constants.ROLE_PREMIUM_USER)
	            		
	            		.requestMatchers("/catalog-series")
	            		.hasAnyAuthority(
	            				Constants.ROLE_STANDARD_USER,
	            				Constants.ROLE_PREMIUM_USER)
	            		
	            		.requestMatchers("/catalog-movies")
	            		.hasAnyAuthority(
	            				Constants.ROLE_PREMIUM_USER)
	        			
	        			// Cualquier otro recurso requiere autenticación.
	        			.anyRequest().authenticated()	  
	        			
	        			
	        )
	        // Configura una página para login personalizada.
	        .formLogin
	        (
	        	customLogin -> customLogin
	        		// Pagina de autenticación de usuario.
	        		.loginPage("/login")
	        		// Pagina que aparecerá si el login fall.la pelea que 
	        		.failureUrl("/index")
	        	    // Página a la que redirigir tras un login exitoso.
	        		// El paramtro booleano fuerza a acceder a /home o no 
	        		// incluso si el usuario intentaba acceder a otra pagina antes.
	        	    .defaultSuccessUrl("/home", false)
        	)
	        .logout
	        (
	        	customLogout -> customLogout
	        		// Pagina a la que se redirigirá el usuario si cierra sesión.
	        		.logoutSuccessUrl("/index.html")
	        );
        
        // Devolvera un objeto de configuración de filtro construido a partir de las instrucciones anteriores.
        return http.build();
    }

    /**
     * Configuración del codificador de contraseñas
     * @return Instancia de BCryptPasswordEncoder
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        // Usaremos 'BCryptPasswordEncoder' como forma de cifrar las contraseñas
        return new BCryptPasswordEncoder();
    }

    /**
     * Configuración del proveedor de autenticación
     * @return Instancia de DaoAuthenticationProvider configurada
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider()
    {
        // Crear el proveedor de autenticación
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        
        // Especificar el servicio de detalles de usuario y el codificador de contraseñas
        authProvider.setUserDetailsService(this.myUserDetailsService);
        authProvider.setPasswordEncoder(this.passwordEncoder());
        
        // Devolver el proveedor configurado
        return authProvider;
    }
    
    /**
     * Configuración de páginas de error personalizadas
     * @return Personalizador del servidor web con páginas de error configuradas
     */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer()
    {
        return factory ->
        {
            // Configurar la página para el error 404 (No encontrado)
            factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/not-found"));

            // Configurar la página para el error 403 (Prohibido)
            factory.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/forbidden"));
        };
    }
}
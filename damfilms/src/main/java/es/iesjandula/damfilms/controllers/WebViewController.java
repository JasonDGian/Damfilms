package es.iesjandula.damfilms.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import es.iesjandula.damfilms.dtos.PeliculaDto;
import es.iesjandula.damfilms.dtos.UsuarioDto;
import es.iesjandula.damfilms.models.Serie;
import es.iesjandula.damfilms.repositories.ISerieRepository;
import es.iesjandula.damfilms.services.DamfilmsUserDetailsService;
import es.iesjandula.damfilms.utils.Constants;
import es.iesjandula.damfilms.utils.DamfilmsServerError;
import lombok.extern.slf4j.Slf4j;

/**
 * Controlador para gestionar las vistas y páginas principales de la aplicación DAMFILMS.
 * 
 * <p>Esta clase actúa como un controlador en la arquitectura MVC de Spring. 
 * Gestiona las rutas y proporciona las vistas correspondientes para las páginas, paginas y la autenticación de usuarios.</p>
 * 
 * <p>Las funcionalidades principales incluyen:</p>
 * <ul>
 *   <li>Rutas para mostrar páginas de error personalizadas como "403 Prohibido" y "404 No encontrado".</li>
 *   <li>Rutas para las secciones principales de la plataforma: inicio, catálogos y configuración.</li>
 *   <li>Gestión de vistas relacionadas con la autenticación de usuarios, como login y registro.</li>
 *   <li>Un endpoint para registrar nuevos usuarios en la plataforma, gestionando la lógica
 *       de validación y almacenamiento en la base de datos.</li>
 * </ul>
 * 
 * <p>Este controlador utiliza las siguientes dependencias inyectadas:</p>
 * <ul>
 *   <li>{@link DamfilmsUserDetailsService}: Servicio para gestionar la lógica relacionada con usuarios.</li>
 *   <li>{@link BCryptPasswordEncoder}: Codificador para cifrar las contraseñas de manera segura.</li>
 * </ul>
 * 
 * <p>Además, utiliza la anotación {@code @Slf4j} para habilitar la generación de logs,
 * facilitando la depuración y el seguimiento de eventos en la aplicación.</p>
 *  
 * @see DamfilmsUserDetailsService
 * @see BCryptPasswordEncoder
 * 
 * @author David J. Gianmoena
 * @see <a href="https://github.com/tu-usuario">GitHub - David J. Gianmoena</a>
 * 
 */
@Controller
@Slf4j
public class WebViewController
{
	
	// Inyección de la clase personalizada que extiende UserDetailsService.
	// Este objeto se utiliza para gestionar y obtener los datos de los usuarios,
	// incluyendo la validación de credenciales y la carga de información de autenticación.
	@Autowired
	DamfilmsUserDetailsService userDetailServer;

	
	// Inyección del codificador de contraseñas BCrypt.
	// Este objeto se utiliza para cifrar las contraseñas de los usuarios de forma segura,
	// utilizando el algoritmo BCrypt.
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	ISerieRepository iseriesRepo;
	
	// ------------------ RUTAS TEST  --------------------
	@GetMapping(value = "/test")
	public String getTestPage() {
	    log.debug("{} - Redirigiendo el cliente hacia '/test'.", Constants.DEBUG_TAG);
	    return "test";
	}
	
	/**
	 * Metodo que rellena un modelo con una lista de peliculas.
	 * Ese modelo lo pasa luego a la vista test.
	 */
	@GetMapping(value = "/test-items")
	public String getTestItemsPage( Model model ) {
	    log.debug("{} - Redirigiendo el cliente hacia '/test-items'.", Constants.DEBUG_TAG);
	    
	
	    PeliculaDto peli1 = new PeliculaDto();
	    peli1.setTitulo("Jungla");
	    peli1.setPopindex(87);	   
	    peli1.setDuracion("120");
	    peli1.setFechaLanzamiento(new Date());
	    peli1.setPoster("500");
	    
	    PeliculaDto peli2 = new PeliculaDto();
	    peli2.setTitulo("Jungla2");
	    peli2.setPopindex(97);	   
	    peli2.setDuracion("124");
	    peli2.setFechaLanzamiento(new Date());
	    peli2.setPoster("Coco");
	   
	    List<PeliculaDto> listaPelis = new ArrayList<>();
	    listaPelis.add(peli1);
	    listaPelis.add(peli2);
	   	   
	   model.addAttribute("listaPelis",listaPelis);

	   // esta vista recibe el modelo con la lista de mapas.
	    return "test";
	}
	
	
	// ------------------ RUTAS ERRORES  --------------------

	/**
	 * Muestra la página de error personalizada para el código HTTP 403 (Prohibido).
	 * 
	 * @return la vista correspondiente al error 403.
	 */
	@GetMapping(value = "/forbidden")
	public String getForbiddenErrorPage() {
	    log.debug("{} - Redirigiendo el cliente hacia '/forbidden'.", Constants.DEBUG_TAG);
	    return "forbidden";
	}

	/**
	 * Muestra la página de error personalizada para el código HTTP 404 (No encontrado).
	 * 
	 * @return la vista correspondiente al error 404.
	 */
	@GetMapping(value = "/not-found")
	public String getNotFoundErrorPage() {
	    log.debug("{} - Redirigiendo el cliente hacia '/not-found-error'.", Constants.DEBUG_TAG);
	    return "not-found-error";
	}

	
	@GetMapping(value = "/failed-login")
	public String getFailedLoginErrorPage() {
	    log.debug("{} - Redirigiendo el cliente hacia '/failed-login'.", Constants.DEBUG_TAG);
	    return "failed-login";
	}
	
	
	// ------------------ RUTAS PLATAFORMA  --------------------

	/**
	 * Muestra la página de los términos y condiciones (EULA) de la plataforma.
	 * 
	 * @return la vista correspondiente a la página de términos y condiciones.
	 */
	@GetMapping(value = "/eula")
	public String getEulaPage() {
	    log.debug("{} - Redirigiendo el cliente hacia '/eula'.", Constants.DEBUG_TAG);
	    return "eula";
	}

	/**
	 * Muestra la página principal (raíz) de la plataforma.
	 * 
	 * @return la vista correspondiente a la página principal.
	 */
	@GetMapping(value = "/")
	public String getRootPage() {
	    log.debug("{} - Redirigiendo el cliente hacia '/index' desde '/'.", Constants.DEBUG_TAG);
	    return "index";
	}

	/**
	 * Muestra la página de inicio de la plataforma.
	 * 
	 * @return la vista correspondiente a la página de inicio.
	 */
	@GetMapping(value = "/index")
	public String getIndexPage() {
	    log.debug("{} - Redirigiendo el cliente hacia '/index'.", Constants.DEBUG_TAG);
	    return "index";
	}

	/**
	 * Muestra la página de inicio de la plataforma después de la autenticación.
	 * 
	 * @return la vista correspondiente a la página de inicio del usuario.
	 */
	@GetMapping(value = "/home")
	public String getHomePage( Model model ) {
	    log.debug("{} - Redirigiendo el cliente hacia '/home'.", Constants.DEBUG_TAG);
	    // añade identificador al modelo para activar el icono en navbar.
	    model.addAttribute("homeActive", "true");
	    return "home";
	}

	/**
	 * Muestra la página de catálogo de documentales.
	 * 
	 * @return la vista correspondiente al catálogo de documentales.
	 */
	@GetMapping(value = "/catalog-documentaries")
	public String getDocumentariesPage( Model model ) {
	    log.debug("{} - Redirigiendo el cliente hacia '/catalog-documentaries'.", Constants.DEBUG_TAG);
	    model.addAttribute("documentariesActive", "true");
	    return "catalog-documentaries";
	}

	/**
	 * Muestra la página de catálogo de series.
	 * 
	 * @return la vista correspondiente al catálogo de series.
	 */
	@GetMapping(value = "/catalog-series")
	public String getSeriesPage( Model model ) {
	    log.debug("{} - Redirigiendo el cliente hacia '/catalog-series'.", Constants.DEBUG_TAG);
	    
	    List<Serie> series = this.iseriesRepo.findAll();
	    //List<Serie> seriesPopulares = this.iseriesRepo.findAllSortByPopindex();
	    
	    model.addAttribute("seriesActive", "true");
	    model.addAttribute("listaSeries", series);
	    //model.addAttribute("listaSeriesPopulares", seriesPopulares);
	   
	    return "catalog-series";
	}

	/**
	 * Muestra la página de catálogo de películas.
	 * 
	 * @return la vista correspondiente al catálogo de películas.
	 */
	@GetMapping(value = "/catalog-movies")
	public String getMoviesPage( Model model ) {
	    log.debug("{} - Redirigiendo el cliente hacia '/catalog-movies'.", Constants.DEBUG_TAG);
	    model.addAttribute("filmsActive", "true");
	    return "catalog-movies";
	}

	/**
	 * Muestra la página de configuración principal de la plataforma.
	 * 
	 * @return la vista correspondiente a la página de configuración principal.
	 */
	@GetMapping(value = "/config-main")
	public String getMainConfigPage() {
	    log.debug("{} - Redirigiendo el cliente hacia '/config-main'.", Constants.DEBUG_TAG);
	    return "config-main";
	}
	
	@GetMapping(value = "/successful-logout")
	public String geLogoutPage() {
	    log.debug("{} - Redirigiendo el cliente hacia '/logout'.", Constants.DEBUG_TAG);
	    return "successful-logout";
	}
	
	// ------------------ RUTAS FRAGMENTOS  --------------------
	
	@GetMapping(value = "/navbar")
	public String getNavbar() {
	    log.debug("{} - Redirigiendo el cliente hacia '/config-main'.", Constants.DEBUG_TAG);
	    return "/fragments/navbar";
	}
	

	// ------------------ RUTAS AUTENTICACION  --------------------

	/**
	 * Muestra la página de inicio de sesión (login) para la autenticación del usuario.
	 * 
	 * @return la vista correspondiente a la página de login.
	 */
	@GetMapping(value = "/login")
	public String getLoginPage() {
	    log.debug("{} - Redirigiendo el cliente hacia '/login'.", Constants.DEBUG_TAG);
	    return "login";
	}

	/**
	 * Muestra la página de registro (signup) para la creación de una nueva cuenta de usuario.
	 * 
	 * @return la vista correspondiente a la página de registro.
	 */
	@GetMapping(value = "/signup")
	public String getSignupPage() {
	    log.debug("{} - Redirigiendo el cliente hacia '/signup'.", Constants.DEBUG_TAG);
	    return "sign-up";
	}


	/**
	 * Endpoint para registrar nuevos usuarios en la plataforma. Recibe un DTO y un
	 * Modelo de MVC
	 * 
	 * Primero controla si el email existe mediante el UserDetailService. 
	 * - Si el usuario existe configura un modelo y lo pasa a una vista
	 * que informa del error usando el mensaje almacenado en ese modelo.. 
	 * 
	 * - Si el usuario no existe prosigue con la ejecucion.
	 * 
	 * Codifica la contraseña con el passwordEncoder.
	 * - Almacena el resultado en una cadena 'encodedPassword'
	 * 
	 * hace un try para almacenar el usuario en BBDD.
	 * - invoca el metodo saveUser pasandole el DTO y la pass cifrada.
	 * 
	 * Controla excepciones.
	 * - De darse excepcion las añade al modelo y las envia a una pagina
	 * resultado que usará ese modelo para mostrar el mensaje de error.
	 * 
	 * Si no se dan errores volverá al login.
	 * @return
	 */
	@PostMapping(value = "/signup")
	public String userSignup( @RequestBody UsuarioDto usuarioDto , Model model )
	{
				
		log.debug("{} - Comenzando proceso de registro usuario.", Constants.DEBUG_TAG);
		// Comprueba si el correo está disponible.
		if ( this.userDetailServer.existsByUsername(usuarioDto.getEmail()) ){
			// Cargamos el modelo con información acerca del error encontrado.
			log.debug("{} - El usuario ya existe.", Constants.DEBUG_TAG);
			model.addAttribute("signupError", true);
			model.addAttribute("signupError", "El correo introducido ya está registrado.");
			// Vuelve a la pagina de registro con el modelo cargado.
			return "sign-up";
		}
		
		
		
		// Si el correo no está ya registrado...
		
		// Creamos una cadena con la contraseña cifrada para almacenamiento en BBDD.
		log.debug("{} - Cifrando clave.", Constants.DEBUG_TAG);
		String encodedPassword = this.passwordEncoder.encode(usuarioDto.getPassword());
		
		try{
			// Invoca el metodo de almacenamiento en BBDD de userDetailService.
			log.debug("{} - Almacenando usuario.", Constants.DEBUG_TAG);
			this.userDetailServer.saveUser( usuarioDto, encodedPassword );
			
		}
		catch( DamfilmsServerError e ){
			log.debug("{} - Error encontrado", Constants.DEBUG_TAG);
			model.addAttribute("signupError", true);
			model.addAttribute("signupErrorMessage", e.getMessage() );
			return "sign-up";
		}
		
		// Si todo ha salido a pedir de Milhouse entonces volvemos a Login.
		log.debug("{} - Redirigiendo a login.", Constants.DEBUG_TAG);
		return "login";
	}

}

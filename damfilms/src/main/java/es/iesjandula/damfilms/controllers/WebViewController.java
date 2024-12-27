package es.iesjandula.damfilms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import es.iesjandula.damfilms.dtos.UsuarioDto;
import es.iesjandula.damfilms.services.DamfilmsUserDetailsService;
import es.iesjandula.damfilms.utils.Constants;
import es.iesjandula.damfilms.utils.DamfilmsServerError;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class WebViewController
{
	
	@Autowired
	DamfilmsUserDetailsService userDetailServer;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	// ------------------ RUTAS ERRORES  --------------------
	
	@GetMapping(value = "/forbidden")
	public String getForbiddenErrorPage()
	{
		log.debug("Entregando /index a cliente mediante '/'.");
		return "forbidden";
	}
	
	@GetMapping(value = "/not-found")
	public String getNotFoundErrorPage()
	{
		log.debug("Entregando /not-found-error a cliente mediante '/'.");
		return "not-found-error";
	}
	
	// ------------------ RUTAS PLATAFORMA  --------------------
	
	@GetMapping(value = "/eula")
	public String getEulaPage()
	{
		log.debug("Entregando /eula al cliente.");
		return "eula";
	}
	
	@GetMapping(value = "/")
	public String getRootPage()
	{
		log.debug("Entregando /index a cliente mediante '/'.");
		return "index";
	}

	@GetMapping(value = "/index")
	public String getIndexPage()
	{
		log.debug("Entregando /index a cliente mediante '/index'.");
		return "index";
	}

	@GetMapping(value = "/home")
	public String getHomePage()
	{
		log.debug("Entregando /home al cliente.");
		return "home";
	}
	
	@GetMapping(value = "/catalog-documentaries")
	public String getDocumentariesPage()
	{
		log.debug("Entregando /catalog-documentaries al cliente.");
		return "catalog-documentaries";
	}
	
	@GetMapping(value = "/catalog-series")
	public String getSeriesPage()
	{
		log.debug("Entregando /catalog-series al cliente.");
		return "catalog-series";
	}
	
	@GetMapping(value = "/catalog-movies")
	public String getMoviesPage()
	{
		log.debug("Entregando /catalog-movies al cliente.");
		return "/catalog-movies";
	}
	
	@GetMapping(value = "/config-main")
	public String getMainConfigPage()
	{
		log.debug("Entregando /config-main al cliente.");
		return "/config-main";
	}
	
	// ------------------ RUTAS AUTENTICACION  --------------------
	
	@GetMapping(value = "/login")
	public String getLoginPage()
	{
		log.debug("Entregando /login al cliente.");
		return "login";
	}

	@GetMapping(value = "/signup")
	public String getSignupPage()
	{
		log.debug("lanzando signup al cliente.");
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
			return "/signup";
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
			return "/signup";
		}
		
		// Si todo ha salido a pedir de Milhouse entonces volvemos a Login.
		log.debug("{} - Redirigiendo a login.", Constants.DEBUG_TAG);
		return "/login";
	}

}

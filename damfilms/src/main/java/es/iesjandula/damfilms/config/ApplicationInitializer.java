package es.iesjandula.damfilms.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.damfilms.models.Role;
import es.iesjandula.damfilms.repositories.IRoleRepository;
import es.iesjandula.damfilms.utils.Constants;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApplicationInitializer
{
	// Inyecta dependencia de repositorio de roles.
	@Autowired
	IRoleRepository iRoleRepository;

	/**
	 * Metodo de inicialización de la aplicacion que controla si los roles

	 * necesarios para el funcionamiento existen en BBDD, de no existir los agrega.
	 * Se apoya en metodo privado saveRoleOperation()
	 * 
	 * @see saveRoleOperation()
	 */
	@PostConstruct
	public void createRoles()
	{

		// ------------------------ ROLE INVITADO ------------------------------------
		saveRoleOperation(Constants.ROLE_GUEST_USER);
		// ------------------------ ROLE BASICO ------------------------------------
		saveRoleOperation(Constants.ROLE_BASIC_USER);
		// ------------------------ ROLE ESTANDAR ------------------------------------
		saveRoleOperation(Constants.ROLE_STANDARD_USER);
		// ------------------------ ROLE PREMIUM ------------------------------------
		saveRoleOperation(Constants.ROLE_PREMIUM_USER);
	}

	/**
	 * Metodo que recibiendo una string de un rol controla si existe en bases de
	 * datos y de no existir lo almacenará.
	 * 
	 * @param roleString
	 */
	private void saveRoleOperation(String roleString)
	{
		// Busca objeto rol BASICO en BBDD.
		log.debug("{} - Buscando rol - {}", Constants.DEBUG_TAG, roleString);
		Optional<Role> roleOpt = this.iRoleRepository.findById(roleString);

		// Si el objeto opcional recuperado está vacio ( el rol no persiste en bbdd )
		if (roleOpt.isEmpty())
		{
			// Almacena el rol en BBDD.
			this.iRoleRepository.saveAndFlush(new Role(roleString, null));
			// Informa en debug de la operación.
			log.debug("{} - Rol almacenado en BBDD - {}", Constants.DEBUG_TAG, roleString);
		}
		else {
			log.debug("{} - Rol ya existe en BBDD - {}", Constants.DEBUG_TAG, roleString);
		}
	}
}
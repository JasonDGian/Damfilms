package es.iesjandula.damfilms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.Usuario;

/**
 * Repositorio de la entidad Usuario.
 * Esta interfaz extiende JpaRepository, lo que proporciona métodos CRUD básicos 
 * para la entidad Usuario, facilitando la gestión de los usuarios en la base de datos.
 */
@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, String> {

}

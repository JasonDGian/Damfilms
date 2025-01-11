package es.iesjandula.damfilms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.Tipo;

/**
 * Repositorio para la entidad Tipo.
 * Esta interfaz extiende JpaRepository, lo que proporciona métodos CRUD básicos  
 * para la entidad Tipo, facilitando la gestión de los tipos en la base de datos.
 */
@Repository
public interface ITipoRepository extends JpaRepository<Tipo, String> {
}


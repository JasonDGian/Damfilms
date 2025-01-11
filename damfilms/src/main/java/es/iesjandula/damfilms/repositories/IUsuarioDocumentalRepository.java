package es.iesjandula.damfilms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.UsuarioDocumental;
import es.iesjandula.damfilms.models.ids.UsuarioDocumentalId;

/**
 * Repositorio de la entidad UsuarioDocumental.
 * Esta interfaz extiende JpaRepository, lo que proporciona métodos CRUD básicos 
 * para la entidad UsuarioDocumental, incluyendo la gestión de relaciones entre usuarios y documentales.
 */
@Repository
public interface IUsuarioDocumentalRepository extends JpaRepository<UsuarioDocumental, UsuarioDocumentalId> {
}


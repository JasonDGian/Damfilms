package es.iesjandula.damfilms.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.SuscripcionUsuario;
import es.iesjandula.damfilms.models.ids.SuscripcionUsuarioId;

/**
 * Repositorio para la entidad SuscripcionUsuario.
 * Este repositorio extiende JpaRepository y permite gestionar las operaciones CRUD 
 * sobre la entidad SuscripcionUsuario, que vincula a los usuarios con las suscripciones
 * que han adquirido.
 * 
 * El repositorio proporciona métodos para obtener suscripciones específicas de un usuario
 * y consultar detalles de suscripciones por email.
 * 
 * Métodos adicionales personalizados permiten realizar consultas específicas,
 * como obtener la suscripción más reciente de un usuario ordenada por fecha de fin.
 */
@Repository
public interface ISuscripcionUsuarioRepository extends JpaRepository<SuscripcionUsuario, SuscripcionUsuarioId> {

    /**
     * Busca la suscripción más reciente de un usuario, ordenada por la fecha de fin.
     * 
     * @param email el correo electrónico del usuario cuya suscripción más reciente se desea obtener.
     * @return un objeto {@link Optional} que contiene la suscripción más reciente, si existe.
     */
    @Query("SELECT su FROM SuscripcionUsuario su WHERE su.suscripcionUsuarioId.email = :email ORDER BY su.suscripcionUsuarioId.fechaFin DESC")
    Optional<SuscripcionUsuario> buscaSuscripcionUltimaFechaCierre(@Param("email") String email);
}
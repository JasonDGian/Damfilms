package es.iesjandula.damfilms.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.Suscripcion;

/**
 * Repositorio para la entidad Suscripcion.
 * Este repositorio extiende JpaRepository para manejar las operaciones CRUD 
 * básicas y personalizadas para la entidad Suscripcion, que representa las 
 * suscripciones disponibles en el sistema.
 * 
 * Métodos proporcionados:
 * - findByNombre: Busca una suscripción basada en su nombre.
 * - findByNombreDeSuscriptions: Recupera una lista de nombres de suscripciones.
 */
@Repository
public interface ISuscripcionRepository extends JpaRepository<Suscripcion, String> {

    /**
     * Recupera un objeto opcional de suscripción basado en el nombre de la suscripción.
     * 
     * @param nombreSuscripcion el nombre de la suscripción a buscar.
     * @return un Optional de Suscripcion que contiene la suscripción si existe.
     */
    public Optional<Suscripcion> findByNombre(String nombreSuscripcion);

    /**
     * Recupera una lista de todos los nombres de suscripciones disponibles.
     * 
     * @return una lista de cadenas que representan los nombres de las suscripciones.
     */
    @Query("Select s.nombre FROM Suscripcion s")
    public List<String> findByNombreDeSuscriptions();
}

package es.iesjandula.damfilms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.Temporada;
import es.iesjandula.damfilms.models.ids.TemporadaId;

/**
 * Repositorio para la entidad Temporada.
 * Este repositorio extiende JpaRepository para gestionar las operaciones CRUD 
 * básicas para la entidad Temporada, que representa las temporadas de las series 
 * en el sistema.
 */
@Repository
public interface ITemporadaRepository extends JpaRepository<Temporada, TemporadaId> {
}


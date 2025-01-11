package es.iesjandula.damfilms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.GeneroSerie;
import es.iesjandula.damfilms.models.ids.GeneroSerieId;

/**
 * Repositorio de la entidad GeneroSerie.
 * Esta interfaz extiende JpaRepository, proporcionando métodos CRUD básicos 
 * para la entidad GeneroSerie, que maneja las relaciones entre géneros y series en la base de datos.
 */
@Repository
public interface IGeneroSerieRepository extends JpaRepository<GeneroSerie, GeneroSerieId> {

}

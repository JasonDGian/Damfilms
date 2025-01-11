package es.iesjandula.damfilms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.GeneroPelicula;
import es.iesjandula.damfilms.models.ids.GeneroPeliculaId;

/**
 * Repositorio de la entidad GeneroPelicula.
 * Esta interfaz extiende JpaRepository, lo que proporciona métodos CRUD básicos 
 * para la entidad GeneroPelicula, incluyendo la gestión de relaciones entre géneros y películas.
 */
@Repository
public interface IGeneroPeliculaRepository extends JpaRepository<GeneroPelicula, GeneroPeliculaId> {

}

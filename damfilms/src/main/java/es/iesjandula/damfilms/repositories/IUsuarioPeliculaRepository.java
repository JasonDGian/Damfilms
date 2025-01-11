package es.iesjandula.damfilms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.UsuarioPelicula;
import es.iesjandula.damfilms.models.ids.UsuarioPeliculaId;

/**
 * Repositorio de la entidad UsuarioPelicula.
 * Esta interfaz extiende JpaRepository, lo que proporciona métodos CRUD básicos 
 * para la entidad UsuarioPelicula, facilitando la gestión de las relaciones 
 * entre usuarios y películas en la base de datos.
 */
@Repository
public interface IUsuarioPeliculaRepository extends JpaRepository<UsuarioPelicula, UsuarioPeliculaId> {

}

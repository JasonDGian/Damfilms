package es.iesjandula.damfilms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.UsuarioSerie;
import es.iesjandula.damfilms.models.ids.UsuarioSerieId;

/**
 * Repositorio de la entidad UsuarioSerie.
 * Esta interfaz extiende JpaRepository, lo que proporciona métodos CRUD básicos 
 * para la entidad UsuarioSerie, facilitando la gestión de las relaciones 
 * entre usuarios y series en la base de datos.
 */
@Repository
public interface IUsuarioSerieRepository extends JpaRepository<UsuarioSerie, UsuarioSerieId> {

}

package es.iesjandula.damfilms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.Genero;

/**
 * Repositorio de la entidad Genero.
 * Esta interfaz extiende JpaRepository, lo que proporciona métodos CRUD básicos 
 * para la entidad Genero, facilitando la gestión de los géneros en la base de datos.
 */
@Repository
public interface IGeneroRepository extends JpaRepository<Genero, String> {

}

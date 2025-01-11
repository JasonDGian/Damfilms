package es.iesjandula.damfilms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.Serie;

/**
 * Repositorio para la entidad Serie.
 * Este repositorio extiende JpaRepository para manejar las operaciones CRUD 
 * básicas y personalizadas para la entidad Serie, que representa series de televisión 
 * en el sistema.
 * 
 * Métodos proporcionados:
 * - encontrarSeriesPorTipoYGenero: Busca series filtradas por tipo y género.
 * - encontrarSeriesOrdenadasPorPopularidad: Obtiene series ordenadas por índice de popularidad (popindex).
 * - encontrarSeriesOrdenadasPorFechaDeLlegada: Obtiene series ordenadas por fecha de llegada.
 */
@Repository
public interface ISerieRepository extends JpaRepository<Serie, Long>
{
    /**
     * Encuentra series que coinciden con el tipo y el género especificados.
     * 
     * @param tipoNombre el nombre del tipo de la serie (opcional).
     * @param generoNombre el nombre del género de la serie (opcional).
     * @return lista de series que coinciden con los filtros de tipo y género.
     */
	@Query("SELECT s FROM Serie s " +
		       "JOIN s.generos gs " + 
		       "JOIN gs.genero g " + 
		       "WHERE (:tipoNombre IS NULL OR s.tipo.nombre = :tipoNombre) " +
		       "AND (:generoNombre IS NULL OR g.nombre = :generoNombre)")
		List<Serie> encontrarSeriesPorTipoYGenero(
		    @Param("tipoNombre") String tipoNombre,
		    @Param("generoNombre") String generoNombre
		);

    /**
     * Obtiene las series ordenadas por su índice de popularidad (popindex) en orden descendente.
     * 
     * @return lista de series ordenadas por popularidad.
     */
    @Query("SELECT s FROM Serie s ORDER BY s.popindex DESC")
    List<Serie> encontrarSeriesOrdenadasPorPopularidad();

    /**
     * Obtiene las series ordenadas por su fecha de llegada en orden descendente.
     * 
     * @return lista de series ordenadas por fecha de llegada.
     */
    @Query("SELECT s FROM Serie s ORDER BY s.fechaLlegada DESC")
    List<Serie> encontrarSeriesOrdenadasPorFechaDeLlegada();
}

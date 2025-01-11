package es.iesjandula.damfilms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.Documental;
import es.iesjandula.damfilms.models.ids.DocumentalId;

/**
 * Repositorio para la entidad Documental.
 * Este repositorio extiende JpaRepository para manejar las operaciones CRUD 
 * básicas y personalizadas para la entidad Documental, que representa documentales
 * en el sistema.
 * 
 * Métodos proporcionados:
 * - encontrarDocumentalPorGenero: Busca documentales filtrados por género.
 * - encontrarDocumentalesOrdenadasPorPopularidad: Obtiene documentales ordenados por índice de popularidad (popindex).
 * - encontrarDocumentalesOrdenadasPorFechaDeLlegada: Obtiene documentales ordenados por fecha de llegada.
 */
@Repository
public interface IDocumentalRepository extends JpaRepository<Documental, DocumentalId> 
{
    /**
     * Encuentra documentales que coinciden con el género especificado.
     * 
     * @param generoNombre el nombre del género del documental (opcional).
     * @return lista de documentales que coinciden con el filtro de género.
     */
	@Query("SELECT d FROM Documental d " +
		       "WHERE (:generoNombre IS NULL OR d.genero.nombre = :generoNombre)")
		List<Documental> encontrarDocumentalPorGenero(
		    @Param("generoNombre") String generoNombre
		);

    /**
     * Obtiene los documentales ordenados por su índice de popularidad (popindex) en orden descendente.
     * 
     * @return lista de documentales ordenados por popularidad.
     */
    @Query("SELECT d FROM Documental d ORDER BY d.popindex DESC")
    List<Documental> encontrarDocumentalOrdenadasPorPopularidad();

    /**
     * Obtiene los documentales ordenados por su fecha de llegada en orden descendente.
     * 
     * @return lista de documentales ordenados por fecha de llegada.
     */
    @Query("SELECT d FROM Documental d ORDER BY d.fechaLlegada DESC")
    List<Documental> encontrarDocumentalOrdenadasPorFechaDeLlegada();
}

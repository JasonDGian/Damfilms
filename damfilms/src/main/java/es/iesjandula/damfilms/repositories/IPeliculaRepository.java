package es.iesjandula.damfilms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.Pelicula;
import es.iesjandula.damfilms.models.ids.PeliculaId;

/**
 * Repositorio para la entidad Pelicula.
 * Este repositorio extiende JpaRepository para manejar las operaciones CRUD 
 * básicas y personalizadas para la entidad Pelicula, que representa películas
 * en el sistema.
 * 
 * Métodos proporcionados:
 * - encontrarPeliculasPorTipoYGenero: Busca películas por tipo y género (con parámetros opcionales).
 * - encontrarPeliculasOrdenadasPorPopularidad: Obtiene películas ordenadas por índice de popularidad (popindex).
 * - encontrarPeliculasOrdenadasPorFechaDeLlegada: Obtiene películas ordenadas por fecha de llegada.
 */
@Repository
public interface IPeliculaRepository extends JpaRepository<Pelicula, PeliculaId> {

    /**
     * Encuentra películas que coinciden con el tipo y género especificados.
     * 
     * @param tipoNombre el nombre del tipo de la película (opcional).
     * @param generoNombre el nombre del género de la película (opcional).
     * @return lista de películas que coinciden con los filtros proporcionados.
     */
    @Query("SELECT p FROM Pelicula p " +
               "JOIN GeneroPelicula gp ON p.titulo = gp.peliculaTitulo " +
               "WHERE (:tipoNombre IS NULL OR p.tipoNombre = :tipoNombre) " +
               "AND (:generoNombre IS NULL OR gp.generoNombre = :generoNombre)")
    List<Pelicula> encontrarPeliculasPorTipoYGenero(
        @Param("tipoNombre") String tipoNombre,
        @Param("generoNombre") String generoNombre
    );

    /**
     * Obtiene las películas ordenadas por su índice de popularidad (popindex) en orden descendente.
     * 
     * @return lista de películas ordenadas por popularidad.
     */
    @Query("SELECT p FROM Pelicula p ORDER BY p.popindex DESC")
    List<Pelicula> encontrarPeliculasOrdenadasPorPopularidad();

    /**
     * Obtiene las películas ordenadas por su fecha de llegada en orden descendente.
     * 
     * @return lista de películas ordenadas por fecha de llegada.
     */
    @Query("SELECT p FROM Pelicula p ORDER BY p.fechaLlegada DESC")
    List<Pelicula> encontrarPeliculasOrdenadasPorFechaDeLlegada();
}

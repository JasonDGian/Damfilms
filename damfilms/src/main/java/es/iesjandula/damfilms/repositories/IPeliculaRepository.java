package es.iesjandula.damfilms.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.Pelicula;
import es.iesjandula.damfilms.models.ids.PeliculaId;

@Repository
public interface IPeliculaRepository extends JpaRepository<Pelicula, PeliculaId>
{
	@Query("SELECT p FROM Pelicula p " +
		       "JOIN GeneroPelicula gp ON p.peliculaId = gp.pelicula.peliculaId " +
		       "WHERE (:tipoNombre IS NULL OR p.tipo.nombre = :tipoNombre) " +
		       "AND (:generoNombre IS NULL OR gp.genero.nombre = :generoNombre)")
		List<Pelicula> encontrarPeliculasPorTipoYGenero(
		    @Param("tipoNombre") String tipoNombre,
		    @Param("generoNombre") String generoNombre
		);

	@Query("SELECT p FROM Pelicula p ORDER BY p.popindex DESC")
	List<Pelicula> encontrarPeliculasOrdenadasPorPopularidad();
	@Query("SELECT p FROM Pelicula p ORDER BY p.fechaLlegada DESC")
	List<Pelicula> encontrarPeliculasOrdenadasPorFechaDeLlegada();
	


}

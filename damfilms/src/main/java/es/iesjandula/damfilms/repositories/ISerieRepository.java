package es.iesjandula.damfilms.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.Serie;

@Repository
public interface ISerieRepository extends JpaRepository<Serie, Long>
{

	@Query("SELECT s FROM Serie s " +
		       "JOIN s.generos gs " + 
		       "JOIN gs.genero g " + 
		       "WHERE (:tipoNombre IS NULL OR s.tipo.nombre = :tipoNombre) " +
		       "AND (:generoNombre IS NULL OR g.nombre = :generoNombre)")
		List<Serie> encontrarSeriesPorTipoYGenero(
		    @Param("tipoNombre") String tipoNombre,
		    @Param("generoNombre") String generoNombre
		);

	@Query("SELECT s FROM Serie s ORDER BY s.popindex DESC")
	List<Serie> encontrarSeriesOrdenadasPorPopularidad();
	@Query("SELECT s FROM Serie s ORDER BY s.fechaLlegada DESC")
	List<Serie> encontrarSeriesOrdenadasPorFechaDeLlegada();



}

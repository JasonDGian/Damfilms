package es.iesjandula.damfilms.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.Documental;
import es.iesjandula.damfilms.models.ids.DocumentalId;

@Repository
public interface IDocumentalRepository extends JpaRepository<Documental, DocumentalId> 
{
	@Query("SELECT d FROM Documental d " +
		       "WHERE (:generoNombre IS NULL OR gp.generoNombre = :generoNombre)")
		List<Documental> encontrarDocuemntalPorGenero(
		    @Param("generoNombre") String generoNombre
		);
	@Query("SELECT d FROM Documental d ORDER BY d.popindex DESC")
	List<Documental> encontrarDocumentalOrdenadasPorPopularidad();
	@Query("SELECT d FROM Documental d ORDER BY d.fechaLlegada DESC")
	List<Documental> encontrarDocumentalOrdenadasPorFechaDeLlegada();
	


}
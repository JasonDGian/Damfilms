package es.iesjandula.damfilms.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.Suscripcion;

@Repository
public interface ISuscripcionRepository extends JpaRepository<Suscripcion, String>{

	
	// Recupera un objeto opcional de suscripcion basandose en el atributo nombre.
	public Optional<Suscripcion> findByNombre( String nombreSuscripcion );
	
	@Query("Select s.nombre FROM Suscripcion s")
	public List<String> findByNombreDeSuscriptions();
	
}

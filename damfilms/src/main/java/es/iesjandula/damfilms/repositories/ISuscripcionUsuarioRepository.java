package es.iesjandula.damfilms.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.SuscripcionUsuario;
import es.iesjandula.damfilms.models.ids.SuscripcionUsuarioId;

@Repository
public interface ISuscripcionUsuarioRepository extends JpaRepository<SuscripcionUsuario, SuscripcionUsuarioId> {

//	// Metodo que recupera las suscripciones de un usuario especifico.
//	// De ese listado de suscripciones, debe de elegir solo la primera.
//	// El criterio de ordenación se basa en la fechaFin, de mas reciente a menos reciente.
//	public Optional<SuscripcionUsuarioId> findTopByUsuario_EmailOrderByFechaFinDesc(String email);
//	
//	
//	@Query("SELECT s.role FROM SuscripcionUsuario su JOIN su.suscripcion s WHERE su.email = :email")
//	Optional<String> encuentraRoleSuscripcionUsuario(@Param("email") String email);
//	
//	@Query( " Select role FROM SuscripcionUsuario.Suscripcion WHERE Suscripcion " )
//	public String encuentraRoleSuscripcionPorEmail( String email );
	
	@Query( "SELECT su FROM SuscripcionUsuario su WHERE su.suscripcionUsuarioId.email = :email ORDER BY su.suscripcionUsuarioId.fechaFin DESC" )
	Optional<SuscripcionUsuario> buscaSuscripcionUltimaFechaCierre( @Param("email") String email );
	
	//findTopByEmailOrderByFechaFinDesc
}

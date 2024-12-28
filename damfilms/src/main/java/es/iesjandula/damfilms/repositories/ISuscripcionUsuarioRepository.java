package es.iesjandula.damfilms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.damfilms.models.SuscripcionUsuario;
import es.iesjandula.damfilms.models.Ids.SuscripcionUsuarioId;

public interface ISuscripcionUsuarioRepository extends JpaRepository<SuscripcionUsuario, SuscripcionUsuarioId> {

}

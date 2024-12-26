package es.iesjandula.damfilms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.Suscripcion;

@Repository
public interface ISuscripcionRepository extends JpaRepository<Suscripcion, String>{

}

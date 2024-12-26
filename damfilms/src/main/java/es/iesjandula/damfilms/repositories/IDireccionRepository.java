package es.iesjandula.damfilms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.Direccion;

@Repository
public interface IDireccionRepository extends JpaRepository<Direccion, Long>{

}

package es.iesjandula.damfilms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.Tipo;

@Repository
public interface ITipoRepository extends JpaRepository<Tipo, String> {

}

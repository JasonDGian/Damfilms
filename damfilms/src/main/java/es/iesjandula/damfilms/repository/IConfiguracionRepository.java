package es.iesjandula.damfilms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.Configuracion;

@Repository
public interface IConfiguracionRepository extends JpaRepository<Configuracion, Long>{

}

package es.iesjandula.damfilms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.GeneroSerie;
import es.iesjandula.damfilms.models.Ids.GeneroSerieId;

@Repository
public interface IGeneroSerieRepository extends JpaRepository<GeneroSerie, GeneroSerieId>{

}

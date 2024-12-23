package es.iesjandula.damfilms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.damfilms.models.GeneroSerie;
import es.iesjandula.damfilms.models.Ids.GeneroSerieId;

public interface iGeneroSerieRepository extends JpaRepository<GeneroSerie, GeneroSerieId>{

}

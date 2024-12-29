package es.iesjandula.damfilms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.GeneroSerie;
import es.iesjandula.damfilms.models.ids.GeneroSerieId;

@Repository
public interface IGeneroSerieRepository extends JpaRepository<GeneroSerie, GeneroSerieId>{

}

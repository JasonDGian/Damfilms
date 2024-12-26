package es.iesjandula.damfilms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.Temporada;
import es.iesjandula.damfilms.models.Ids.TemporadaId;

@Repository
public interface ITemporadaRepository extends JpaRepository<Temporada, TemporadaId>{

}

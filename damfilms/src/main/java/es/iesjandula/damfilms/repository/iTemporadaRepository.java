package es.iesjandula.damfilms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.damfilms.models.Temporada;
import es.iesjandula.damfilms.models.Ids.TemporadaId;

public interface iTemporadaRepository extends JpaRepository<Temporada, TemporadaId>{

}

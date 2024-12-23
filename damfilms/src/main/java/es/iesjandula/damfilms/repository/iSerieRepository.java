package es.iesjandula.damfilms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.damfilms.models.Serie;

public interface iSerieRepository extends JpaRepository<Serie, Long>{

}

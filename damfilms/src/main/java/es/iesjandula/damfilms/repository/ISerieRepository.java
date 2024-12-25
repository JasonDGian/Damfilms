package es.iesjandula.damfilms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.Serie;

@Repository
public interface ISerieRepository extends JpaRepository<Serie, Long>{

}

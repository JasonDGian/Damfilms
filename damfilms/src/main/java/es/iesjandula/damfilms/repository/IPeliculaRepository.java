package es.iesjandula.damfilms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.Pelicula;
import es.iesjandula.damfilms.models.Ids.PeliculaId;

@Repository
public interface IPeliculaRepository extends JpaRepository<Pelicula, PeliculaId>{

}
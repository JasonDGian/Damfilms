package es.iesjandula.damfilms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.damfilms.models.Pelicula;
import es.iesjandula.damfilms.models.Ids.PeliculaId;

public interface iPeliculaRepository extends JpaRepository<Pelicula, PeliculaId>{

}

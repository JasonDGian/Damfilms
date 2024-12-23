package es.iesjandula.damfilms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.damfilms.models.GeneroPelicula;
import es.iesjandula.damfilms.models.Ids.GeneroPeliculaId;

public interface iGeneroPeliculaRepository extends JpaRepository<GeneroPelicula, GeneroPeliculaId> {

}

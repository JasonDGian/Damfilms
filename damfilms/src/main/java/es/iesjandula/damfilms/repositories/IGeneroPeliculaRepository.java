package es.iesjandula.damfilms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.GeneroPelicula;
import es.iesjandula.damfilms.models.ids.GeneroPeliculaId;

@Repository
public interface IGeneroPeliculaRepository extends JpaRepository<GeneroPelicula, GeneroPeliculaId> {

}

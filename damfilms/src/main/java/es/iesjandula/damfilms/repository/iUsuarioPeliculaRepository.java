package es.iesjandula.damfilms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.damfilms.models.UsuarioPelicula;
import es.iesjandula.damfilms.models.Ids.UsuarioPeliculaId;

public interface iUsuarioPeliculaRepository extends JpaRepository<UsuarioPelicula, UsuarioPeliculaId>{

}

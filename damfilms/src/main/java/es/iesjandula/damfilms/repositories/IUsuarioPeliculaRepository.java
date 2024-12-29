package es.iesjandula.damfilms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.UsuarioPelicula;
import es.iesjandula.damfilms.models.ids.UsuarioPeliculaId;

@Repository
public interface IUsuarioPeliculaRepository extends JpaRepository<UsuarioPelicula, UsuarioPeliculaId>{

}

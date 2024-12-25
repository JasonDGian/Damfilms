package es.iesjandula.damfilms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.UsuarioPelicula;
import es.iesjandula.damfilms.models.Ids.UsuarioPeliculaId;

@Repository
public interface IUsuarioPeliculaRepository extends JpaRepository<UsuarioPelicula, UsuarioPeliculaId>{

}

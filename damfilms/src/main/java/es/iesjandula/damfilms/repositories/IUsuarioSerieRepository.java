package es.iesjandula.damfilms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.UsuarioSerie;
import es.iesjandula.damfilms.models.Ids.UsuarioSerieId;

@Repository
public interface IUsuarioSerieRepository extends JpaRepository<UsuarioSerie, UsuarioSerieId>{

}
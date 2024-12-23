package es.iesjandula.damfilms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.damfilms.models.UsuarioSerie;
import es.iesjandula.damfilms.models.Ids.UsuarioSerieId;

public interface iUsuarioSerieRepository extends JpaRepository<UsuarioSerie, UsuarioSerieId>{

}

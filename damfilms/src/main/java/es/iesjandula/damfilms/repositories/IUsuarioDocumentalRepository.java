package es.iesjandula.damfilms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.UsuarioDocumental;
import es.iesjandula.damfilms.models.Ids.UsuarioDocumentalId;

@Repository
public interface IUsuarioDocumentalRepository extends JpaRepository<UsuarioDocumental, UsuarioDocumentalId>{

}

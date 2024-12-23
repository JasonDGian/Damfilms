package es.iesjandula.damfilms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.damfilms.models.UsuarioDocumental;
import es.iesjandula.damfilms.models.Ids.UsuarioDocumentalId;

public interface iUsuarioDocumentalRepository extends JpaRepository<UsuarioDocumental, UsuarioDocumentalId>{

}

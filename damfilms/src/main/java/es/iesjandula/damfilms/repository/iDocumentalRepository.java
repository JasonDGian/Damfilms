package es.iesjandula.damfilms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.damfilms.models.Documental;
import es.iesjandula.damfilms.models.Ids.DocumentalId;

public interface iDocumentalRepository extends JpaRepository<Documental, DocumentalId> {

}

package es.iesjandula.damfilms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.Documental;
import es.iesjandula.damfilms.models.Ids.DocumentalId;

@Repository
public interface IDocumentalRepository extends JpaRepository<Documental, DocumentalId> {

}

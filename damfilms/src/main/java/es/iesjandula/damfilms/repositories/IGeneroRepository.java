package es.iesjandula.damfilms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.Genero;

@Repository
public interface IGeneroRepository extends JpaRepository<Genero, String>{

}

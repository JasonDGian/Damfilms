package es.iesjandula.damfilms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.damfilms.models.Usuario;

public interface iUsuarioRepository extends JpaRepository<Usuario, String>{

}

package es.iesjandula.damfilms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.UsuarioRole;
import es.iesjandula.damfilms.models.Ids.UsuarioRoleId;

@Repository
public interface IUsuarioRoleRepository extends JpaRepository<UsuarioRole, UsuarioRoleId>
{

}

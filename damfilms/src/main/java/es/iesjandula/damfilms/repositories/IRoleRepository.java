package es.iesjandula.damfilms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.damfilms.models.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, String>
{

}

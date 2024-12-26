package es.iesjandula.damfilms.models;

import es.iesjandula.damfilms.models.Ids.UsuarioRoleId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(UsuarioRoleId.class)
public class UsuarioRole
{
	@Id
	@ManyToOne
	private Usuario user;
	
	@Id
	@ManyToOne
	private Role role;

}

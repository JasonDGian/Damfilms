package es.iesjandula.damfilms.models.Ids;

import es.iesjandula.damfilms.models.Role;
import es.iesjandula.damfilms.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRoleId
{

	private Usuario user;
	
	private Role role;
}

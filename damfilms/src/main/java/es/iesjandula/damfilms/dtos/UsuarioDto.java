package es.iesjandula.damfilms.dtos;

import es.iesjandula.damfilms.models.Configuracion;
import es.iesjandula.damfilms.models.Direccion;
import es.iesjandula.damfilms.models.Suscripcion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
	
	private String email;
	
	private String nombreUsuario;
	
	private String password;
	
	private Suscripcion suscripcion;
	
	private Configuracion configuracion;
	
	private Direccion direccion;

}

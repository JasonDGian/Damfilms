package es.iesjandula.damfilms.dtos;

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
	
	private String nombreSuscripcion;

}

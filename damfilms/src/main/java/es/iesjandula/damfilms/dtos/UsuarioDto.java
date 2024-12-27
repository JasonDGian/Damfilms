package es.iesjandula.damfilms.dtos;

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
	
	private Boolean usuarioActivo;
	
	private Suscripcion suscripcion;
		
	private String fotoPerfil;
	
	private Boolean temaOscuro;
	
	private Boolean modoNoOyentes;
	
	private Boolean contenidoAdultos;

}

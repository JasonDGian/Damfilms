package es.iesjandula.damfilms.dtos;

import java.util.List;

import es.iesjandula.damfilms.models.Suscripcion;
import es.iesjandula.damfilms.models.SuscripcionUsuario;
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
			
	private String fotoPerfil;
	
	private Boolean temaOscuro;
	
	private Boolean modoNoOyentes;
	
	private Boolean contenidoAdultos;
	
	private List<SuscripcionUsuarioDto> suscripciones;


}

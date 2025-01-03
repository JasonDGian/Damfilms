package es.iesjandula.damfilms.dtos;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuscripcionUsuarioDto 
{

	private String role;
	
	private String email;
	
	private Date fechaInicio;

	private Date fechaFin;
	
	private UsuarioDto usuario;
	
	private SuscripcionDto suscripcion;
	
	private Double totalPrecio;
	
}

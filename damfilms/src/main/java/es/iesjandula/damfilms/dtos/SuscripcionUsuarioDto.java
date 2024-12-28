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

	private SuscripcionUsuarioIdDto suscripcionUsuarioId;
	
	private UsuarioDto usuario;
	
	private SuscripcionDto suscripcion;
	
	private Date fechaInicio;

	private Date fechaFin;

	private Double totalPrecio;
	
}

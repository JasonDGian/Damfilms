package es.iesjandula.damfilms.dtos;

import java.util.Date;
import java.util.List;

import es.iesjandula.damfilms.models.Suscripcion;
import es.iesjandula.damfilms.models.SuscripcionUsuario;
import es.iesjandula.damfilms.models.Usuario;
import es.iesjandula.damfilms.models.Ids.SuscripcionUsuarioId;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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

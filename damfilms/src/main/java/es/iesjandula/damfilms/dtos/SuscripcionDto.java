package es.iesjandula.damfilms.dtos;

import java.sql.Date;
import java.util.List;

import es.iesjandula.damfilms.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuscripcionDto {
	
	private String tipo;
	
	private Double precio;
	
	private String metodoPago;
	
	private Date fecha_facturacion;
	
	private List<Usuario> usuarios;

}

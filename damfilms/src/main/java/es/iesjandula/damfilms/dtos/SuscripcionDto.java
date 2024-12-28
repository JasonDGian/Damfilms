package es.iesjandula.damfilms.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuscripcionDto {
	
	private String role;
	
	private String nombre;
	
	private Double precioMensual;
	
	private List<UsuarioDto> Usuarios;

}

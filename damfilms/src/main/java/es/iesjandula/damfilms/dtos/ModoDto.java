package es.iesjandula.damfilms.dtos;

import java.util.List;

import es.iesjandula.damfilms.models.Configuracion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModoDto {
	
	private String nombre;
	
	private String descripcion;
	
	private List<Configuracion> configuracion;

}

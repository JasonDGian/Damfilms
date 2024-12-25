package es.iesjandula.damfilms.dtos;

import java.util.List;

import es.iesjandula.damfilms.models.Modo;
import es.iesjandula.damfilms.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfiguracionDto {
	
	private Long id;
	
	private String fotoPerfil;
	
	private Boolean tema;
	
	private Boolean accesibilidad;
	
	private Modo modo;
	
	private List<Usuario> usuarios;

}

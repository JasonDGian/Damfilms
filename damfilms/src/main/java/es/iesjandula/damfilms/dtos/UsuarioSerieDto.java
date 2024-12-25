package es.iesjandula.damfilms.dtos;

import es.iesjandula.damfilms.models.Serie;
import es.iesjandula.damfilms.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioSerieDto {
	
	private UsuarioSerieIdDto usuarioSerieId;
	
	private Usuario usuario;
	
	private Serie serie;
	
	private int capituloEnProgeso;

}

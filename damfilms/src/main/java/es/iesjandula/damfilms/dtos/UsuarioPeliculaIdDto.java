package es.iesjandula.damfilms.dtos;


import es.iesjandula.damfilms.models.ids.PeliculaId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPeliculaIdDto {
	
	private String email;
	
	private PeliculaId peliculaId;

}

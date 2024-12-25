package es.iesjandula.damfilms.dtos;

import es.iesjandula.damfilms.models.Ids.PeliculaId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneroPeliculaIdDto {
	
	private String nombre;
	
	private PeliculaId peliculaId;

}

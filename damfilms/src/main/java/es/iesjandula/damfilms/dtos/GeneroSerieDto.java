package es.iesjandula.damfilms.dtos;

import es.iesjandula.damfilms.models.Genero;
import es.iesjandula.damfilms.models.Serie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneroSerieDto {
	
	private GeneroSerieIdDto generoSerieId;
	
	private Genero genero;
	
	private Serie serie;

}

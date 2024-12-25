package es.iesjandula.damfilms.dtos;

import es.iesjandula.damfilms.models.Genero;
import es.iesjandula.damfilms.models.Pelicula;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneroPeliculaDto {
	
	private GeneroPeliculaIdDto generoPeliculaId;
	
	private Genero genero;
	
	private Pelicula pelicula;

}

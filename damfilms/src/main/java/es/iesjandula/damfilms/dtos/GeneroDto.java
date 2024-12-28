package es.iesjandula.damfilms.dtos;

import java.util.List;

import es.iesjandula.damfilms.models.Documental;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneroDto {
	
	private String nombre;
	
	private List<Documental> documentales;
	
	private List<PeliculaDto> peliculas;
	
	private List<SerieDto> series;
	
}

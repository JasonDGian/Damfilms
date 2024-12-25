package es.iesjandula.damfilms.dtos;

import java.util.List;

import es.iesjandula.damfilms.models.Pelicula;
import es.iesjandula.damfilms.models.Serie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoDto {
	
	private String nombre;
	
	private List<Pelicula> peliculas;
	
	private List<Serie> series;

}

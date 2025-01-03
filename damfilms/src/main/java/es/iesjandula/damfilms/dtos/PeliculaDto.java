package es.iesjandula.damfilms.dtos;

import java.util.Date;
import java.util.List;

import es.iesjandula.damfilms.models.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeliculaDto {
	
	private String titulo;
	
	private Date fechaLanzamiento;
		
	private String duracion;
	
	private String poster;

	private int popindex;

	private Date fechaLlegada;
	
	private String sinopsis;
	
	private Tipo tipo;
	
	private List<GeneroDto> generos;
	
	private List<UsuarioDto> usuarios;

}

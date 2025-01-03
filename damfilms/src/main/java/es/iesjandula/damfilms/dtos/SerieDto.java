package es.iesjandula.damfilms.dtos;

import java.util.Date;
import java.util.List;

import es.iesjandula.damfilms.models.Serie;
import es.iesjandula.damfilms.models.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SerieDto {
		
	private String titulo;
	
	private String duracion;
	
	private String poster;
	
	private int popindex;
	
	private Date fechaLlegada;
	
	private String sinopsis;
	
	private List<TemporadaDto> temporadas;
	
	private Tipo tipo;

	private List<GeneroDto> generos;
	
	private List<UsuarioDto> usuarios;
	
	public SerieDto ( Serie serie ){
		
		this.setTitulo(serie.getTitulo());
		this.setDuracion(serie.getDuracion());
		this.setPoster(serie.getPoster());
		this.setPopindex(serie.getPopindex());
		this.setFechaLlegada(serie.getFechaLlegada());
		this.setSinopsis(serie.getSinopsis());
		// falta por poner cosas
		
	}
}

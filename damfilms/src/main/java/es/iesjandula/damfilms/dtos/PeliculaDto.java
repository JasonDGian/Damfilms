package es.iesjandula.damfilms.dtos;

import java.sql.Date;

import es.iesjandula.damfilms.models.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeliculaDto {
	
	private PeliculaIdDto peliculaId;
	
	private String duracion;
	
	private String poster;

	private int popindex;

	private Date fechaLlegada;
	
	private Tipo tipo;

}

package es.iesjandula.damfilms.dtos;

import java.sql.Date;

import es.iesjandula.damfilms.models.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentalDto {
	
	private DocumentalIdDto documentalId;
	
	private String duracion;
	
	private String poster;
	
	private int popindex;
	
	private Date fecha_llegada;
	
	private Genero genero;
	
	

}

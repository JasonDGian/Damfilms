package es.iesjandula.damfilms.dtos;

import java.sql.Date;

import es.iesjandula.damfilms.models.Serie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemporadaDto {
	
	private int numeroTemporada;
	
	private Long id;
	
	private Serie serie;
	
	private String nombre;
	
	private Date fechaLanzamiento;
	
	private int numeroCapitulos;

}

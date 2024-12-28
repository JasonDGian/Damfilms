package es.iesjandula.damfilms.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeliculaIdDto {
	
	private String titulo;
	
	private Date fechaLanzamiento;

}

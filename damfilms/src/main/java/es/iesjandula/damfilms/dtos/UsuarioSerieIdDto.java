package es.iesjandula.damfilms.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioSerieIdDto {
	
	private String email;
	
	private Long id;

}

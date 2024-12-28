package es.iesjandula.damfilms.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuscripcionUsuarioIdDto {

	
	private String role;
	
	private String email;
}

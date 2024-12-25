package es.iesjandula.damfilms.dtos;

import es.iesjandula.damfilms.models.Ids.DocumentalId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDocumentalIdDto {
	
	private String email;
	
	private DocumentalId documentalId;

}

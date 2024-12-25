package es.iesjandula.damfilms.dtos;
import es.iesjandula.damfilms.models.Documental;
import es.iesjandula.damfilms.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDocumentalDto {
	
	private UsuarioDocumentalIdDto usuarioDocumentalId;
	
	private Usuario usuario;
	
	private Documental documental;
	
	private int minutoEnProgeso;

}

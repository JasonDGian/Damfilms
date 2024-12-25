package es.iesjandula.damfilms.dtos;
import es.iesjandula.damfilms.models.Pelicula;
import es.iesjandula.damfilms.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPeliculaDto {
	
	private UsuarioPeliculaIdDto usuarioPeliculaId;
	
	private Usuario usuario;
	
	private Pelicula pelicula;
	
	private int minutoEnProgeso;

}

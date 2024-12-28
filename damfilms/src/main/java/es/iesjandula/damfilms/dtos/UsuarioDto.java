package es.iesjandula.damfilms.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
	
	private String email;
	
	private String nombreUsuario;
	
	private String password;
	
	private Boolean usuarioActivo;
			
	private String fotoPerfil;
	
	private Boolean temaOscuro;
	
	private Boolean modoNoOyentes;
	
	private Boolean contenidoAdultos;
	
	private List<SuscripcionDto> suscripciones;
	
	private List<SerieDto> series;
	
	private List<PeliculaDto> peliculas;
	
	private List<DocumentalDto> documentales;

}

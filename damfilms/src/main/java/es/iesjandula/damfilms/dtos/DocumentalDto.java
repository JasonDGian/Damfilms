package es.iesjandula.damfilms.dtos;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
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
	
	private Date fechaLlegada;
	
	private String sinopsis;
	
	private GeneroDto genero;
	
	private List<UsuarioDto> usuarios;
	
	

}

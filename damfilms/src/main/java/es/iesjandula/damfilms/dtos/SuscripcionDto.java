package es.iesjandula.damfilms.dtos;

import java.sql.Date;
import java.util.List;

import es.iesjandula.damfilms.models.SuscripcionUsuario;
import es.iesjandula.damfilms.models.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuscripcionDto {
	
	private String role;
	
	private String nombre;
	
	private Double precioMensual;
	
	private List<SuscripcionUsuarioDto> suscripcionUsuarios;

}

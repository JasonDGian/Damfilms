package es.iesjandula.damfilms.dtos;

import java.util.List;

import es.iesjandula.damfilms.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DireccionDto {
	
	private Long id;
	
	private String pais;
	
	private String ciudad;
	
	private String calle;
	
	private int numeroVivienda;
	
	private int numeroPiso;
	
	private char letraPiso;
	
	private int codigoPostal;
	
	private List<Usuario> usuarios;

}
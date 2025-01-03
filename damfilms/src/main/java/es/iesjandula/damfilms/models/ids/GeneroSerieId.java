package es.iesjandula.damfilms.models.ids;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class GeneroSerieId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;
	
	private Long id;

}
package es.iesjandula.damfilms.models.Ids;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class TemporadaId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int numeroTemporada;
	
	private Long id;

}

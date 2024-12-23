package es.iesjandula.damfilms.models.Ids;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PeliculaId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String titulo;
	
	private Date fechaLanzamiento;

}

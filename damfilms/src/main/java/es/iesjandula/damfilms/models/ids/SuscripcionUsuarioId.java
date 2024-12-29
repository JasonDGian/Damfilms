package es.iesjandula.damfilms.models.ids;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SuscripcionUsuarioId implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = -1130256513559577542L;

	private String role;
	
	private String email;
	
	private Date fechaInicio;

	private Date fechaFin;
	
}

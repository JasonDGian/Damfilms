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
public class SuscripcionUsuarioId implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = -1130256513559577542L;

	private String role;
	
	private String email;
	
}

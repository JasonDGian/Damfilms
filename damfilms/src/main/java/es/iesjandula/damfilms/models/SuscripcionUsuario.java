package es.iesjandula.damfilms.models;

import java.util.Date;

import es.iesjandula.damfilms.models.ids.SuscripcionUsuarioId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class SuscripcionUsuario {

	@EmbeddedId
	private SuscripcionUsuarioId suscripcionUsuarioId;
	
	@ManyToOne
	@MapsId("email")
	private Usuario usuario;
	
	@ManyToOne
	@MapsId("role")
	private Suscripcion suscripcion;

	@Column
	private Double totalPrecio;

}

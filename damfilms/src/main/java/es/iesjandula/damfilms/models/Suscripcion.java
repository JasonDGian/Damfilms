package es.iesjandula.damfilms.models;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Suscripcion {
	
	@Id
	@Column
	private String tipo;
	
	@Column(nullable = false)
	private Double precio;
	
	@Column
	private String metodoPago;
	
	@Column
	private Date fecha_facturacion;
	
	@OneToMany(mappedBy = "suscripcion")
	private List<Usuario> usuarios;

}

package es.iesjandula.damfilms.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "direccion")
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	private String pais;
	
	@Column
	private String ciudad;
	
	@Column
	private String calle;
	
	@Column
	private int numeroVivienda;
	
	@Column
	private int numeroPiso;
	
	@Column
	private char letraPiso;
	
	@Column
	private int codigoPostal;
	
	@OneToMany(mappedBy = "direccion")
	private List<Usuario> usuarios;

}
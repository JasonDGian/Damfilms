package es.iesjandula.damfilms.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
/**
 * Representa la tabla que contiene los roles que el sistema de seguridad maneja.
 */
public class Role
{
	@Id
    @Column(name = "role")
    private String role ;
}
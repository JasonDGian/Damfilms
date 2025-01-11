package es.iesjandula.damfilms.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa un tipo de suscripción dentro del sistema.
 * 
 * Esta clase almacena información sobre las diferentes opciones
 * de suscripción disponibles, incluyendo su rol, nombre, precio mensual,
 * y la relación con los usuarios que poseen dichas suscripciones.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Suscripcion {

    /**
     * Rol asociado a la suscripción (por ejemplo, "Básico", "Premium").
     * Actúa como identificador único.
     */
    @Id
    @Column
    private String role;

    /**
     * Nombre de la suscripción. Este campo debe ser único y no puede ser nulo.
     */
    @Column(nullable = false, unique = true)
    private String nombre;

    /**
     * Precio mensual de la suscripción. Este campo no puede ser nulo.
     */
    @Column(nullable = false)
    private Double precioMensual;

    /**
     * Lista de relaciones entre esta suscripción y los usuarios que la poseen.
     */
    @OneToMany(mappedBy = "suscripcion")
    private List<SuscripcionUsuario> suscripcionUsuarios;

}

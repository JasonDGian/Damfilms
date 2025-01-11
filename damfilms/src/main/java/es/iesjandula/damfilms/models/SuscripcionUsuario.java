package es.iesjandula.damfilms.models;

import es.iesjandula.damfilms.models.ids.SuscripcionUsuarioId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa la relación entre una suscripción y un usuario.
 * 
 * Esta clase permite gestionar las suscripciones adquiridas por los usuarios,
 * incluyendo detalles adicionales como el precio total de la suscripción.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class SuscripcionUsuario {

    /**
     * Identificador compuesto que representa la relación entre un usuario y una suscripción.
     */
    @EmbeddedId
    private SuscripcionUsuarioId suscripcionUsuarioId;

    /**
     * Usuario asociado a esta relación de suscripción.
     * Este campo utiliza la clave "email" del identificador compuesto.
     */
    @ManyToOne
    @MapsId("email")
    private Usuario usuario;

    /**
     * Suscripción asociada a esta relación de usuario.
     * Este campo utiliza la clave "role" del identificador compuesto.
     */
    @ManyToOne
    @MapsId("role")
    private Suscripcion suscripcion;

    /**
     * Precio total de la suscripción calculado para este usuario.
     */
    @Column
    private Double totalPrecio;

}

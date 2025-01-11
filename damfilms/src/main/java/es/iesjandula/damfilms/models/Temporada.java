package es.iesjandula.damfilms.models;

import java.util.Date;

import es.iesjandula.damfilms.models.ids.TemporadaId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa una temporada de una serie de televisión.
 * La clase está mapeada a una entidad de base de datos en JPA.
 * La relación con la serie es de muchos a uno, donde una serie puede tener múltiples temporadas.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Temporada {

    /**
     * Identificador compuesto de la temporada, que incluye la serie y el número de la temporada.
     */
    @EmbeddedId
    private TemporadaId temporadaId;

    /**
     * La serie a la que pertenece esta temporada.
     * Se establece una relación de muchos a uno con la entidad {@link Serie}.
     */
    @ManyToOne
    @MapsId("id")
    private Serie serie;

    /**
     * Nombre de la temporada.
     * Este campo puede ser nulo.
     */
    @Column
    private String nombre;

    /**
     * Fecha de lanzamiento de la temporada.
     * Este campo no puede ser nulo.
     */
    @Column(nullable = false)
    private Date fechaLanzamiento;

    /**
     * Número de capítulos de la temporada.
     * Este campo no puede ser nulo.
     */
    @Column(nullable = false)
    private int numeroCapitulos;

}

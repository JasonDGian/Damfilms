package es.iesjandula.damfilms.models;

import es.iesjandula.damfilms.models.ids.GeneroSerieId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa la relación entre un género y una serie.
 * 
 * Esta clase permite asociar múltiples géneros a una misma serie
 * y viceversa. Utiliza un identificador compuesto para manejar la relación.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class GeneroSerie {

    /**
     * Identificador compuesto que representa la relación entre género y serie.
     */
    @EmbeddedId
    private GeneroSerieId generoSerieId;

    /**
     * Género asociado a la serie.
     * 
     * Se mapea mediante el atributo "nombre" de la entidad Género.
     */
    @ManyToOne
    @MapsId("nombre")
    @JoinColumn(referencedColumnName = "nombre")
    private Genero genero;

    /**
     * Serie asociada al género.
     * 
     * Se mapea mediante el atributo "id" de la entidad Serie.
     */
    @ManyToOne
    @MapsId("id")
    @JoinColumn(referencedColumnName = "id")
    private Serie serie;

}

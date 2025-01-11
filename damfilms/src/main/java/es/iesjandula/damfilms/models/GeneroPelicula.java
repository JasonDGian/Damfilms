package es.iesjandula.damfilms.models;

import es.iesjandula.damfilms.models.ids.GeneroPeliculaId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa la relación entre un género y una película.
 * 
 * Esta clase permite asociar múltiples géneros a una misma película
 * y viceversa. Utiliza un identificador compuesto para manejar la relación.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class GeneroPelicula {

    /**
     * Identificador compuesto que representa la relación entre género y película.
     */
    @EmbeddedId
    private GeneroPeliculaId generoPeliculaId;

    /**
     * Género asociado a la película.
     * 
     * Se mapea mediante el atributo "nombre" de la entidad Género.
     */
    @ManyToOne
    @MapsId("nombre")
    @JoinColumn(referencedColumnName = "nombre")
    private Genero genero;

    /**
     * Película asociada al género.
     * 
     * Se mapea mediante el atributo "peliculaId" de la entidad Película.
     */
    @ManyToOne
    @MapsId("peliculaId")
    private Pelicula pelicula;

}

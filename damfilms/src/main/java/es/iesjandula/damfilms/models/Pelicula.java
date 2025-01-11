package es.iesjandula.damfilms.models;

import java.util.Date;
import java.util.List;

import es.iesjandula.damfilms.models.ids.PeliculaId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa una película dentro del sistema.
 * 
 * Contiene información relevante sobre las películas disponibles,
 * incluyendo su duración, fecha de llegada, sinopsis, tipo, géneros asociados
 * y los usuarios relacionados con ella.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pelicula {

    /**
     * Identificador compuesto único para la película.
     */
    @EmbeddedId
    private PeliculaId peliculaId;

    /**
     * Duración de la película (formato esperado: HH:mm:ss).
     * Este campo no puede ser nulo.
     */
    @Column(nullable = false)
    private String duracion;

    /**
     * URL o ruta del póster de la película.
     */
    @Column
    private String poster;

    /**
     * Índice de popularidad único de la película.
     */
    @Column(unique = true)
    private int popindex;

    /**
     * Fecha de llegada de la película al sistema.
     * Este campo no puede ser nulo.
     */
    @Column(nullable = false)
    private Date fechaLlegada;

    /**
     * Breve sinopsis que describe el contenido de la película.
     * Este campo permite almacenar textos largos.
     */
    @Column(columnDefinition = "TEXT")
    private String sinopsis;

    /**
     * Tipo de la película (por ejemplo, "Largometraje", "Cortometraje").
     */
    @ManyToOne
    private Tipo tipo;

    /**
     * Lista de géneros asociados a esta película a través de la entidad intermedia GeneroPelicula.
     */
    @OneToMany(mappedBy = "pelicula")
    private List<GeneroPelicula> generos;

    /**
     * Lista de usuarios relacionados con esta película a través de la entidad intermedia UsuarioPelicula.
     */
    @OneToMany(mappedBy = "pelicula")
    private List<UsuarioPelicula> usuarios;

}

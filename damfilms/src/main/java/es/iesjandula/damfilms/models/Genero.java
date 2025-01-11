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
 * Representa un género dentro del sistema de gestión de películas, documentales y series.
 * 
 * Esta clase permite clasificar las distintas obras audiovisuales
 * mediante géneros como "Acción", "Drama", "Comedia", entre otros.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Genero {

    /**
     * Nombre del género.
     * Este campo actúa como identificador único.
     */
    @Id
    @Column
    private String nombre;

    /**
     * Lista de documentales asociados a este género.
     */
    @OneToMany(mappedBy = "genero")
    private List<Documental> documentales;

    /**
     * Lista de películas asociadas a este género.
     */
    @OneToMany(mappedBy = "genero")
    private List<GeneroPelicula> Peliculas;

    /**
     * Lista de series asociadas a este género.
     */
    @OneToMany(mappedBy = "genero")
    private List<GeneroSerie> Series;

}

package es.iesjandula.damfilms.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa una serie dentro del sistema.
 * 
 * Contiene información relevante sobre las series disponibles,
 * incluyendo su título, duración, fecha de llegada, sinopsis, tipo,
 * temporadas, géneros asociados y los usuarios relacionados con ella.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Serie {

    /**
     * Identificador único de la serie, generado automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    /**
     * Título de la serie.
     * Este campo no puede ser nulo.
     */
    @Column(nullable = false)
    private String titulo;

    /**
     * Duración promedio de los episodios de la serie (formato esperado: HH:mm:ss).
     * Este campo no puede ser nulo.
     */
    @Column(nullable = false)
    private String duracion;

    /**
     * URL o ruta del póster de la serie.
     */
    @Column
    private String poster;

    /**
     * Índice de popularidad único de la serie.
     */
    @Column(unique = true)
    private int popindex;

    /**
     * Fecha de llegada de la serie al sistema.
     * Este campo no puede ser nulo.
     */
    @Column(nullable = false)
    private Date fechaLlegada;

    /**
     * Breve sinopsis que describe el contenido de la serie.
     */
    @Column
    private String sinopsis;

    /**
     * Tipo de la serie (por ejemplo, "Miniserie", "Serie Regular").
     */
    @ManyToOne
    private Tipo tipo;

    /**
     * Lista de temporadas asociadas a la serie.
     */
    @OneToMany(mappedBy = "serie")
    private List<Temporada> temporadas;

    /**
     * Lista de géneros asociados a esta serie a través de la entidad intermedia GeneroSerie.
     */
    @OneToMany(mappedBy = "serie")
    private List<GeneroSerie> generos;

    /**
     * Lista de usuarios relacionados con esta serie a través de la entidad intermedia UsuarioSerie.
     */
    @OneToMany(mappedBy = "serie")
    private List<UsuarioSerie> usuarios;

}

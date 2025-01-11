package es.iesjandula.damfilms.models;

import java.util.Date;
import java.util.List;

import es.iesjandula.damfilms.models.ids.DocumentalId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa un documental en el sistema.
 * 
 * Contiene información relevante sobre los documentales disponibles,
 * incluyendo su duración, fecha de llegada, sinopsis, género, índice de popularidad,
 * y los usuarios asociados a ellos.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Documental {

    /**
     * Identificador compuesto único para el documental.
     */
    @EmbeddedId
    private DocumentalId documentalId;

    /**
     * Duración del documental (formato esperado: HH:mm:ss).
     * Este campo no puede ser nulo.
     */
    @Column(nullable = false)
    private String duracion;

    /**
     * URL o ruta del póster del documental.
     */
    @Column
    private String poster;

    /**
     * Índice de popularidad único del documental.
     */
    @Column(unique = true)
    private int popindex;

    /**
     * Fecha de llegada del documental al sistema.
     * Este campo no puede ser nulo.
     */
    @Column(nullable = false)
    private Date fechaLlegada;

    /**
     * Breve sinopsis que describe el contenido del documental.
     */
    @Column
    private String sinopsis;

    /**
     * Género asociado al documental.
     */
    @ManyToOne
    private Genero genero;

    /**
     * Lista de usuarios relacionados con el documental a través de la entidad intermedia UsuarioDocumental.
     */
    @OneToMany(mappedBy = "documental")
    private List<UsuarioDocumental> usuarios;
}

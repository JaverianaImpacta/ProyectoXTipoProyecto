package edu.javeriana.ingenieria.social.proyectoxtipo_proyecto.dominio;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="proyectoxtipo_proyecto")
public class ProyectoXTipoProyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer proyecto;
    private String tipo;
}

package edu.javeriana.ingenieria.social.proyectoxtipo_proyecto.repositorio;

import edu.javeriana.ingenieria.social.proyectoxtipo_proyecto.dominio.ProyectoXTipoProyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioProyectoXTipoProyecto extends JpaRepository<ProyectoXTipoProyecto, Integer> {
    List<ProyectoXTipoProyecto> findAllByTipo(String tipo);

    List<ProyectoXTipoProyecto> findAllByProyecto(Integer proyecto);
}

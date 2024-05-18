package edu.javeriana.ingenieria.social.proyectoxtipo_proyecto.servicio;

import edu.javeriana.ingenieria.social.proyectoxtipo_proyecto.dominio.ProyectoXTipoProyecto;
import edu.javeriana.ingenieria.social.proyectoxtipo_proyecto.repositorio.RepositorioProyectoXTipoProyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ServicioProyectoXtipoProyecto {
    @Autowired
    private RepositorioProyectoXTipoProyecto repositorio;

    public List<ProyectoXTipoProyecto> obtenerProyectoXTipoProyectos(){
        return repositorio.findAll();
    }

    public List<ProyectoXTipoProyecto> obtenerProyectoXTipoProyectos(String tipo){
        return repositorio.findAllByTipo(tipo);
    }

    public ProyectoXTipoProyecto obtenerProyectoXTipoProyecto(Integer id){
        return repositorio.findById(id).orElse(null);
    }

    public ProyectoXTipoProyecto crearProyectoXTipoProyecto(ProyectoXTipoProyecto proyectoXTipoProyecto){
        return repositorio.save(proyectoXTipoProyecto);
    }

    public ProyectoXTipoProyecto actualizarProyectoXTipoProyecto(Integer id, ProyectoXTipoProyecto proyectoXTipoProyecto){
        if(repositorio.findById(id).orElse(null) == null){
            return null;
        }
        proyectoXTipoProyecto.setId(id);
        return repositorio.save(proyectoXTipoProyecto);
    }

    public ProyectoXTipoProyecto borrarProyectoXTipoProyecto(Integer id){
        ProyectoXTipoProyecto aux = repositorio.findById(id).orElse(null);
        if(aux == null){
            return aux;
        }
        repositorio.delete(aux);
        return aux;
    }

    public boolean proyectoXTipoProyectoExiste(Integer id){
        return repositorio.existsById(id);
    }

    public boolean proyectoXTipoProyectoExiste(Integer proyecto, String tipo){
        List<ProyectoXTipoProyecto> aux = repositorio.findAllByProyecto(proyecto);
        for(ProyectoXTipoProyecto p : aux){
            if (Objects.equals(p.getTipo(), tipo)){
                return true;
            }
        }
        return false;
    }
}

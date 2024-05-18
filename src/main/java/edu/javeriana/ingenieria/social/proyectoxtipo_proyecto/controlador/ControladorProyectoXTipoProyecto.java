package edu.javeriana.ingenieria.social.proyectoxtipo_proyecto.controlador;

import edu.javeriana.ingenieria.social.proyectoxtipo_proyecto.dominio.ProyectoXTipoProyecto;
import edu.javeriana.ingenieria.social.proyectoxtipo_proyecto.servicio.ServicioProyectoXtipoProyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectoTipoProyectos")
@CrossOrigin(origins="http://localhost:4200")
public class ControladorProyectoXTipoProyecto {
    @Autowired
    private ServicioProyectoXtipoProyecto servicio;

    @GetMapping("listar")
    public List<ProyectoXTipoProyecto> obtenerProyectoXTipoProyectos() {
        return servicio.obtenerProyectoXTipoProyectos();
    }

    @GetMapping("obtenerTipo")
    public ResponseEntity<List<ProyectoXTipoProyecto>> obtenerProyectoXTipoProyectos(@RequestParam String tipo) {
        if(tipo == null || tipo.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(servicio.obtenerProyectoXTipoProyectos(tipo).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerProyectoXTipoProyectos(tipo), HttpStatus.OK);
    }

    @GetMapping("obtener")
    public ResponseEntity<ProyectoXTipoProyecto> obtenerProyectoXTipoProyecto(@RequestParam Integer id) {
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!servicio.proyectoXTipoProyectoExiste(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerProyectoXTipoProyecto(id), HttpStatus.OK);
    }

    @PostMapping("crear")
    public ResponseEntity<ProyectoXTipoProyecto> crearProyectoXTipoProyecto(@RequestBody ProyectoXTipoProyecto proyectoXTipoProyecto) {
        if(proyectoXTipoProyecto == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(servicio.proyectoXTipoProyectoExiste(proyectoXTipoProyecto.getId()) || servicio.proyectoXTipoProyectoExiste(proyectoXTipoProyecto.getProyecto(), proyectoXTipoProyecto.getTipo())){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(servicio.crearProyectoXTipoProyecto(proyectoXTipoProyecto), HttpStatus.CREATED);
    }

    @PutMapping("actualizar")
    public ResponseEntity<ProyectoXTipoProyecto> actualizarProyectoXTipoProyecto(@RequestParam Integer id, @RequestBody ProyectoXTipoProyecto proyectoXTipoProyecto) {
        if(id == null || proyectoXTipoProyecto == null || !id.equals(proyectoXTipoProyecto.getId())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(servicio.actualizarProyectoXTipoProyecto(id, proyectoXTipoProyecto) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(proyectoXTipoProyecto, HttpStatus.OK);

    }

    @DeleteMapping("eliminar")
    public ResponseEntity<HttpStatus> eliminarProyectoXTipoProyecto(@RequestParam Integer id) {
        if(id == null || id < 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(servicio.borrarProyectoXTipoProyecto(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package arquitectura._parcial.controllers;

import arquitectura._parcial.entities.Aeropuerto;
import arquitectura._parcial.services.AeropuertoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/aeropuertos")
public class AeropuertoController {

    private final AeropuertoService aeropuertoService;

    public AeropuertoController(AeropuertoService aeropuertoService) {
        this.aeropuertoService = aeropuertoService;
    }

    @GetMapping("/todos")
    public List<Aeropuerto> obtenerTodosLosAeropuertos() {
        return aeropuertoService.obtenerTodosLosAeropuertos();
    }

    @GetMapping("/{id}")
    public Optional<Aeropuerto> obtenerAeropuertoPorId(@PathVariable Integer id) {
        return aeropuertoService.obtenerAeropuertoPorId(id);
    }

    @PostMapping("/crear")
    public Aeropuerto crearAeropuerto(@RequestBody Aeropuerto aeropuerto) {
        return aeropuertoService.crearAeropuerto(aeropuerto);
    }

    @PutMapping("/actualizar/{id}")
    public Aeropuerto actualizarAeropuerto(@PathVariable Integer id, @RequestBody Aeropuerto aeropuerto) {
        return aeropuertoService.actualizarAeropuerto(id, aeropuerto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarAeropuerto(@PathVariable Integer id) {
        aeropuertoService.eliminarAeropuerto(id);
    }

}
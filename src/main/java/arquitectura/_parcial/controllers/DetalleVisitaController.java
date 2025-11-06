package arquitectura._parcial.controllers;

import arquitectura._parcial.entities.DetalleVisita;
import arquitectura._parcial.services.DetalleVisitaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/detalles-visitas")
public class DetalleVisitaController {

    private final DetalleVisitaService detalleVisitaService;

    public DetalleVisitaController(DetalleVisitaService detalleVisitaService) {
        this.detalleVisitaService = detalleVisitaService;
    }

    @GetMapping("/todos")
    public List<DetalleVisita> obtenerTodosLosDetalles() {
        return detalleVisitaService.obtenerTodosLosDetalles();
    }

    @GetMapping("/{id}")
    public DetalleVisita obtenerDetallePorId(@PathVariable Integer id) {
        return detalleVisitaService.obtenerDetallePorId(id);
    }

    @PostMapping("/registrar")
    public DetalleVisita registrarDetalleVisita(@RequestBody DetalleVisita detalleVisita) {
        return detalleVisitaService.registrarDetalleVisita(detalleVisita);
    }

    @PutMapping("/actualizar/{id}")
    public DetalleVisita actualizarDetalleVisita(@PathVariable Integer id, @RequestBody DetalleVisita detalleVisita) {
        return detalleVisitaService.actualizarDetalleVisita(id, detalleVisita);
    }

    @DeleteMapping("/eliminar/{id}")
    public Map<String, String> eliminarDetalleVisita(@PathVariable Integer id) {
        detalleVisitaService.eliminarDetalleVisita(id);
        return Map.of("message", "Detalle de visita " + id + " eliminado correctamente desde API Java");
    }

    @GetMapping("/usuario/historial")
    public List<DetalleVisita> obtenerHistorialPorUsuario(
            @RequestParam String nombreUsuario,
            @RequestParam Integer aeropuertoId) {
        return detalleVisitaService.obtenerHistorialPorUsuario(nombreUsuario, aeropuertoId);
    }
}
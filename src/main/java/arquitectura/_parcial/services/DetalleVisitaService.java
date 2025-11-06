package arquitectura._parcial.services;

import arquitectura._parcial.entities.DetalleVisita;
import java.util.List;

public interface DetalleVisitaService {
    List<DetalleVisita> obtenerTodosLosDetalles();
    DetalleVisita obtenerDetallePorId(Integer id);
    DetalleVisita registrarDetalleVisita(DetalleVisita detalleVisita);
    DetalleVisita actualizarDetalleVisita(Integer id, DetalleVisita detalleVisita);
    void eliminarDetalleVisita(Integer id);
    List<DetalleVisita> obtenerHistorialPorUsuario(String nombreUsuario, Integer aeropuertoId);
}
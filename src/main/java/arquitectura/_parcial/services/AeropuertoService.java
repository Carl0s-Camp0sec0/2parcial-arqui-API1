package arquitectura._parcial.services;

import arquitectura._parcial.entities.Aeropuerto;

import java.util.List;
import java.util.Optional;

public interface AeropuertoService {
    List<Aeropuerto> obtenerTodosLosAeropuertos();
    Optional<Aeropuerto> obtenerAeropuertoPorId(Integer id);
    Aeropuerto crearAeropuerto(Aeropuerto aeropuerto);
}
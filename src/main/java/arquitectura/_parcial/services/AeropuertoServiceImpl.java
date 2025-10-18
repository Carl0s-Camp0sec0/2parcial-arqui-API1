package arquitectura._parcial.services;

import arquitectura._parcial.entities.Aeropuerto;
import arquitectura._parcial.repositories.AeropuertoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AeropuertoServiceImpl implements AeropuertoService {

    private final AeropuertoRepository aeropuertoRepository;

    public AeropuertoServiceImpl(AeropuertoRepository aeropuertoRepository) {
        this.aeropuertoRepository = aeropuertoRepository;
    }

    @Override
    public List<Aeropuerto> obtenerTodosLosAeropuertos() {
        return aeropuertoRepository.findAll();
    }

    @Override
    public Optional<Aeropuerto> obtenerAeropuertoPorId(Integer id) {
        return aeropuertoRepository.findById(id);
    }

    @Override
    public Aeropuerto crearAeropuerto(Aeropuerto aeropuerto) {
        return aeropuertoRepository.save(aeropuerto);
    }
}
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

    @Override
    public Aeropuerto actualizarAeropuerto(Integer id, Aeropuerto aeropuertoActualizado) {
        Optional<Aeropuerto> aeropuertoExistente = aeropuertoRepository.findById(id);

        if (aeropuertoExistente.isPresent()) {
            Aeropuerto aeropuerto = aeropuertoExistente.get();
            aeropuerto.setNombre(aeropuertoActualizado.getNombre());
            return aeropuertoRepository.save(aeropuerto);
        } else {
            throw new RuntimeException("Aeropuerto no encontrado con ID: " + id);
        }
    }

    @Override
    public void eliminarAeropuerto(Integer id) {
        if (aeropuertoRepository.existsById(id)) {
            aeropuertoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Aeropuerto no encontrado con ID: " + id);
        }
    }
}
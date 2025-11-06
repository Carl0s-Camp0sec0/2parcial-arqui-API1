package arquitectura._parcial.services;

import arquitectura._parcial.entities.DetalleVisita;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class DetalleVisitaServiceImpl implements DetalleVisitaService {

    private final RestTemplate restTemplate;

    @Value("${api2.base.url:http://localhost:3000}")
    private String api2BaseUrl;

    public DetalleVisitaServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<DetalleVisita> obtenerTodosLosDetalles() {
        try {
            String url = api2BaseUrl + "/detalles-visitas/todos";

            ResponseEntity<List<DetalleVisita>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<DetalleVisita>>() {}
            );

            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener todos los detalles desde API 2: " + e.getMessage());
        }
    }

    @Override
    public DetalleVisita obtenerDetallePorId(Integer id) {
        try {
            String url = api2BaseUrl + "/detalles-visitas/" + id;

            ResponseEntity<DetalleVisita> response = restTemplate.getForEntity(url, DetalleVisita.class);
            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener detalle por ID desde API 2: " + e.getMessage());
        }
    }

    @Override
    public DetalleVisita registrarDetalleVisita(DetalleVisita detalleVisita) {
        try {
            String url = api2BaseUrl + "/detalles-visitas/registrar";

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<DetalleVisita> request = new HttpEntity<>(detalleVisita, headers);

            ResponseEntity<DetalleVisita> response = restTemplate.postForEntity(url, request, DetalleVisita.class);
            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException("Error al registrar detalle en API 2: " + e.getMessage());
        }
    }

    @Override
    public DetalleVisita actualizarDetalleVisita(Integer id, DetalleVisita detalleVisita) {
        try {
            String url = api2BaseUrl + "/detalles-visitas/actualizar/" + id;

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<DetalleVisita> request = new HttpEntity<>(detalleVisita, headers);

            ResponseEntity<DetalleVisita> response = restTemplate.exchange(
                    url,
                    HttpMethod.PUT,
                    request,
                    DetalleVisita.class
            );
            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar detalle en API 2: " + e.getMessage());
        }
    }

    @Override
    public void eliminarDetalleVisita(Integer id) {
        try {
            String url = api2BaseUrl + "/detalles-visitas/eliminar/" + id;

            restTemplate.delete(url);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar detalle en API 2: " + e.getMessage());
        }
    }

    @Override
    public List<DetalleVisita> obtenerHistorialPorUsuario(String nombreUsuario, Integer aeropuertoId) {
        try {
            String url = UriComponentsBuilder.fromHttpUrl(api2BaseUrl + "/detalles-visitas/usuario/historial")
                    .queryParam("nombreUsuario", nombreUsuario)
                    .queryParam("aeropuertoId", aeropuertoId)
                    .toUriString();

            ResponseEntity<List<DetalleVisita>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<DetalleVisita>>() {}
            );

            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener historial desde API 2: " + e.getMessage());
        }
    }
}
package arquitectura._parcial.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public class DetalleVisita {

    private Integer id;

    @JsonProperty("nombre_usuario")
    private String nombreUsuario;

    @JsonProperty("aeropuerto_id")
    private Integer aeropuertoId;

    private String fecha;

    private String hora;

    @JsonProperty("motivo_visita")
    private String motivoVisita;

    @JsonProperty("visita_id")
    private Integer visitaId;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    // Constructors
    public DetalleVisita() {}

    public DetalleVisita(String nombreUsuario, Integer aeropuertoId, String fecha,
                         String hora, String motivoVisita, Integer visitaId) {
        this.nombreUsuario = nombreUsuario;
        this.aeropuertoId = aeropuertoId;
        this.fecha = fecha;
        this.hora = hora;
        this.motivoVisita = motivoVisita;
        this.visitaId = visitaId;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Integer getAeropuertoId() {
        return aeropuertoId;
    }

    public void setAeropuertoId(Integer aeropuertoId) {
        this.aeropuertoId = aeropuertoId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMotivoVisita() {
        return motivoVisita;
    }

    public void setMotivoVisita(String motivoVisita) {
        this.motivoVisita = motivoVisita;
    }

    public Integer getVisitaId() {
        return visitaId;
    }

    public void setVisitaId(Integer visitaId) {
        this.visitaId = visitaId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "DetalleVisita{" +
                "id=" + id +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", aeropuertoId=" + aeropuertoId +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", motivoVisita='" + motivoVisita + '\'' +
                ", visitaId=" + visitaId +
                ", createdAt=" + createdAt +
                '}';
    }
}
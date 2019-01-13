package com.valtech.alquilauto.requests;

import com.valtech.alquilauto.entities.Automovil;
import com.valtech.alquilauto.factories.tipoAlquiler.ITipoAlquiler;

import java.util.UUID;

public class SolicitudRequest {

    private UUID id;
    private UUID idAutomovil;
    private Long idTipoAlquiler;
    private boolean aplicarPromo;
    private Automovil automovil;
    private ITipoAlquiler tipoAlquiler;
    private Long cantidadKms;

    public SolicitudRequest(UUID id, UUID idAutomovil, Long idTipoAlquiler, boolean aplicarPromo) {
        this.id = id;
        this.idAutomovil = idAutomovil;
        this.idTipoAlquiler = idTipoAlquiler;
        this.aplicarPromo = aplicarPromo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdAutomovil() {
        return idAutomovil;
    }

    public void setIdAutomovil(UUID idAutomovil) {
        this.idAutomovil = idAutomovil;
    }

    public Long getIdTipoAlquiler() {
        return idTipoAlquiler;
    }

    public void setIdTipoAlquiler(Long idTipoAlquiler) {
        this.idTipoAlquiler = idTipoAlquiler;
    }

    public boolean isAplicarPromo() {
        return aplicarPromo;
    }

    public void setAplicarPromo(boolean aplicarPromo) {
        this.aplicarPromo = aplicarPromo;
    }

    public Automovil getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }

    public ITipoAlquiler getTipoAlquiler() {
        return tipoAlquiler;
    }

    public void setTipoAlquiler(ITipoAlquiler tipoAlquiler) {
        this.tipoAlquiler = tipoAlquiler;
    }

    public Long getCantidadKms() {
        return cantidadKms;
    }

    public void setCantidadKms(Long cantidadKms) {
        this.cantidadKms = cantidadKms;
    }
}

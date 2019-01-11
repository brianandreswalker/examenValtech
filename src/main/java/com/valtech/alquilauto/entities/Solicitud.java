package com.valtech.alquilauto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.valtech.alquilauto.states.PendienteState;
import com.valtech.alquilauto.states.SolicitudState;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class Solicitud implements Serializable {

    private UUID id;
    private LocalDateTime fechaAlta;
    private SolicitudState enCursoState;
    private SolicitudState finalizadoState;
    private SolicitudState iniciadoState;
    private SolicitudState pendienteState;
    private SolicitudState actualState;
    private Alquiler alquiler;
    private Cliente cliente;

    public Solicitud(Cliente cliente) {
        this.actualState = new PendienteState();
        this.cliente = cliente;
        this.fechaAlta = LocalDateTime.now();
    }

    public Solicitud() {
        this.id = UUID.randomUUID();
        this.actualState = new PendienteState();
        this.fechaAlta = LocalDateTime.now();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    @JsonIgnore
    public SolicitudState getEnCursoState() {
        return enCursoState;
    }

    public void setEnCursoState(SolicitudState enCursoState) {
        this.enCursoState = enCursoState;
    }

    @JsonIgnore
    public SolicitudState getFinalizadoState() {
        return finalizadoState;
    }

    public void setFinalizadoState(SolicitudState finalizadoState) {
        this.finalizadoState = finalizadoState;
    }

    @JsonIgnore
    public SolicitudState getIniciadoState() {
        return iniciadoState;
    }

    public void setIniciadoState(SolicitudState iniciadoState) {
        this.iniciadoState = iniciadoState;
    }

    @JsonIgnore
    public SolicitudState getPendienteState() {
        return pendienteState;
    }

    public void setPendienteState(SolicitudState pendienteState) {
        this.pendienteState = pendienteState;
    }

    public SolicitudState getActualState() {
        return actualState;
    }

    public void setActualState(SolicitudState actualState) {
        this.actualState = actualState;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}

package com.valtech.alquilauto.entities;

import com.valtech.alquilauto.states.*;

import java.io.Serializable;

public class Solicitud implements Serializable {

    private Integer id;
    private SolicitudState enCursoState;
    private SolicitudState finalizadoState;
    private SolicitudState iniciadoState;
    private SolicitudState pendienteState;
    private SolicitudState actualState;
    private Alquiler alquiler;
    private Cliente cliente;
    private Double costoFinal;

    public Solicitud(Cliente cliente) {
        this.actualState = new PendienteState();
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getCostoFinal() {
        return costoFinal;
    }

    public void setCostoFinal(Double costoFinal) {
        this.costoFinal = costoFinal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    public SolicitudState getEnCursoState() {
        return enCursoState;
    }

    public void setEnCursoState(SolicitudState enCursoState) {
        this.enCursoState = enCursoState;
    }

    public SolicitudState getFinalizadoState() {
        return finalizadoState;
    }

    public void setFinalizadoState(SolicitudState finalizadoState) {
        this.finalizadoState = finalizadoState;
    }

    public SolicitudState getIniciadoState() {
        return iniciadoState;
    }

    public void setIniciadoState(SolicitudState iniciadoState) {
        this.iniciadoState = iniciadoState;
    }

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

}

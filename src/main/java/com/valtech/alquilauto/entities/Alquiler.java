package com.valtech.alquilauto.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Alquiler implements Serializable {

    private Automovil automovil;
    private Long idTipoAlquiler;

    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Double costoFinal;
    private Long cantidadKms;
    private Long cantidadHs;
    private Long cantidadSemanas;
    private boolean aplicarPromo;

    public Alquiler(Automovil automovil, Long idTipoAlquiler, boolean aplicarPromo) {
        this.automovil = automovil;
        this.idTipoAlquiler = idTipoAlquiler;
        this.aplicarPromo = aplicarPromo;
    }

    public Alquiler() {
    }

    public Automovil getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Double getCostoFinal() {
        return costoFinal;
    }

    public void setCostoFinal(Double costoFinal) {
        this.costoFinal = costoFinal;
    }

    public boolean isAplicarPromo() {
        return aplicarPromo;
    }

    public void setAplicarPromo(boolean aplicarPromo) {
        this.aplicarPromo = aplicarPromo;
    }

    public Long getIdTipoAlquiler() {
        return idTipoAlquiler;
    }

    public void setIdTipoAlquiler(Long idTipoAlquiler) {
        this.idTipoAlquiler = idTipoAlquiler;
    }

    public Long getCantidadKms() {
        return cantidadKms;
    }

    public void setCantidadKms(Long cantidadKms) {
        this.cantidadKms = cantidadKms;
    }

    public Long getCantidadHs() {
        return cantidadHs;
    }

    public void setCantidadHs(Long cantidadHs) {
        this.cantidadHs = cantidadHs;
    }

    public Long getCantidadSemanas() {
        return cantidadSemanas;
    }

    public void setCantidadSemanas(Long cantidadSemanas) {
        this.cantidadSemanas = cantidadSemanas;
    }
}
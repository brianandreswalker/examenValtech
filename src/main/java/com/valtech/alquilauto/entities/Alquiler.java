package com.valtech.alquilauto.entities;

import java.io.Serializable;
import java.util.Date;

public class Alquiler implements Serializable {

    private Long id;
    private Automovil automovil;
    private TipoAlquiler tipoAlquiler;

    private Date fechaInicio;
    private Date fechaFin;
    private Double costoFinal;
    private Double cantidadKms;
    private Double cantidadHs;
    private Integer cantidadSemanas;


    public Automovil getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }

    public Double getCantidadHs() {
        return cantidadHs;
    }

    public void setCantidadHs(Double cantidadHs) {
        this.cantidadHs = cantidadHs;
    }

    public Integer getCantidadSemanas() {
        return cantidadSemanas;
    }

    public void setCantidadSemanas(Integer cantidadSemanas) {
        this.cantidadSemanas = cantidadSemanas;
    }

    public Double getCantidadKms() {
        return cantidadKms;
    }

    public void setCantidadKms(Double cantidadKms) {
        this.cantidadKms = cantidadKms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Double getCostoFinal() {
        return costoFinal;
    }

    public void setCostoFinal(Double costoFinal) {
        this.costoFinal = costoFinal;
    }

    public TipoAlquiler getTipoAlquiler() {
        return tipoAlquiler;
    }

    public void setTipoAlquiler(TipoAlquiler tipoAlquiler) {
        this.tipoAlquiler = tipoAlquiler;
    }
}
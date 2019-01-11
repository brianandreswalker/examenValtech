package com.valtech.alquilauto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class Cliente implements Serializable {

    private UUID id;
    private String nombreCliente;
    private String dniCliente;

    private List<Solicitud> solicitudes;
    private List<Promocion> promociones;

    public Cliente(String nombreCliente, String dniCliente) {
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
        this.id = UUID.randomUUID();
    }

    public Cliente(){
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    @JsonIgnore
    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public List<Promocion> getPromociones() {
        return promociones;
    }

    public void setPromociones(List<Promocion> promociones) {
        this.promociones = promociones;
    }

}

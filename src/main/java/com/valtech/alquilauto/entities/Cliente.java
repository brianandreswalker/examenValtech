package com.valtech.alquilauto.entities;

import java.io.Serializable;
import java.util.List;

public class Cliente implements Serializable {

    private Integer id;
    private String nombreCliente;
    private String dniCliente;

    private List<Solicitud> solicitudes;

    public Cliente(String nombreCliente, String dniCliente) {
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

}

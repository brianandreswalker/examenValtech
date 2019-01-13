package com.valtech.alquilauto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class Cliente implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(Cliente.class);

    private UUID idCliente;
    private String nombreCliente;
    private String dniCliente;

    private List<Solicitud> solicitudes;
    private List<Promocion> promociones;

    public Cliente(String nombreCliente, String dniCliente) {
        logger.info("Creando un Cliente nombre: " + nombreCliente + " dni: " + dniCliente);
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
        this.idCliente = UUID.randomUUID();
    }

    public Cliente(){
    }

    public UUID getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(UUID idCliente) {
        this.idCliente = idCliente;
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

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", dniCliente='" + dniCliente + '\'' +
                ", promociones=" + promociones +
                '}';
    }
}

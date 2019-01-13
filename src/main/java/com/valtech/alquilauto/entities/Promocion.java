package com.valtech.alquilauto.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class Promocion {

    private static final Logger logger = LoggerFactory.getLogger(Promocion.class);

    private UUID id;
    private String descripcion;
    private Double porcentajeDeDescuento;

    public Promocion(String descripcion, Double porcentajeDeDescuento) {
        logger.info("Creando una Promocion descripcion: " + descripcion + " porcentajeDeDescuento: " + porcentajeDeDescuento);
        this.id = UUID.randomUUID();
        this.descripcion = descripcion;
        this.porcentajeDeDescuento = porcentajeDeDescuento;
    }

    public Double aplicarPromo(Double monto){
        logger.info("Aplicando Promo de descuento: " + this.descripcion + " al monto " + monto);
        return monto - ((porcentajeDeDescuento/100) * monto);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPorcentajeDeDescuento() {
        return porcentajeDeDescuento;
    }

    public void setPorcentajeDeDescuento(Double porcentajeDeDescuento) {
        this.porcentajeDeDescuento = porcentajeDeDescuento;
    }

    @Override
    public String toString() {
        return "Promocion{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", porcentajeDeDescuento=" + porcentajeDeDescuento +
                '}';
    }
}

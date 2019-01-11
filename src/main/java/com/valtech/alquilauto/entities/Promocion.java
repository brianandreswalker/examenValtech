package com.valtech.alquilauto.entities;

import java.util.UUID;

public class Promocion {

    private UUID id;
    private String descripcion;
    private Double porcentajeDeDescuento;

    public Promocion(String descripcion, Double porcentajeDeDescuento) {
        this.id = UUID.randomUUID();
        this.descripcion = descripcion;
        this.porcentajeDeDescuento = porcentajeDeDescuento;
    }

    public Double aplicarPromo(Double monto){
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

}

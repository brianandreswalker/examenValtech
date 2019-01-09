package com.valtech.alquilauto.entities;

import java.io.Serializable;

public class Automovil implements Serializable {

    private Long idAutomovil;
    private boolean disponible;
    private String patente;

    public Automovil(Long idAutomovil, boolean disponible, String patente) {
        this.idAutomovil = idAutomovil;
        this.disponible = disponible;
        this.patente = patente;
    }

    public Long getIdAutomovil() {
        return idAutomovil;
    }

    public void setIdAutomovil(Long idAutomovil) {
        this.idAutomovil = idAutomovil;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

}

package com.valtech.alquilauto.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.UUID;

public class Automovil implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(Automovil.class);

    private UUID idAutomovil;
    private boolean disponible;
    private String patente;

    public Automovil(UUID idAutomovil, boolean disponible, String patente) {
        logger.info("Creando un Automovil idAutomovil: " + idAutomovil + " patente: " + patente + " disponible: " + disponible);
        this.idAutomovil = idAutomovil;
        this.disponible = disponible;
        this.patente = patente;
    }

    public Automovil(boolean disponible, String patente) {
        logger.info("Creando un Automovil idAutomovil: patente: " + patente + " disponible: " + disponible);
        this.idAutomovil = UUID.randomUUID();
        this.disponible = disponible;
        this.patente = patente;
    }

    public Automovil(){
    }

    public UUID getIdAutomovil() {
        return idAutomovil;
    }

    public void setIdAutomovil(UUID idAutomovil) {
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

    @Override
    public String toString() {
        return "Automovil{" +
                "idAutomovil=" + idAutomovil +
                ", disponible=" + disponible +
                ", patente='" + patente + '\'' +
                '}';
    }
}

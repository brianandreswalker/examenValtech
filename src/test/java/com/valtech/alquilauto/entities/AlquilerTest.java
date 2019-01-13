package com.valtech.alquilauto.entities;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlquilerTest {

    private final Alquiler ALQ_TEST = new Alquiler(new Automovil(1L,true,"AAA111"), 1L, true);

    @Test
    public void getAutomovil() {
        Automovil automovil = ALQ_TEST.getAutomovil();
        Assert.assertEquals((long)automovil.getIdAutomovil(), 1);
    }

    @Test
    public void setAutomovil() {
    }

    @Test
    public void getFechaInicio() {
    }

    @Test
    public void setFechaInicio() {
    }

    @Test
    public void getFechaFin() {
    }

    @Test
    public void setFechaFin() {
    }

    @Test
    public void getCostoFinal() {
    }

    @Test
    public void setCostoFinal() {
    }

    @Test
    public void isAplicarPromo() {
    }

    @Test
    public void setAplicarPromo() {
    }

    @Test
    public void getIdTipoAlquiler() {
    }

    @Test
    public void setIdTipoAlquiler() {
    }

    @Test
    public void getCantidadKms() {
    }

    @Test
    public void setCantidadKms() {
    }

    @Test
    public void getCantidadHs() {
    }

    @Test
    public void setCantidadHs() {
    }

    @Test
    public void getCantidadSemanas() {
    }

    @Test
    public void setCantidadSemanas() {
    }

}
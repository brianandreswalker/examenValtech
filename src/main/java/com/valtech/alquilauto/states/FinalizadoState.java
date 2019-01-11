package com.valtech.alquilauto.states;

import com.valtech.alquilauto.entities.Solicitud;
import com.valtech.alquilauto.requests.SolicitudRequest;

import java.io.Serializable;

public class FinalizadoState implements SolicitudState, Serializable {

    private static String descripcion = "Finalizado";

    @Override
    public void siguienteState(Solicitud solicitud, SolicitudRequest solicitudRequest) {
        //Ultimo paso, solicitud cerrada.
    }

    @Override
    public void printStatus(Solicitud solicitud) {
        System.out.println("Estoy en el estado: " + FinalizadoState.class);
    }


    public String getDescripcion() {
        return descripcion;
    }

}

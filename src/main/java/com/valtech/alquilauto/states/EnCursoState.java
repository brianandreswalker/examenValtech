package com.valtech.alquilauto.states;

import com.valtech.alquilauto.entities.Solicitud;

import java.io.Serializable;

public class EnCursoState implements SolicitudState, Serializable {

    @Override
    public void siguienteState(Solicitud solicitud) {
        solicitud.setActualState(new IniciadoState());
    }

    @Override
    public void finalizarSolicitud(Solicitud solicitud) {
        //No se puede realizar ésta accion

    }

    @Override
    public void printStatus(Solicitud solicitud) {
        System.out.println("Estoy en el estado: " + FinalizadoState.class);
    }

}

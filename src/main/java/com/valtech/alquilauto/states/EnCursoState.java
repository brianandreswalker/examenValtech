package com.valtech.alquilauto.states;

import com.valtech.alquilauto.entities.Alquiler;
import com.valtech.alquilauto.entities.Solicitud;
import com.valtech.alquilauto.requests.SolicitudRequest;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class EnCursoState implements SolicitudState, Serializable {

    private static String descripcion = "En Curso";

    @Override
    public void siguienteState(Solicitud solicitud, SolicitudRequest solicitudRequest) {
        this.printStatus(solicitud);

        Alquiler alquiler = solicitud.getAlquiler();
        alquiler.setFechaInicio(LocalDateTime.now());

        solicitud.setActualState(new IniciadoState());
    }

    @Override
    public void printStatus(Solicitud solicitud) {
        System.out.println("Estoy en el estado: " + EnCursoState.class);
    }

    public String getDescripcion() {
        return descripcion;
    }

}

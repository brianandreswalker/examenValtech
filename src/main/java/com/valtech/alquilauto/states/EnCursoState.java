package com.valtech.alquilauto.states;

import com.valtech.alquilauto.entities.Alquiler;
import com.valtech.alquilauto.entities.Solicitud;
import com.valtech.alquilauto.requests.SolicitudRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class EnCursoState implements SolicitudState, Serializable {

    private static final Logger logger = LoggerFactory.getLogger(EnCursoState.class);

    private static String descripcion = "En Curso";

    @Override
    public void siguienteState(Solicitud solicitud, SolicitudRequest solicitudRequest) {

        Alquiler alquiler = solicitud.getAlquiler();
        alquiler.setFechaInicio(LocalDateTime.now());

        IniciadoState nextState = new IniciadoState();
        logger.info("Pasando del Estado: " + descripcion + " al Estado: " + nextState.getDescripcion());
        solicitud.setActualState(nextState);
    }

    public String getDescripcion() {
        return descripcion;
    }

}

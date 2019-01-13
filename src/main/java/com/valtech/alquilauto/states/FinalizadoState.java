package com.valtech.alquilauto.states;

import com.valtech.alquilauto.entities.Solicitud;
import com.valtech.alquilauto.requests.SolicitudRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class FinalizadoState implements SolicitudState, Serializable {

    private static final Logger logger = LoggerFactory.getLogger(FinalizadoState.class);

    private static String descripcion = "Finalizado";

    @Override
    public void siguienteState(Solicitud solicitud, SolicitudRequest solicitudRequest) {
        logger.info("Ésta Solicitud se encuentra en Estado: " + descripcion);
    }

    public String getDescripcion() {
        return descripcion;
    }

}

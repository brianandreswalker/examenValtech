package com.valtech.alquilauto.states;

import com.valtech.alquilauto.entities.Alquiler;
import com.valtech.alquilauto.entities.Solicitud;
import com.valtech.alquilauto.requests.SolicitudRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class PendienteState implements SolicitudState, Serializable {

    private static final Logger logger = LoggerFactory.getLogger(PendienteState.class);


    private static String descripcion = "Pendiente";

    @Override
    public void siguienteState(Solicitud solicitud, SolicitudRequest solicitudRequest) {
        Alquiler alquiler = new Alquiler(solicitudRequest.getAutomovil(), solicitudRequest.getIdTipoAlquiler(), solicitudRequest.isAplicarPromo());

        solicitudRequest.getAutomovil().setDisponible(false);
        solicitud.setAlquiler(alquiler);

        EnCursoState nextState = new EnCursoState();
        logger.info("Pasando del Estado: " + descripcion + " al Estado: " + nextState.getDescripcion());
        solicitud.setActualState(nextState);
    }

    public String getDescripcion() {
        return descripcion;
    }

}

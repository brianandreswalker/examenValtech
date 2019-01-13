package com.valtech.alquilauto.states;

import com.valtech.alquilauto.entities.Alquiler;
import com.valtech.alquilauto.entities.Solicitud;
import com.valtech.alquilauto.requests.SolicitudRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

public class IniciadoState  implements SolicitudState, Serializable {

    private static final Logger logger = LoggerFactory.getLogger(IniciadoState.class);

    private static String descripcion = "Iniciado";

    @Override
    public void siguienteState(Solicitud solicitud, SolicitudRequest solicitudRequest) {
        Alquiler alquiler = solicitud.getAlquiler();

        alquiler.setCantidadKms(solicitudRequest.getCantidadKms());
        solicitudRequest.getTipoAlquiler().calcularCosto(solicitud);

        // Le agrego un dia para que el calculo de horas dé algo. Sacarlo! BRIAN
        alquiler.setFechaFin(LocalDateTime.now().plusDays(1));
        alquiler.getAutomovil().setDisponible(true);

        calcularCantidades(solicitud, solicitudRequest);

        FinalizadoState nextState = new FinalizadoState();
        logger.info("Pasando del Estado: " + descripcion + " al Estado: " + nextState.getDescripcion());
        solicitud.setActualState(nextState);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void calcularCantidades(Solicitud solicitud, SolicitudRequest solicitudRequest){
        Alquiler alquiler = solicitud.getAlquiler();

        Long cantidadHs = alquiler.getCantidadHs();
        Long cantidadSemanas = alquiler.getCantidadSemanas();

        if(cantidadHs == null){
            cantidadHs = Duration.between(alquiler.getFechaInicio(), alquiler.getFechaFin()).toHours();
        }

        if(cantidadSemanas == null){
            cantidadSemanas = cantidadHs / 168;
        }

        alquiler.setCantidadHs(cantidadHs);
        alquiler.setCantidadSemanas(cantidadSemanas);
    }
}

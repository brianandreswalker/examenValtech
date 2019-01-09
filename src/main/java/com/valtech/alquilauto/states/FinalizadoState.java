package com.valtech.alquilauto.states;

import com.valtech.alquilauto.entities.Alquiler;
import com.valtech.alquilauto.entities.Solicitud;
import com.valtech.alquilauto.factories.tipoAlquiler.ITipoAlquiler;
import com.valtech.alquilauto.factories.tipoAlquiler.impl.TipoAlquilerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;

public class FinalizadoState implements SolicitudState, Serializable {

    @Autowired
    private TipoAlquilerFactory tipoAlquilerFactory;

    @Override
    public void siguienteState(Solicitud solicitud) {
        //Ultimo paso, solicitud cerrada.
    }

    @Override
    public void printStatus(Solicitud solicitud) {
        System.out.println("Estoy en el estado: " + FinalizadoState.class);
    }

    @Override
    public void finalizarSolicitud(Solicitud solicitud) {
            Alquiler alquiler = solicitud.getAlquiler();

            ITipoAlquiler tipoAlquiler = tipoAlquilerFactory.createTipoAlquiler(alquiler.getTipoAlquiler().getId());

            tipoAlquiler.calcularCosto(alquiler);

            alquiler.setFechaFin(new Date());
            solicitud.getActualState().siguienteState(solicitud);
    }

}

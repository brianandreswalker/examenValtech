package com.valtech.alquilauto.states;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.valtech.alquilauto.daos.SolicitudDAO;
import com.valtech.alquilauto.entities.Alquiler;
import com.valtech.alquilauto.entities.Automovil;
import com.valtech.alquilauto.entities.Solicitud;
import com.valtech.alquilauto.requests.SolicitudRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.activation.DataSource;
import java.io.Serializable;

public class PendienteState implements SolicitudState, Serializable {

    private static String descripcion = "Pendiente";

    @Override
    public void siguienteState(Solicitud solicitud, SolicitudRequest solicitudRequest) {
        this.printStatus(solicitud);
        Alquiler alquiler = new Alquiler(solicitudRequest.getAutomovil(), solicitudRequest.getIdTipoAlquiler(), solicitudRequest.isAplicarPromo());

        solicitudRequest.getAutomovil().setDisponible(false);
        solicitud.setAlquiler(alquiler);
        solicitud.setActualState(new EnCursoState());
    }

    @Override
    public void printStatus(Solicitud solicitud) {
        System.out.println("Estoy en el estado: " + PendienteState.class);
    }

    public String getDescripcion() {
        return descripcion;
    }

}

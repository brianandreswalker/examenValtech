package com.valtech.alquilauto.states;

import com.valtech.alquilauto.entities.Solicitud;
import com.valtech.alquilauto.requests.SolicitudRequest;

public interface SolicitudState {

    void siguienteState(Solicitud solicitud, SolicitudRequest solicitudRequest);

    void printStatus(Solicitud solicitud);

}

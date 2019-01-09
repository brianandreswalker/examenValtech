package com.valtech.alquilauto.states;

import com.valtech.alquilauto.entities.Solicitud;

public interface SolicitudState {

    void finalizarSolicitud(Solicitud solicitud);

    void siguienteState(Solicitud solicitud);

    void printStatus(Solicitud solicitud);

}

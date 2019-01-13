package com.valtech.alquilauto.daos;

import com.valtech.alquilauto.entities.Automovil;
import com.valtech.alquilauto.entities.Solicitud;

import java.util.List;
import java.util.UUID;

public interface SolicitudDAO {

    Solicitud addOne(Solicitud solicitud);

    List<Solicitud> findAll();

    Solicitud updateOne(Solicitud solicitud);

    Solicitud findOne(UUID solicitudId);

}

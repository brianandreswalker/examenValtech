package com.valtech.alquilauto.services;

import com.valtech.alquilauto.entities.Automovil;
import com.valtech.alquilauto.entities.Cliente;
import com.valtech.alquilauto.entities.Solicitud;
import com.valtech.alquilauto.requests.SolicitudRequest;

import java.util.List;
import java.util.UUID;

public interface ISolicitudService {

    Solicitud addOne(Cliente cliente);

    List<Solicitud> findAll();

    List<Automovil> findAllAutomoviles();

    Solicitud updateOne(SolicitudRequest solicitudRequest);

    Solicitud findOne(UUID solicitudId);
}

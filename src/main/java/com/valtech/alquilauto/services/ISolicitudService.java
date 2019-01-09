package com.valtech.alquilauto.services;

import com.valtech.alquilauto.entities.Automovil;
import com.valtech.alquilauto.entities.Cliente;
import com.valtech.alquilauto.entities.Solicitud;

import java.util.List;

public interface ISolicitudService {

    Solicitud addOne(Cliente cliente);

    List<Solicitud> findAll();

    List<Automovil> findAllAutomoviles();

    Solicitud updateOne(Solicitud solicitud);

    Solicitud findOne(Long solicitudId);
}

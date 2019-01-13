package com.valtech.alquilauto.services;

import com.valtech.alquilauto.entities.Cliente;
import com.valtech.alquilauto.entities.Solicitud;
import com.valtech.alquilauto.requests.SolicitudRequest;
import javassist.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface ISolicitudService {

    Solicitud addOne(Cliente cliente);

    List<Solicitud> findAll();

    Solicitud updateOne(SolicitudRequest solicitudRequest) throws NotFoundException;

    Solicitud findOne(UUID solicitudId);
}

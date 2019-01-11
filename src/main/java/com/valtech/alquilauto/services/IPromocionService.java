package com.valtech.alquilauto.services;

import com.valtech.alquilauto.entities.Cliente;
import com.valtech.alquilauto.entities.Promocion;
import com.valtech.alquilauto.entities.Solicitud;

import java.util.List;
import java.util.UUID;

public interface IPromocionService {

    void calcularPromo(Solicitud solicitud);

    Promocion addOne(Promocion promocion);

    List<Promocion> findAll();

    Promocion findOne(UUID promocionId);

    List<Promocion> addPromoToCliente(Promocion promocion, Cliente cliente);
}

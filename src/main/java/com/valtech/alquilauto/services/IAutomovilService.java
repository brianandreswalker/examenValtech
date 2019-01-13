package com.valtech.alquilauto.services;

import com.valtech.alquilauto.entities.Automovil;
import com.valtech.alquilauto.entities.Cliente;

import java.util.List;
import java.util.UUID;

public interface IAutomovilService {

    List<Automovil> findAll();

    Automovil findOne(UUID idAutomovil);

    Automovil addOne(Automovil automovil);

    Automovil findOneByPatente(String patenteAuto);

}

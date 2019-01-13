package com.valtech.alquilauto.daos;

import com.valtech.alquilauto.entities.Automovil;

import java.util.List;
import java.util.UUID;

public interface AutomovilDAO {

    Automovil findOne(UUID idAutomovil);

    List<Automovil> findAll();

    Automovil addOne(Automovil automovil);

    Automovil findOneByPatente(String patenteAuto);
}

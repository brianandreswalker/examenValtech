package com.valtech.alquilauto.daos;

import com.valtech.alquilauto.entities.Automovil;

import java.util.List;
import java.util.UUID;

public interface AutomovilDAO {

    Automovil findOne(Long idAutomovil);

    List<Automovil> findAll();
}

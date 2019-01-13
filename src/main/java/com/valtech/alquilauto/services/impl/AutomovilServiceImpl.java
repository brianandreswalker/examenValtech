package com.valtech.alquilauto.services.impl;

import com.valtech.alquilauto.daos.AutomovilDAO;
import com.valtech.alquilauto.entities.Automovil;
import com.valtech.alquilauto.entities.Cliente;
import com.valtech.alquilauto.services.IAutomovilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.MissingResourceException;
import java.util.UUID;

@Service
@Qualifier("automovilService")
public class AutomovilServiceImpl implements IAutomovilService {

    @Autowired
    AutomovilDAO automovilDAO;

    @Override
    public List<Automovil> findAll() {
        return automovilDAO.findAll();
    }

    @Override
    public Automovil findOne(UUID idAutomovil) {
        return automovilDAO.findOne(idAutomovil);
    }

    @Override
    public Automovil addOne(Automovil automovil) {
        if( automovil.getPatente() == null || automovil.getPatente() == "")
            throw new MissingResourceException("El campo patente es necesario para crear un Automovil","","patente");
        return automovilDAO.addOne(new Automovil(automovil.isDisponible(), automovil.getPatente()));
    }

    @Override
    public Automovil findOneByPatente(String patenteAuto) {
        return automovilDAO.findOneByPatente(patenteAuto);
    }
}

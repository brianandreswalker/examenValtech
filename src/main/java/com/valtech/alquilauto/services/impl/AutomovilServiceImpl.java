package com.valtech.alquilauto.services.impl;

import com.valtech.alquilauto.daos.AutomovilDAO;
import com.valtech.alquilauto.entities.Automovil;
import com.valtech.alquilauto.services.IAutomovilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Automovil findOne(Long idAutomovil) {
        return automovilDAO.findOne(idAutomovil);
    }
}

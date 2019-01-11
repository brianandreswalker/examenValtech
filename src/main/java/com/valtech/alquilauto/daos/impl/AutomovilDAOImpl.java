package com.valtech.alquilauto.daos.impl;

import com.valtech.alquilauto.AlquilautoApplication;
import com.valtech.alquilauto.daos.AutomovilDAO;
import com.valtech.alquilauto.entities.Automovil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Qualifier("automovilDAO")
public class AutomovilDAOImpl implements AutomovilDAO {

    @Autowired
    AlquilautoApplication main;

    public Automovil findOne(Long idAutomovil){
        Map<Long, Automovil> automoviles = main.getArrayAutomoviles();
        return automoviles.get(idAutomovil);
    }

    public List<Automovil> findAll(){
        List<Automovil> list = new ArrayList<>(main.getArrayAutomoviles().values());
        return list;
    }
}

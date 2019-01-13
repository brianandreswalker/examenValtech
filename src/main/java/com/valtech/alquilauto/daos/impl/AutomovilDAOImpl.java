package com.valtech.alquilauto.daos.impl;

import com.valtech.alquilauto.AlquilautoApplication;
import com.valtech.alquilauto.daos.AutomovilDAO;
import com.valtech.alquilauto.entities.Automovil;
import com.valtech.alquilauto.entities.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Qualifier("automovilDAO")
public class AutomovilDAOImpl implements AutomovilDAO {

    private static final Logger logger = LoggerFactory.getLogger(AutomovilDAOImpl.class);

    @Autowired
    AlquilautoApplication main;

    public Automovil findOne(UUID idAutomovil){
        logger.info("Buscando un automovil id: " + idAutomovil);
        Map<UUID, Automovil> automoviles = main.getArrayAutomoviles();
        return automoviles.get(idAutomovil);
    }

    public List<Automovil> findAll(){
        logger.info("Buscando todos los Automoviles...");
        List<Automovil> list = new ArrayList<>(main.getArrayAutomoviles().values());
        return list;
    }

    public Automovil addOne(Automovil automovil) {
        logger.info("Agregando un Automovil con patente: " + automovil.getIdAutomovil());
        Map<UUID, Automovil> automoviles = main.getArrayAutomoviles();
        automoviles.put(automovil.getIdAutomovil(), automovil);
        return automovil;
    }

    public Automovil findOneByPatente(String patenteAuto){
        logger.info("Buscando un Automovil con patente: " + patenteAuto);
        Map<UUID, Automovil> automoviles = main.getArrayAutomoviles();
        Automovil automovil = null;

        for (Map.Entry<UUID, Automovil> auto : automoviles.entrySet()) {
            if(auto.getValue().getPatente().equals(patenteAuto))
                automovil = auto.getValue();
        }

        return automovil;
    }

}

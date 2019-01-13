package com.valtech.alquilauto.daos.impl;

import com.valtech.alquilauto.AlquilautoApplication;
import com.valtech.alquilauto.controllers.ClienteController;
import com.valtech.alquilauto.daos.PromocionDAO;
import com.valtech.alquilauto.entities.Promocion;
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
@Qualifier("promocionDAO")
public class PromocionDAOImpl implements PromocionDAO {

    private static final Logger logger = LoggerFactory.getLogger(PromocionDAOImpl.class);

    @Autowired
    AlquilautoApplication main;

    public Promocion findOne(UUID promocionId){
        logger.info("Buscando una Promocion con id: " + promocionId);
        Map<UUID, Promocion> promociones = main.getArrayPromociones();
        return promociones.get(promocionId);
    }

    public Promocion addOne(Promocion promocion) {
        logger.info("Agregando una Promocion con id: " + promocion.getId());
        Map<UUID, Promocion> promociones = main.getArrayPromociones();
        promociones.put(promocion.getId(), promocion);
        return promocion;
    }

    public List<Promocion> findAll(){
        logger.info("Buscando todas las Promociones...");
        List<Promocion> list = new ArrayList<>(main.getArrayPromociones().values());
        return list;
    }
}

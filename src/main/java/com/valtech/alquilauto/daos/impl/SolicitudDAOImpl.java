package com.valtech.alquilauto.daos.impl;

import com.valtech.alquilauto.AlquilautoApplication;
import com.valtech.alquilauto.controllers.ClienteController;
import com.valtech.alquilauto.daos.ClienteDAO;
import com.valtech.alquilauto.daos.SolicitudDAO;
import com.valtech.alquilauto.entities.Automovil;
import com.valtech.alquilauto.entities.Cliente;
import com.valtech.alquilauto.entities.Solicitud;
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
@Qualifier("solicitudDAO")
public class SolicitudDAOImpl implements SolicitudDAO {

    private static final Logger logger = LoggerFactory.getLogger(SolicitudDAOImpl.class);

    @Autowired
    AlquilautoApplication main;

    public Solicitud addOne(Solicitud solicitud) {
        logger.info("Agregando una Solicitud id: " + solicitud.getId());
        Map<UUID, Solicitud> solicitudes = main.getArraySolicitudes();
        solicitudes.put(solicitud.getId(), solicitud);
        return solicitud;
    }

    public List<Solicitud> findAll(){
        logger.info("Buscando todas las Solicitudes...");
        List<Solicitud> list = new ArrayList<>(main.getArraySolicitudes().values());
        return list;
    }

    public Solicitud updateOne(Solicitud solicitud){
        logger.info("Actualizando una Solicitud con id: " + solicitud.getId());
        return solicitud;
    }

    public Solicitud findOne(UUID solicitudId){
        logger.info("Buscando una Solicitud con id: " + solicitudId);
        Map<UUID, Solicitud> solicitudes = main.getArraySolicitudes();
        return solicitudes.get(solicitudId);
    }
}

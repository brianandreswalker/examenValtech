package com.valtech.alquilauto.daos.impl;

import com.valtech.alquilauto.AlquilautoApplication;
import com.valtech.alquilauto.daos.ClienteDAO;
import com.valtech.alquilauto.daos.SolicitudDAO;
import com.valtech.alquilauto.entities.Automovil;
import com.valtech.alquilauto.entities.Cliente;
import com.valtech.alquilauto.entities.Solicitud;
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

    @Autowired
    AlquilautoApplication main;

    public Solicitud addOne(Solicitud solicitud) {
        Map<UUID, Solicitud> solicitudes = main.getArraySolicitudes();
        solicitudes.put(solicitud.getId(), solicitud);
        return solicitud;
    }

    public List<Solicitud> findAll(){
        List<Solicitud> list = new ArrayList<>(main.getArraySolicitudes().values());
        return list;
    }

    public List<Automovil> findAllAutomoviles(){
        List<Automovil> list = new ArrayList<>(main.getArrayAutomoviles().values());
        return list;
    }

    public Solicitud updateOne(Solicitud solicitud){
        return solicitud;
    }

    public Solicitud findOne(UUID solicitudId){
        Map<UUID, Solicitud> solicitudes = main.getArraySolicitudes();
        return solicitudes.get(solicitudId);
    }

    public Automovil findOneAutomovil(Long automovilId){
        Map<Long, Automovil> automoviles = main.getArrayAutomoviles();
        return automoviles.get(automovilId);
    }
}

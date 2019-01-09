package com.valtech.alquilauto.services.impl;

import com.valtech.alquilauto.AlquilautoApplication;
import com.valtech.alquilauto.daos.SolicitudDAO;
import com.valtech.alquilauto.entities.Automovil;
import com.valtech.alquilauto.entities.Cliente;
import com.valtech.alquilauto.entities.Solicitud;
import com.valtech.alquilauto.services.ISolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("solicitudService")
public class SolicitudServiceImpl implements ISolicitudService {

    @Autowired
    AlquilautoApplication main;

    @Autowired
    SolicitudDAO solicitudDAO;

    public Solicitud addOne(Cliente cliente) {
        Solicitud solicitud = new Solicitud(cliente);
        return solicitud;
    }

    public List<Solicitud> findAll(){
        return solicitudDAO.findAll();
    }


    public List<Automovil> findAllAutomoviles(){
        return solicitudDAO.findAllAutomoviles();
    }

    public Solicitud updateOne(Solicitud solicitud){
        return solicitudDAO.updateOne(solicitud);
    }

    public Solicitud findOne(Long solicitudId){
        return solicitudDAO.findOne(solicitudId);
    }

}
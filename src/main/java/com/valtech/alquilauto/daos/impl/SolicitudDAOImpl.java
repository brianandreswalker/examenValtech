package com.valtech.alquilauto.daos.impl;

import com.valtech.alquilauto.AlquilautoApplication;
import com.valtech.alquilauto.daos.SolicitudDAO;
import com.valtech.alquilauto.entities.Automovil;
import com.valtech.alquilauto.entities.Cliente;
import com.valtech.alquilauto.entities.Solicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("solicitudDAO")
public class SolicitudDAOImpl implements SolicitudDAO {

    @Autowired
    AlquilautoApplication main;

    public Solicitud addOne(Cliente cliente) {
        Solicitud solicitud = new Solicitud(cliente);
        main.getArraySolicitudes().add(solicitud);
        return solicitud;
    }

    public List<Solicitud> findAll(){
        return main.getArraySolicitudes();
    }

    public List<Automovil> findAllAutomoviles(){
        return main.getArrayAutomoviles();
    }


    public Solicitud updateOne(Solicitud solicitud){
        return solicitud;
    }

    public Solicitud findOne(Long solicitudId){
        List<Solicitud> solicitudes = main.getArraySolicitudes();
        return solicitudes.get(solicitudes.indexOf(solicitudId));
    }
}

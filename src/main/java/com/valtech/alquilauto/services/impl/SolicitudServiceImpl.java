package com.valtech.alquilauto.services.impl;

import com.valtech.alquilauto.AlquilautoApplication;
import com.valtech.alquilauto.daos.ClienteDAO;
import com.valtech.alquilauto.daos.SolicitudDAO;
import com.valtech.alquilauto.entities.Alquiler;
import com.valtech.alquilauto.entities.Automovil;
import com.valtech.alquilauto.entities.Cliente;
import com.valtech.alquilauto.entities.Solicitud;
import com.valtech.alquilauto.factories.tipoAlquiler.BaseTipoAlquilerFactory;
import com.valtech.alquilauto.factories.tipoAlquiler.ITipoAlquiler;
import com.valtech.alquilauto.factories.tipoAlquiler.impl.TipoAlquilerFactory;
import com.valtech.alquilauto.requests.SolicitudRequest;
import com.valtech.alquilauto.services.IClienteService;
import com.valtech.alquilauto.services.ISolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Qualifier("solicitudService")
public class SolicitudServiceImpl implements ISolicitudService {

    @Autowired
    AlquilautoApplication main;

    @Autowired
    SolicitudDAO solicitudDAO;

    @Autowired
    IClienteService clienteService;

    @Autowired
    BaseTipoAlquilerFactory tipoAlquilerFactory;

    @Override
    public Solicitud addOne(Cliente cliente) {
        Cliente cli;
        Solicitud solicitud = new Solicitud();

        cli = clienteService.findOneByDni(cliente.getDniCliente());

        //Si existe el cliente
        if(cli != null){
            solicitud.setCliente(cli);
        //Si no existe
        } else {
            cli = clienteService.addOne(cliente);
            solicitud.setCliente(cli);
        }

        solicitudDAO.addOne(solicitud);

        if(cli.getSolicitudes() != null){
            cli.getSolicitudes().add(solicitud);
        } else {
            cli.setSolicitudes(new ArrayList<>());
            cli.getSolicitudes().add(solicitud);
        }
        return solicitud;
    }

    @Override
    public List<Solicitud> findAll(){
        return solicitudDAO.findAll();
    }

    @Override
    public List<Automovil> findAllAutomoviles(){
        return solicitudDAO.findAllAutomoviles();
    }

    @Override
    public Solicitud updateOne(SolicitudRequest solicitudRequest){
        Solicitud solicitud = solicitudDAO.findOne(solicitudRequest.getId());
        Alquiler alquiler = solicitud.getAlquiler();

        if( !solicitudRequest.getIdAutomovil().equals("") && solicitudRequest.getIdAutomovil() != null ){
            Automovil automovil = solicitudDAO.findOneAutomovil(solicitudRequest.getIdAutomovil());
            solicitudRequest.setAutomovil(automovil);
        }

        if( alquiler != null && alquiler.getIdTipoAlquiler() != null ){
            ITipoAlquiler tipoAlquiler = tipoAlquilerFactory.createTipoAlquiler(alquiler.getIdTipoAlquiler());
            solicitudRequest.setTipoAlquiler(tipoAlquiler);
        }

        solicitud.getActualState().siguienteState(solicitud, solicitudRequest);
        return solicitudDAO.updateOne(solicitud);
    }

    @Override
    public Solicitud findOne(UUID solicitudId){
        return solicitudDAO.findOne(solicitudId);
    }

}
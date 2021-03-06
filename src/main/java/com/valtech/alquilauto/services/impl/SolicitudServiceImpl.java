package com.valtech.alquilauto.services.impl;

import com.valtech.alquilauto.AlquilautoApplication;
import com.valtech.alquilauto.daos.SolicitudDAO;
import com.valtech.alquilauto.entities.Alquiler;
import com.valtech.alquilauto.entities.Automovil;
import com.valtech.alquilauto.entities.Cliente;
import com.valtech.alquilauto.entities.Solicitud;
import com.valtech.alquilauto.factories.tipoAlquiler.BaseTipoAlquilerFactory;
import com.valtech.alquilauto.factories.tipoAlquiler.ITipoAlquiler;
import com.valtech.alquilauto.requests.SolicitudRequest;
import com.valtech.alquilauto.services.IAutomovilService;
import com.valtech.alquilauto.services.IClienteService;
import com.valtech.alquilauto.services.ISolicitudService;
import com.valtech.alquilauto.states.FinalizadoState;
import javassist.NotFoundException;
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
    IAutomovilService automovilService;

    @Autowired
    BaseTipoAlquilerFactory tipoAlquilerFactory;

    @Override
    public Solicitud addOne(Cliente cliente) {
        Cliente cli;
        Solicitud solicitud = new Solicitud();
        List<Solicitud> clienteSolicitudes = new ArrayList<>();

        if( cliente.getIdCliente() != null && !cliente.getIdCliente().equals("") ){
            cli = clienteService.findOne(cliente.getIdCliente());
        } else {
            cli = clienteService.findOneByDni(cliente.getDniCliente());
        }

        //Si existe el cliente
        if(cli != null){
            solicitud.setCliente(cli);
            clienteSolicitudes = cli.getSolicitudes();
            if(clienteSolicitudes != null && !clienteSolicitudes.isEmpty()){
                for (Solicitud sol : clienteSolicitudes){
                    if(!sol.getActualState().getClass().equals(FinalizadoState.class))
                        throw new IllegalStateException("No se puede crear la Solicitud porque el Cliente posee Solicitudes sin Finalizar.");
                }
            }

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
    public Solicitud updateOne(SolicitudRequest solicitudRequest) throws NotFoundException{
        Solicitud solicitud = solicitudDAO.findOne(solicitudRequest.getId());
        Alquiler alquiler = solicitud.getAlquiler();

        if( !solicitudRequest.getIdAutomovil().equals("") && solicitudRequest.getIdAutomovil() != null ){
            Automovil automovil = automovilService.findOne(solicitudRequest.getIdAutomovil());
            if(automovil!=null){
                solicitudRequest.setAutomovil(automovil);
            } else {
                throw new NotFoundException("El ID de Automovil solicitado no existe");
            }
        }

        if( alquiler != null && alquiler.getIdTipoAlquiler() != null ){
            ITipoAlquiler tipoAlquiler = tipoAlquilerFactory.createTipoAlquiler(solicitudRequest.getIdTipoAlquiler());
            if(tipoAlquiler!=null){
                solicitudRequest.setTipoAlquiler(tipoAlquiler);
            } else {
                throw new NotFoundException("El ID de Tipo de Alquiler solicitado no existe");
            }

        }

        solicitud.getActualState().siguienteState(solicitud, solicitudRequest);
        return solicitudDAO.updateOne(solicitud);
    }

    @Override
    public Solicitud findOne(UUID solicitudId){
        return solicitudDAO.findOne(solicitudId);
    }

}
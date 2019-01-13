package com.valtech.alquilauto.controllers;

import com.valtech.alquilauto.entities.Cliente;
import com.valtech.alquilauto.entities.Solicitud;
import com.valtech.alquilauto.requests.SolicitudRequest;
import com.valtech.alquilauto.services.ISolicitudService;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("solicitudes")
public class SolicitudController {

    private static final Logger logger = LoggerFactory.getLogger(SolicitudController.class);

    @Autowired
    ISolicitudService solicitudService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Solicitud> findAll(){
        logger.info("GET / All Solicitudes");
        return solicitudService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findOne(@PathVariable UUID id){
        logger.info("GET / Solicitud id: " + id);
        try {
            Solicitud solicitud = solicitudService.findOne(id);
            if(solicitud == null)
                throw new NotFoundException("La Solicitud no existe");
            return new ResponseEntity<Solicitud>(solicitud, HttpStatus.OK);
        } catch (NotFoundException exc) {
            logger.info("Error en la busqueda. La Solicitud no existe");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            logger.info("Error en el servicio : " + exception.getMessage());
            return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addOne(@RequestBody Cliente cliente){
        logger.info("POST / Creacion de la Solicitud request de cliente: " + cliente.toString());
        try {
            Solicitud solicitud = solicitudService.addOne(cliente);
            return new ResponseEntity<Solicitud>(solicitud, HttpStatus.CREATED);
        } catch (Exception exception) {
            logger.info("Error en el servicio : " + exception.getMessage());
            return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody SolicitudRequest solicitudRequest, @PathVariable String id) throws NotFoundException {
        logger.info("PUT / Update Solicitud id: " + id);
        Solicitud solicitud = solicitudService.findOne(UUID.fromString(id));
        try {
            if(solicitud == null)
                throw new NotFoundException("Error en la busqueda. La Solicitud no existe");
            solicitudRequest.setId(UUID.fromString(id));
            solicitud = solicitudService.updateOne(solicitudRequest);
            return new ResponseEntity<Solicitud>(solicitud, HttpStatus.OK);
        } catch (NotFoundException exception) {
            logger.info(exception.getMessage());
            return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
        }  catch (Exception exception) {
            logger.info("Error en el servicio : " + exception.getMessage());
            return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
